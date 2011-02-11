package com.scxxs.cms.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.nutz.ioc.Ioc;
import org.nutz.ioc.annotation.InjectName;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.json.Json;
import org.nutz.mvc.View;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.Param;
import org.nutz.mvc.view.JspView;

import com.scxxs.cms.model.Link;
import com.scxxs.cms.model.PageModel;
import com.scxxs.cms.utils.SystemContext;

@IocBean
@InjectName
public class LinkAction extends BaseAction{

	/**
	 * 第一默认查出所有数据的页面跳转
	 * @param currentPage
	 * @param ioc
	 * @param request
	 * @return
	 */
	@At("/admin/link")
	public View findAll(@Param("currentPage") int currentPage,Ioc ioc,HttpServletRequest request){
		
		List<Link> list = basicDao.searchByPage(Link.class, currentPage, SystemContext.PAGE_SIZE, "type");
		
		int count = basicDao.searchCount(Link.class);
		int maxPage = basicDao.maxPageSize(count, SystemContext.PAGE_SIZE);
		
		PageModel<Link> pm = new PageModel<Link>(list,maxPage);
		request.setAttribute("pm", pm);


		return new JspView("admin.link");
	}
	/**
	 * 添加友情链接
	 * @param l
	 * @param ioc
	 * @return
	 */
	@At("/admin/link/add")
	@Ok("json")
	public String add(@Param("::link.") Link l,Ioc ioc){
		
//		LinkDao dao = new LinkDao(ioc);
		
		boolean flag = false;
		
		if(l.getId() == 0){
			basicDao.save(l);
			flag = true;
		}else{
			//修改操作
			basicDao.update(l);
			flag = true;
		}
		if(flag){
			
			return "[{success:true}]";
		}else{
			
			return "[{success:false}]";
		}
		
	}
	/**
	 * 删除一条数据
	 * @param id
	 * @param currentPage
	 * @param ioc
	 * @return
	 */
	@At("/admin/link/del")
	@Ok("json")
	public String del(@Param("id") int id,@Param("currentPage") int currentPage,Ioc ioc){
		
//		LinkDao dao  = new LinkDao(ioc);
		
		
		int count = basicDao.searchCount(Link.class);
		int maxPage = basicDao.maxPageSize(count, SystemContext.PAGE_SIZE);
		
		StringBuffer buffer = new StringBuffer("["); 
		if(maxPage>1){
			
			List<Link> list = basicDao.searchByPage(Link.class, (currentPage+1), SystemContext.PAGE_SIZE, "type");
			for(Link lists :list){
				
				buffer.append(Json.toJson(lists));
				break;
				
			}
			
			
		}
		buffer.append("]");
		
		return buffer.toString();
	}
	/**
	 * 删除多条信息
	 * @param ids
	 * @param ioc
	 * @param currentPage
	 * @param size
	 * @return
	 */
	@At("/admin/link/delByIds")
	@Ok("json")
	public String dels(@Param("ids") String ids, Ioc ioc,
			@Param("currentPage") int currentPage, @Param("size") int size){
//		LinkDao  dao =  new LinkDao(ioc);
		
		int count = basicDao.searchCount(Link.class);
		int maxPage = basicDao.maxPageSize(count, SystemContext.PAGE_SIZE);
		
		String str ="";
		StringBuffer  buffer =  new StringBuffer("[");
		
		if(maxPage>1){
			
			List<Link> list = basicDao.searchByPage(Link.class, (currentPage+1), SystemContext.PAGE_SIZE, "type");
			int i = 0;
			for(Link ll :list){
				
				if(i==size){
					break;
				}else{
					buffer.append(Json.toJson(ll));
					buffer.append(",");
					i++;
						}
			
					}
				
			}
		str = buffer.toString();
		int dot = str.lastIndexOf(",");
		if(dot != -1){
			str = str.substring(0, dot);
		
		}
		basicDao.deleteByIds(Link.class, ids);

		return str + "]";

	}
	/**
	 * 根据ID返回一个对象把这对象返回给页面在添加方法中执行修改
	 * @param id
	 * @param ioc
	 * @return
	 */
	@At("/admin/link/upate")
	@Ok("json")
	public String update(@Param("id") int id,Ioc ioc){
		
//		LinkDao dao =  new LinkDao(ioc);
		
		Link link = basicDao.find(id, Link.class);
		
		if(link!=null){
			
			return Json.toJson(link);
			
		}
		return "{id:0}";
	}
}
	
