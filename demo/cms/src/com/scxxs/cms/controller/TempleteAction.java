package com.scxxs.cms.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.nutz.dao.Cnd;
import org.nutz.ioc.annotation.InjectName;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.json.Json;
import org.nutz.json.JsonFormat;
import org.nutz.mvc.View;
import org.nutz.mvc.annotation.AdaptBy;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.Param;
import org.nutz.mvc.upload.TempFile;
import org.nutz.mvc.upload.UploadAdaptor;
import org.nutz.mvc.view.JspView;

import com.scxxs.cms.model.PageModel;
import com.scxxs.cms.model.Templete;
import com.scxxs.cms.model.selector.TemplateType;
import com.scxxs.cms.utils.SystemContext;

/**
 * 模版管理Action
 * 
 * @author Administrator
 * 
 */
@IocBean
@InjectName
public class TempleteAction extends BaseAction {

	/**
	 * 把String转成enum
	 * 
	 * @param type
	 *            String
	 * @return enum
	 */
	private TemplateType compare(String type) {

		TemplateType t = null;

		if ("ABOUT".equalsIgnoreCase(type)) {
			t = TemplateType.ABOUT;
		} else if ("CACAT".equalsIgnoreCase(type)) {
			t = TemplateType.CACAT;
		} else if ("DETAIL".equalsIgnoreCase(type)) {
			t = TemplateType.DETAIL;
		} else if ("LIST".equalsIgnoreCase(type)) {
			t = TemplateType.LIST;
		} else if ("MESSAGE".equalsIgnoreCase(type)) {
			t = TemplateType.MESSAGE;
		} else if ("DOWNLOAD".equalsIgnoreCase(type)) {
			t = TemplateType.DOWNLOAD;
		} else if ("GROUP".equalsIgnoreCase(type)) {
			t = TemplateType.GROUP;
		}

		return t;
	}

	@At("/admin/templete/add")
	@Ok("Json")
	public String save(@Param("::t.") Templete t, @Param("type") String type) {

		t.setType(compare(type));

		boolean flag = false;

		if (t.getId() == 0) {
			t.setCreateDate(new Date());// 设置模板创建时间，不可修改
			t = basicDao.save(t);
			flag = true;
		} else {
			flag = basicDao.update(t);
		}

		if (flag) {
			return "[{success:true}," + Json.toJson(t, JsonFormat.full()) + "]";
		}

		return "[{success:false}]";
	}

	/**
	 * 模板上传
	 * 
	 * @param ioc
	 * @return
	 * @throws IOException
	 */
	@At("/admin/templete/upload")
	@AdaptBy(type = UploadAdaptor.class, args = { "./tmp" })
	public void uploadTemplate(@Param("template") TempFile tf, 
			@Param("type") String type, ServletContext context,
			HttpServletResponse resp) throws IOException {

		File file = tf.getFile();

		String prefix = new SimpleDateFormat("yyyyMMddHHmmss")
				.format(new Date());

		String filename = file.getName(); // 获取文件名

		String relpath = context.getRealPath("/");

		String dir = "upload";

		String uppath = dir + "/" + prefix + filename;

		boolean flag = true;

		File dirs = new File(relpath + dir);

		if (!dirs.exists()) {
			flag = dirs.mkdirs();
		}

		File newFile = new File(relpath + uppath);

		String data = "[{ret:0}]";

		if (newFile.exists()) {
			data = "[{ret:1}]";
		} else {
			if (flag && file.renameTo(newFile)) {
				data = "[{ret:2},{file:'" + uppath + "'}]";
			}

		}

		resp.setContentType("text/html");
		resp.getWriter().print(data);

	}

	/**
	 * 分页查询出所有的模板信息
	 * 
	 * @param ioc
	 * @param currentPage
	 * @param type
	 * @return
	 */
	@At("/admin/templete")
	public View list(@Param("currentPage") int currentPage,
			String type, HttpServletRequest req) {

		// TempleteDao dao = new TempleteDao(ioc);
		List<Templete> result = null;
		int count = 0;
		if (type != null && !"".equals(type)) {

			TemplateType t = compare(type);

			result = basicDao.searchByPage(Templete.class,
					Cnd.where("type", "=", t).desc("createDate"), currentPage,
					SystemContext.PAGE_SIZE);
			count = basicDao.searchCount(Templete.class,
					Cnd.where("type", "=", t));
		} else {
			result = basicDao.searchByPage(Templete.class, currentPage,
					SystemContext.PAGE_SIZE, "createDate");
			count = basicDao.searchCount(Templete.class);
		}

		int maxPage = basicDao.maxPageSize(count, SystemContext.PAGE_SIZE);

		PageModel<Templete> pm = new PageModel<Templete>();
		pm.setMaxPage(maxPage);
		pm.setResult(result);

		req.setAttribute("pm", pm);

		return new JspView("admin.templete");
	}

