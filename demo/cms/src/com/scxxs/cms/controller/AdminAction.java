package com.scxxs.cms.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.nutz.dao.Chain;
import org.nutz.dao.Cnd;
import org.nutz.ioc.annotation.InjectName;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.View;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.Param;
import org.nutz.mvc.view.JspView;
import org.nutz.mvc.view.ViewWrapper;

import com.scxxs.cms.dao.ManagerDao;
import com.scxxs.cms.model.Manager;
import com.scxxs.cms.model.PageModel;
import com.scxxs.cms.model.Role;
import com.scxxs.cms.utils.DateConvertUtil;
import com.scxxs.cms.utils.SystemContext;

/**
 * 管理员管理Action
 * 
 * @author Administrator
 * 
 */
@IocBean
@InjectName
public class AdminAction extends BaseAction {

	@Inject
	private ManagerDao dao;

	@At("/admin")
	@Ok("jsp:admin.index")
	public void loginForm() {
	}

	/**
	 * 管理员登录
	 * 
	 * @param username
	 *            用户名
	 * @param password
	 *            密码
	 * @param ioc
	 *            ioc容器
	 * @param req
	 *            HttpServletRequest
	 * @return View
	 */
	@At("/admin/login")
	public View login(@Param("username") String username,
			@Param("password") String password, HttpServletRequest req) {

		// ManagerDao dao = new ManagerDao(ioc);

		Manager m = dao.login(username, password);
		if (m != null && m.isState()) {

			m = dao.findLink(m, "roles");

			List<Role> roles = m.getRoles();
			List<Role> temp = new ArrayList<Role>();
			for (Role r : roles) {
				r = dao.findLink(r, "permission");
				temp.add(r);
			}
			m.setRoles(temp);
			roles = null;// 释放资源

			req.getSession().setAttribute("admin", m);

			if (m.getLoginTime() != null) {
				m.setLastLoginTime(m.getLoginTime());
			}
			if (m.getLoginIp() != null) {
				m.setLastLoginIp(m.getLoginIp());
			}
			m.setLoginTime(new Date());
			m.setLoginIp(req.getRemoteAddr());
			m.setLogintimes(m.getLogintimes() + 1);

			dao.update(m);

			return new ViewWrapper(new JspView("admin.main"), m);
		} else {
			if (m == null) {
				req.setAttribute("error", "用户名或者密码错误！");
			} else {
				req.setAttribute("error", "用户已经被禁用！");
			}
			return new JspView("admin.index");
		}
	}

	@At("/admin/logout")
	@Ok("redirect:/")
	public void logout(HttpServletRequest req) {
		req.getSession().invalidate();
	}

	/**
	 * 分页查询出角色信息
	 * 
	 * @param currentPage
	 * @param pageSize
	 * @param ioc
	 * @return
	 */
	@At("/admin/user")
	@Ok("jsp:admin.user")
	public void list(@Param("currentPage") int currentPage,
			HttpServletRequest req) {

		if (currentPage == 0) {
			currentPage = 1;
		}

		// ManagerDao dao = new ManagerDao(ioc);

		List<Manager> users = dao.searchByPage(Manager.class, currentPage,
				SystemContext.PAGE_SIZE, "id");

		int count = dao.searchCount(Manager.class);

		int maxPage = dao.maxPageSize(count, SystemContext.PAGE_SIZE);

		PageModel<Manager> pm = new PageModel<Manager>(users, maxPage);

		req.setAttribute("pm", pm);
	}

	/**
	 * 添加一条数据信息
	 * 
	 * @param user
	 * @param ioc
	 * @return
	 */
	@At("/admin/user/add")
	@Ok("json")
	public String add(@Param("::user.") Manager user) {

		// ManagerDao dao = new ManagerDao(ioc);

		boolean flag = false;

		if (user.getId() == 0) {
			user = dao.save(user);
			flag = !flag;
		} else {
			if (dao.update(user)) {
				flag = !flag;
			}
		}

		StringBuffer sb = new StringBuffer("{");
		if (user != null) {
			sb.append("id:").append(user.getId()).append(",");
			sb.append("username:'").append(user.getUsername()).append("',");
			sb.append("password:'").append(user.getPassword()).append("',");
			Date date = user.getLastLoginTime();
			sb.append("loginTime:'");
			if (date != null) {
				sb.append(DateConvertUtil.convertDate(date, null)).append("'");
			} else {
				sb.append("'");
			}
			sb.append(",");
			sb.append("logintimes:").append(user.getLogintimes()).append(",");
			sb.append("state:").append(user.isState());
		} else {
			sb.append("id:").append(0);
		}
		sb.append("}");

		if (flag) {
			return "[{success:true}," + sb.toString() + "]";
		}

		return "[{success:false}]";
	}

