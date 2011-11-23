package com.scxxs.cms.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

import com.scxxs.cms.model.IndexPic;
import com.scxxs.cms.model.PageModel;
import com.scxxs.cms.utils.SystemContext;

/**
 * 首页图片管理
 * 
 * @author Administrator
 * 
 */
@IocBean
@InjectName
public class IndexPicAction extends BaseAction {

	/**
	 * 上传首页图片文件
	 * 
	 * @param tf
	 * @param context
	 * @param resp
	 * @throws IOException
	 */
	@At("/admin/indexpic/upload")
	@AdaptBy(type = UploadAdaptor.class, args = { "./tmp" })
	public void upload(@Param("template") TempFile tf, ServletContext context,
			HttpServletResponse resp) throws IOException {

		File file = tf.getFile();

		String filename = file.getName(); // 获取文件名

		String relpath = context.getRealPath("/");

		String prefix = new SimpleDateFormat("yyyyMMddHHmmss")
				.format(new Date());

		String uppath = "indexpic/" + prefix + filename;

		boolean flag = true;

		File dirs = new File(relpath + "indexpic");

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
	 * 保存首页图片信息
	 * 
	 * @param pic
	 * @param ioc
	 * @return
	 */
	@At("/admin/indexpic/add")
	@Ok("Json")
	public String save(@Param("::pic.") IndexPic pic) {

		boolean flag = false;

		if (pic.getId() == 0) {
			pic = basicDao.save(pic);
			flag = true;
		} else {
			flag = basicDao.update(pic);
		}

		if (flag) {
			return "[{success:true}," + Json.toJson(pic, JsonFormat.full())
					+ "]";
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
	@At("/admin/indexpic/del")
	@Ok("json")
	public String del(@Param("id") int id,
			@Param("currentPage") int currentPage, ServletContext context) {

		// IndexPicDao dao = new IndexPicDao(ioc);

		int count = basicDao.searchCount(IndexPic.class);
		int maxPage = basicDao.maxPageSize(count, SystemContext.PAGE_SIZE);

		String path = context.getRealPath("/");

		IndexPic pic = basicDao.find(id, IndexPic.class);

		if (pic != null) {
			File file = new File(path + "/" + pic.getPic());
			if (file.exists()) {
				file.delete();
			}
			pic = null;
		}

		StringBuffer sb = new StringBuffer("[");
		if (maxPage > 1) {
			List<IndexPic> pics = basicDao.searchByPage(IndexPic.class,
					(currentPage + 1), SystemContext.PAGE_SIZE, "sortNumber");
			for (IndexPic p : pics) {
				sb.append(Json.toJson(p));
				// 第一次执行完就停止执行
				break;
			}
		}
		sb.append("]");

		if (basicDao.delById(id, IndexPic.class)) {
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
	@At("/admin/indexpic/delByIds")
	@Ok("json")
	public String delByIds(@Param("ids") String ids,
			@Param("currentPage") int currentPage, @Param("size") int size,
			ServletContext context) {

		// IndexPicDao dao = new IndexPicDao(ioc);

		List<IndexPic> pics = basicDao.searchByIds(IndexPic.class, ids,
				"sortNumber");

		String path = context.getRealPath("/");

		for (IndexPic temp : pics) {
			if (temp != null) {
				File file = new File(path + "/" + temp.getPic());
				if (file.exists()) {
					file.delete();
				}
				temp = null;
			}
		}

		int count = basicDao.searchCount(IndexPic.class);
		int maxPage = basicDao.maxPageSize(count, SystemContext.PAGE_SIZE);
		String str = "";
		StringBuffer sb = new StringBuffer("[");
		if (maxPage > 1) {
			List<IndexPic> pices = basicDao.searchByPage(IndexPic.class,
					(currentPage + 1), SystemContext.PAGE_SIZE, "sortNumber");
			int i = 0;
			for (IndexPic t : pices) {
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

		basicDao.deleteByIds(IndexPic.class, ids);

		return str + "]";
	}

	/**
	 * 分页查询出所有的模板信息
	 * 
	 * @param ioc
	 * @param currentPage
	 * @param type
	 * @return
	 */
	@At("/admin/indexpic")
	public View list(@Param("currentPage") int currentPage,
			String type, HttpServletRequest req) {

		// IndexPicDao dao = new IndexPicDao(ioc);

		List<IndexPic> result = basicDao.searchByPage(IndexPic.class,
				currentPage, SystemContext.PAGE_SIZE, "sortNumber");
		int count = basicDao.searchCount(IndexPic.class);

		int maxPage = basicDao.maxPageSize(count, SystemContext.PAGE_SIZE);

		PageModel<IndexPic> pm = new PageModel<IndexPic>();
		pm.setMaxPage(maxPage);
		pm.setResult(result);

		req.setAttribute("pm", pm);

		return new JspView("admin.indexpic");
	}

	/**
	 * 根据id查询
	 * 
	 * @param ioc
	 * @param id
	 * @return
	 */
	@At("/admin/indexpic/find")
	@Ok("json")
	public String findone(@Param("id") int id) {
		// IndexPicDao dao = new IndexPicDao(ioc);
		return Json.toJson(basicDao.find(id, IndexPic.class));
	}
}