	/**
	 * 根据id删除数据信息
	 * 
	 * @param id
	 * @param ioc
	 * @return
	 */
	@At("/admin/templete/del")
	@Ok("json")
	public String del(@Param("id") int id,
			@Param("currentPage") int currentPage, ServletContext context) {

		// TempleteDao dao = new TempleteDao(ioc);

		int count = basicDao.searchCount(Templete.class);
		int maxPage = basicDao.maxPageSize(count, SystemContext.PAGE_SIZE);

		String path = context.getRealPath("/");

		Templete temp = basicDao.find(id, Templete.class);

		if (temp != null) {
			File file = new File(path + "/" + temp.getFilePath());
			if (file.exists()) {
				file.delete();
			}
			temp = null;
		}

		StringBuffer sb = new StringBuffer("[");
		if (maxPage > 1) {
			List<Templete> ts = basicDao.searchByPage(Templete.class,
					(currentPage + 1), SystemContext.PAGE_SIZE, "id");
			for (Templete t : ts) {
				sb.append(Json.toJson(t));
				// 第一次执行完就停止执行
				break;
			}
		}
		sb.append("]");

		if (basicDao.delById(id, Templete.class)) {
			return sb.toString();
		} else {
			return "[]";
		}
	}

	/**
	 * 根据id查找数据
	 * 
	 * @param id
	 * @param ioc
	 * @return
	 */
	@At("/admin/templete/find")
	@Ok("json")
	public String find(@Param("id") int id) {

		// TempleteDao dao = new TempleteDao(ioc);

		Templete t = basicDao.find(id, Templete.class);

		StringBuffer sb = new StringBuffer();
		if (t != null) {
			sb.append(Json.toJson(t));
		} else {
			sb.append("{id:0}");
		}
		return sb.toString();
	}

	/**
	 * 根据ids删除数据信息
	 * 
	 * @param ids
	 * @param ioc
	 * @return
	 */
	@At("/admin/templete/delByIds")
	@Ok("json")
	public String delByIds(@Param("ids") String ids,
			@Param("currentPage") int currentPage, @Param("size") int size,
			ServletContext context) {

		// TempleteDao dao = new TempleteDao(ioc);

		List<Templete> templates = basicDao.searchByIds(Templete.class, ids,
				"id");

		String path = context.getRealPath("/");

		for (Templete temp : templates) {
			if (temp != null) {
				File file = new File(path + "/" + temp.getFilePath());
				if (file.exists()) {
					file.delete();
				}
				temp = null;
			}
		}

		int count = basicDao.searchCount(Templete.class);
		int maxPage = basicDao.maxPageSize(count, SystemContext.PAGE_SIZE);
		String str = "";
		StringBuffer sb = new StringBuffer("[");
		if (maxPage > 1) {
			List<Templete> ts = basicDao.searchByPage(Templete.class,
					(currentPage + 1), SystemContext.PAGE_SIZE, "id");
			int i = 0;
			for (Templete t : ts) {
				if (i == size) {
					break;
				} else {
					sb.append(Json.toJson(t)).append(",");
					i++;
				}
			}
		}
		str = sb.toString();
		int dot = str.lastIndexOf(",");
		if (dot != -1) {
			str = str.substring(0, dot);
		}

		basicDao.deleteByIds(Templete.class, ids);

		return str + "]";
	}

	/**
	 * 根据类型查询出模板信息
	 * 
	 * @param type
	 * @return
	 */
	@At("/admin/templete/bytype")
	@Ok("Json")
	public String searchByType(@Param("type") int type) {

		// TempleteDao dao = new TempleteDao(ioc);

		TemplateType t = null;

		switch (type) {
		case 0:
			t = TemplateType.ABOUT;
			break;
		case 1:
			t = TemplateType.CACAT;
			break;
		case 2:
			t = TemplateType.DETAIL;
			break;
		case 3:
			t = TemplateType.LIST;
			break;
		case 4:
			t = TemplateType.MESSAGE;
			break;
		case 5:
			t = TemplateType.DOWNLOAD;
			break;
		case 6:
			t = TemplateType.GROUP;
			break;
		default:
			break;
		}

		List<Templete> ts = null;
		if (t != null) {
			ts = basicDao.search(Templete.class, Cnd.where("type", "=", t)
					.desc("id"));
		} else {
			ts = basicDao.search(Templete.class, "id");
		}

		return Json.toJson(ts);
	}
}
