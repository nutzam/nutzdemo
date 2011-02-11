package com.scxxs.cms.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.nutz.ioc.Ioc;
import org.nutz.ioc.annotation.InjectName;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.json.Json;
import org.nutz.json.JsonFormat;
import org.nutz.mvc.View;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.Param;
import org.nutz.mvc.view.JspView;

import com.scxxs.cms.model.ArticleType;
import com.scxxs.cms.model.PageModel;
import com.scxxs.cms.utils.SystemContext;

/**
 * 文章类型Action
 * 
 * @author Administrator
 * 
 */
@IocBean
@InjectName
public class ArticleTypeAction extends BaseAction{

	/**
	 * 查询出所有的文章分类返回json格式
	 * 
	 * @param ioc
	 * @return
	 */
	@At("/admin/articletype/all")
	@Ok("json")
	public String listAll(Ioc ioc) {

//		ArticleTypeDao dao = new ArticleTypeDao(ioc);

		List<ArticleType> t = basicDao.search(ArticleType.class, "id");

		return Json.toJson(t, JsonFormat.full());
	}

	/**
	 * 分页查询出文章分类信息
	 * 
	 * @param ioc
	 * @param req
	 * @param currentPage
	 */
	@At("/admin/articletype")
	public View list(Ioc ioc, HttpServletRequest req,
			@Param("currentPage") int currentPage) {

//		ArticleTypeDao dao = new ArticleTypeDao(ioc);

		List<ArticleType> t = basicDao.searchByPage(ArticleType.class, currentPage,
				SystemContext.PAGE_SIZE, "id");

		int count = basicDao.searchCount(ArticleType.class);

		int maxPage = basicDao.maxPageSize(count, SystemContext.PAGE_SIZE);

		PageModel<ArticleType> pm = new PageModel<ArticleType>(t, maxPage);

		req.setAttribute("pm", pm);

		return new JspView("admin.articletype");

	}

	/**
	 * 添加一条数据信息
	 * 
	 * @param role
	 * @param ioc
	 * @return
	 */
	@At("/admin/articletype/add")
	@Ok("json")
	public String add(@Param("::articletype.") ArticleType type, Ioc ioc) {

//		ArticleTypeDao dao = new ArticleTypeDao(ioc);

		boolean flag = false;

		if (type.getId() == 0) {
			type = basicDao.save(type);
			flag = !flag;
		} else {
			if (basicDao.update(type)) {
				flag = !flag;
			}
		}
		if (flag) {
			return "[{success:true}," + Json.toJson(type) + "]";
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
	@At("/admin/articletype/del")
	@Ok("json")
	public String del(@Param("id") int id,
			@Param("currentPage") int currentPage, Ioc ioc) {

//		ArticleTypeDao dao = new ArticleTypeDao(ioc);

		int count = basicDao.searchCount(ArticleType.class);
		int maxPage = basicDao.maxPageSize(count, SystemContext.PAGE_SIZE);

		StringBuffer sb = new StringBuffer("[");
		if (maxPage > 1) {
			List<ArticleType> types = basicDao.searchByPage(ArticleType.class,
					(currentPage + 1), SystemContext.PAGE_SIZE, "id");
			for (ArticleType type : types) {
				sb.append(Json.toJson(type));
				// 第一次执行完就停止执行
				break;
			}
		}
		sb.append("]");

		if (basicDao.delById(id, ArticleType.class)) {
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
	@At("/admin/articletype/delByIds")
	@Ok("json")
	public String delByIds(@Param("ids") String ids, Ioc ioc,
			@Param("currentPage") int currentPage, @Param("size") int size) {

//		ArticleTypeDao dao = new ArticleTypeDao(ioc);

		int count = basicDao.searchCount(ArticleType.class);
		int maxPage = basicDao.maxPageSize(count, SystemContext.PAGE_SIZE);
		String str = "";
		StringBuffer sb = new StringBuffer("[");
		if (maxPage > 1) {
			List<ArticleType> types = basicDao.searchByPage(ArticleType.class,
					(currentPage + 1), SystemContext.PAGE_SIZE, "id");
			int i = 0;
			for (ArticleType type : types) {
				if (i == size) {
					break;
				} else {
					sb.append(Json.toJson(type));
					sb.append(",");
					i++;
				}
			}
		}
		str = sb.toString();
		int dot = str.lastIndexOf(",");
		if (dot != -1) {
			str = str.substring(0, dot);
		}
		basicDao.deleteByIds(ArticleType.class, ids);

		return str + "]";
	}

	/**
	 * 根据id查找数据
	 * 
	 * @param id
	 * @param ioc
	 * @return
	 */
	@At("/admin/articletype/find")
	@Ok("json")
	public String find(@Param("id") int id, Ioc ioc) {

//		ArticleTypeDao dao = new ArticleTypeDao(ioc);

		ArticleType type = basicDao.find(id, ArticleType.class);

		if (type != null) {
			return Json.toJson(type);
		} 

		return "{id:0}";
	}

}
