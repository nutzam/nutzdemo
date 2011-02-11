package com.scxxs.cms.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.nutz.ioc.Ioc;
import org.nutz.ioc.annotation.InjectName;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.View;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.Param;
import org.nutz.mvc.view.JspView;

import com.scxxs.cms.dao.ManagerDao;
import com.scxxs.cms.model.Manager;
import com.scxxs.cms.model.PageModel;
import com.scxxs.cms.model.Role;
import com.scxxs.cms.utils.SystemContext;

/**
 * 角色管理Action
 * 
 * @author Administrator
 * 
 */
@IocBean
@InjectName
public class RoleAction extends BaseAction {
	
	@Inject
	ManagerDao managerDao;
	
	/**
	 * 分页查询出角色信息
	 * 
	 * @param currentPage
	 * @param pageSize
	 * @param ioc
	 * @return
	 */
	@At("/admin/role")
	public View list(@Param("currentPage") int currentPage, Ioc ioc,
			HttpServletRequest req) {

		if (currentPage == 0) {
			currentPage = 1;
		}

//		RoleDaobasicDao = new RoleDao(ioc);

		List<Role> roles =basicDao.searchByPage(Role.class, currentPage,
				SystemContext.PAGE_SIZE, "id");

		int count =basicDao.searchCount(Role.class);

		int maxPage =basicDao.maxPageSize(count, SystemContext.PAGE_SIZE);

		PageModel<Role> pm = new PageModel<Role>(roles, maxPage);

		req.setAttribute("pm", pm);

		return new JspView("admin.role");
	}

	/**
	 * 添加一条数据信息
	 * 
	 * @param role
	 * @param ioc
	 * @return
	 */
	@At("/admin/role/add")
	@Ok("json")
	public String add(@Param("::role.") Role role, Ioc ioc) {

//		RoleDaobasicDao = new RoleDao(ioc);

		boolean flag = false;

		if (role.getId() == 0) {
			role =basicDao.save(role);
			flag = !flag;
		} else {
			if (basicDao.update(role)) {
				flag = !flag;
			}
		}

		StringBuffer sb = new StringBuffer("{");
		if (role != null) {
			sb.append("id:").append(role.getId()).append(",");
			sb.append("name:'").append(role.getName()).append("',");
			sb.append("rule:").append(role.getRule());
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
	@At("/admin/role/del")
	@Ok("json")
	public String del(@Param("id") int id,@Param("currentPage") int currentPage,Ioc ioc) {
		
//		RoleDaobasicDao = new RoleDao(ioc);
		
		int count =basicDao.searchCount(Role.class);
		int maxPage =basicDao.maxPageSize(count, SystemContext.PAGE_SIZE);
		
		StringBuffer sb = new StringBuffer("[");
		if (maxPage > 1) {
			List<Role> roles =basicDao.searchByPage(Role.class, (currentPage + 1),SystemContext.PAGE_SIZE, "id");
			for (Role role : roles) {
				sb.append("{");
				sb.append("id:").append(role.getId()).append(",");
				sb.append("name:'").append(role.getName()).append("',");
				sb.append("rule:").append(role.getRule());
				sb.append("}");
				//第一次执行完就停止执行
				break;
			}
		}
		sb.append("]");
		
		if (basicDao.delById(id, Role.class)) {	
			return sb.toString();
		}else{
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
	@At("/admin/role/delByIds")
	@Ok("json")
	public String delByIds(@Param("ids") String ids, Ioc ioc,
			@Param("currentPage") int currentPage, @Param("size") int size) {

//		RoleDaobasicDao = new RoleDao(ioc);

		int count =basicDao.searchCount(Role.class);
		int maxPage =basicDao.maxPageSize(count, SystemContext.PAGE_SIZE);
		String str ="";
		StringBuffer sb = new StringBuffer("[");
		if (maxPage > 1) {
			List<Role> roles =basicDao.searchByPage(Role.class, (currentPage + 1),SystemContext.PAGE_SIZE, "id");
			int i=0;
			for (Role role : roles) {
				if(i==size){
					break;
				}else{
					sb.append("{");
					sb.append("id:").append(role.getId()).append(",");
					sb.append("name:'").append(role.getName()).append("',");
					sb.append("rule:").append(role.getRule());
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
		basicDao.deleteByIds(Role.class, ids);
		
		return str+"]";
	}

	/**
	 * 根据id查找数据
	 * 
	 * @param id
	 * @param ioc
	 * @return
	 */
	@At("/admin/role/find")
	@Ok("json")
	public String find(@Param("id") int id, Ioc ioc) {

//		RoleDaobasicDao = new RoleDao(ioc);

		Role role =basicDao.find(id, Role.class);

		StringBuffer sb = new StringBuffer("{");
		if (role != null) {
			sb.append("id:").append(role.getId()).append(",");
			sb.append("name:'").append(role.getName()).append("',");
			sb.append("rule:").append(role.getRule());
		} else {
			sb.append("id:").append(0);
		}
		sb.append("}");

		return sb.toString();
	}
	/**
	 * 分配权限
	 * @param ioc
	 * @param id
	 * @param req
	 * @return
	 */
	@At("/admin/role/permission")
	public View setPermission(Ioc ioc,@Param("id") int id,HttpServletRequest req){
		
//		RoleDaobasicDao = new RoleDao(ioc);
		
		Role role =basicDao.find(id, Role.class);
		
		role =basicDao.findLink(role, "permission");
		
		req.setAttribute("role", role);
		
		return new JspView("admin.permission");
	}
	
	@At("/admin/role/set")
	public View setRole(Ioc ioc,@Param("uid") int uid,HttpServletRequest req){
		Manager m = managerDao.find(uid, Manager.class);
		
		m = managerDao.findLink(m, "roles");
		
		req.setAttribute("m", m);
		
//		RoleDao rdao = new RoleDao(ioc);
		
		List<Role> roles = basicDao.search(Role.class, "rule");
		req.setAttribute("roles", roles);
		
		return new JspView("admin.listRole");
	}
}
