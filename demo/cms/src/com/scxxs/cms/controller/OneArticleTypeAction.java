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

import com.scxxs.cms.model.OneArticleType;
import com.scxxs.cms.model.PageModel;
import com.scxxs.cms.utils.SystemContext;

@IocBean
@InjectName
public class OneArticleTypeAction extends BaseAction{
	/**
	 * 添加一篇文章分类
	 * @param onetype
	 * @param ioc
	 * @return
	 */
	@At("/admin/onearticletype/add")
	@Ok("json")
	public String add(@Param(":: onearticletype.") OneArticleType onetype,Ioc ioc){
		
//		OneArticleTypeDaobasicDao = new OneArticleTypeDao(ioc);
		
		boolean flag = false;
		
		if(onetype.getId()== 0){
			
			onetype =basicDao.save(onetype);
			flag = true;
		}else{
			
			if(basicDao.update(onetype)){
				
				flag = true;
				
			}
		}
		
		if(flag){
			
			return "[{success:true},"+Json.toJson(onetype)+"]";
		}
		return "[{success:false}]";
	}
	/**
	 * 查询分页一篇文章分类信息
	 * @param ioc
	 * @param request
	 * @param currentPage
	 * @return
	 */
	@At("/admin/onearticletype")
	public View findAll(Ioc ioc,HttpServletRequest request,@Param("currentPage") int currentPage){
		
//		OneArticleTypeDaobasicDao = new OneArticleTypeDao(ioc);
		
		List<OneArticleType> t =basicDao.searchByPage(OneArticleType.class, currentPage, SystemContext.PAGE_SIZE, "id");
		
		int count =basicDao.searchCount(OneArticleType.class);
		int maxPage =basicDao.maxPageSize(count, SystemContext.PAGE_SIZE);
		
		PageModel<OneArticleType> pm = new PageModel<OneArticleType>(t,maxPage);
		
		request.setAttribute("pm", pm);
		
		
		return new JspView("admin.oneArticletype");
		
	}
	/**
	 * 删除一条数据
	 * @param id
	 * @param currentPage
	 * @param ioc
	 * @return
	 */
	@At("/admin/onearticletype/del")
	@Ok("json")
	public String del(@Param("id") int id,@Param("currentPage") int currentPage,Ioc ioc){
		
//		OneArticleTypeDaobasicDao = new OneArticleTypeDao(ioc);
		
		int count =basicDao.searchCount(OneArticleType.class);
		int maxPage =basicDao.maxPageSize(count, SystemContext.PAGE_SIZE);
		
		StringBuffer buffer = new StringBuffer("[");
		
		if(maxPage >1){
			
			List<OneArticleType> onetypes =basicDao.searchByPage(OneArticleType.class, (currentPage+1), SystemContext.PAGE_SIZE, "id");
			for(OneArticleType types :onetypes){
				buffer.append(Json.toJson(types));
				break;
			}
		}
		buffer.append("]");
		if(basicDao.delById(id, OneArticleType.class)){
			return buffer.toString();
		}else{
			
		}
		
		return null;
	}
	/**
	 * 删除多条数据
	 * @param ids
	 * @param ioc
	 * @param currentPage
	 * @param size
	 * @return
	 */
	@At("/admin/onearticletype/delByIds")
	@Ok("json")
	public String dels(@Param("ids") String ids, Ioc ioc,
			@Param("currentPage") int currentPage, @Param("size") int size){
		
//		OneArticleTypeDaobasicDao = new OneArticleTypeDao(ioc);
		
		int count =basicDao.searchCount(OneArticleType.class);
		int maxPage =basicDao.maxPageSize(count, SystemContext.PAGE_SIZE);
		String str="";
		StringBuffer buffer = new StringBuffer("[");
		if(maxPage >1){
			
			List<OneArticleType> list =basicDao.searchByPage(OneArticleType.class, (currentPage+1), SystemContext.PAGE_SIZE, "id");
			int i = 0;
			for(OneArticleType lists :list){
				
				if(i==size){
					break;
				}else{
					buffer.append(Json.toJson(lists));
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
		basicDao.deleteByIds(OneArticleType.class, ids);
		
		return str + "]";
	}
	/**
	 * 根据ID修改
	 * @param id
	 * @param ioc
	 * @return
	 */
	@At("/admin/articletype/update")
	@Ok("json")
	public String udpate(@Param("id") int id,Ioc ioc){
		
//		OneArticleTypeDaobasicDao = new OneArticleTypeDao(ioc);
		
		OneArticleType onetype =basicDao.find(id, OneArticleType.class);
		if(onetype!=null){
			
			return Json.toJson(onetype);
			
		}
		
		
		return "{id:0}";
	}
	/**
	 * 查询文章类型
	 * @param ioc
	 * @return
	 */
	@At("/admin/articletype/findtype")
	@Ok("json")
	public String findtype(Ioc ioc){
//		OneArticleTypeDaobasicDao = new OneArticleTypeDao(ioc);
		
		StringBuffer buffer =  new StringBuffer("[");
	
		List<OneArticleType> list =basicDao.search(OneArticleType.class, "id");
		for(OneArticleType lists :list){
			
//			buffer.append("{id:").append(lists.getId()).append(",").append("name:'").append(lists.getName()).append("'}");
//			buffer.append(",");
			buffer.append("{id:'"+lists.getId()+"',name:'"+lists.getName()+"'},");
			
			
		}
		
		String resutlt =buffer.substring(0, buffer.length()-1)+"]";
		//buffer.append("]");
		return resutlt;

		
	}

}