	/**
	 * 根据id删除数据信息
	 * 
	 * @param id
	 * @param ioc
	 * @return
	 */
	@At("/admin/user/del")
	@Ok("json")
	public String del(@Param("id") int id, @Param("currentPage") int currentPage) {

		// ManagerDao dao = new ManagerDao(ioc);

		int count = dao.searchCount(Manager.class);
		int maxPage = dao.maxPageSize(count, SystemContext.PAGE_SIZE);

		StringBuffer sb = new StringBuffer("[");
		if (maxPage > 1) {
			List<Manager> users = dao.searchByPage(Manager.class,
					(currentPage + 1), SystemContext.PAGE_SIZE, "id");
			for (Manager user : users) {
				sb.append("{");
				sb.append("id:").append(user.getId()).append(",");
				sb.append("username:'").append(user.getUsername()).append("',");
				sb.append("password:'").append(user.getPassword()).append("',");
				Date date = user.getLastLoginTime();
				sb.append("loginTime:'");
				if (date != null) {
					sb.append(DateConvertUtil.convertDate(date, null)).append(
							"'");
				} else {
					sb.append("'");
				}
				sb.append(",");
				sb.append("logintimes:").append(user.getLogintimes())
						.append(",");
				sb.append("state:").append(user.isState());
				sb.append("}");
				// 第一次执行完就停止执行
				break;
			}
		}
		sb.append("]");

		if (dao.delById(id, Manager.class)) {
			return sb.toString();
		} else {
			return "[]";
		}
	}

	/**
	 * 根据ids删除数据信息
	 * 
	 * @param ids
	 * @param ioc
	 * @return
	 */
	@At("/admin/user/delByIds")
	@Ok("json")
	public String delByIds(@Param("ids") String ids,
			@Param("currentPage") int currentPage, @Param("size") int size) {

		// ManagerDao dao = new ManagerDao(ioc);

		int count = dao.searchCount(Manager.class);
		int maxPage = dao.maxPageSize(count, SystemContext.PAGE_SIZE);
		String str = "";
		StringBuffer sb = new StringBuffer("[");
		if (maxPage > 1) {
			List<Manager> users = dao.searchByPage(Manager.class,
					(currentPage + 1), SystemContext.PAGE_SIZE, "id");
			int i = 0;
			for (Manager user : users) {
				if (i == size) {
					break;
				} else {
					sb.append("{");
					sb.append("id:").append(user.getId()).append(",");
					sb.append("username:'").append(user.getUsername())
							.append("',");
					sb.append("password:'").append(user.getPassword())
							.append("',");
					Date date = user.getLastLoginTime();
					sb.append("loginTime:'");
					if (date != null) {
						sb.append(DateConvertUtil.convertDate(date, null))
								.append("'");
					} else {
						sb.append("'");
					}
					sb.append(",");
					sb.append("logintimes:").append(user.getLogintimes())
							.append(",");
					sb.append("state:").append(user.isState());
					sb.append("},");
					i++;
				}
			}
		}
		str = sb.toString();
		int dot = str.lastIndexOf(",");
		if (dot != -1) {
			str = str.substring(0, dot);
		}
		dao.deleteByIds(Manager.class, ids);

		return str + "]";
	}

	/**
	 * 根据id查找数据
	 * 
	 * @param id
	 * @param ioc
	 * @return
	 */
	@At("/admin/user/find")
	@Ok("json")
	public String find(@Param("id") int id) {

		// ManagerDao dao = new ManagerDao(ioc);

		Manager user = dao.find(id, Manager.class);

		StringBuffer sb = new StringBuffer("{");
		if (user != null) {
			sb.append("id:").append(user.getId()).append(",");
			sb.append("username:'").append(user.getUsername()).append("',");
			sb.append("password:'").append(user.getPassword()).append("',");
			Date date = user.getLastLoginTime();
			sb.append("loginTime:'");
			if (date != null) {
				sb.append(DateConvertUtil.convertDate(date, null)).append("'");
			} else {
				sb.append("'");
			}
			sb.append(",");
			sb.append("logintimes:").append(user.getLogintimes()).append(",");
			sb.append("state:").append(user.isState());
		} else {
			sb.append("id:").append(0);
		}
		sb.append("}");

		return sb.toString();
	}

	/**
	 * 根据id修改密码
	 * 
	 * @param id
	 * @param ioc
	 * @return
	 */
	@At("/admin/user/toupdatepwd")
	public View toupdatepwd() {
		return new JspView("admin.updatepwd");
	}

	/**
	 * 根据id修改密码
	 * 
	 * @param id
	 * @param ioc
	 * @return
	 */
	@At("/admin/user/updatepwd")
	@Ok("json")
	public String updatepwd(@Param("::user.") Manager user,
			@Param("oldpwd") String oldpwd, HttpServletRequest req) {
		// ManagerDao dao = new ManagerDao(ioc);
		Manager man = dao.find(user.getId(), Manager.class);
		if (!man.getPassword().equals(oldpwd)) {
			return "{success:false}";
		}

		user.setState(true);
		boolean flag = dao.update(user);
		return "{success:" + flag + "}";
	}

	/**
	 * 分配角色
	 * 
	 * @param id
	 * @param role
	 * @param action
	 * @param ioc
	 * @return
	 */
	@At("/admin/user/role")
	@Ok("Json")
	public String setRole(@Param("id") int id, @Param("role") int role,
			@Param("action") boolean action) {

		// BasicDao dao = new BasicDao(ioc);

		if (action) {
			dao.save("t_manager_role",
					Chain.make("manager_id", id).add("role_id", role));
		} else {
			dao.delete("t_manager_role",
					Cnd.where("manager_id", "=", id).and("role_id", "=", role));
		}

		return "{success:true}";

	}
}
