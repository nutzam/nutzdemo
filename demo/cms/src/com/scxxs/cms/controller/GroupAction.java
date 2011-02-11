package com.scxxs.cms.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

import com.scxxs.cms.model.Group;
import com.scxxs.cms.model.PageModel;
import com.scxxs.cms.utils.SystemContext;
/**
 * 分组管理
 * @author Administrator
 *
 */
@IocBean
@InjectName
public class GroupAction extends BaseAction{
	
	/**
	 * 添加分组数据
	 * @param ioc
	 * @param a
	 * @param articlefiles
	 * @return
	 * @throws IOException 
	 */
	@At("/admin/group/add")
	@Ok("json")
	public String add(Ioc ioc,@Param("::group.") Group group,HttpServletResponse resp) throws IOException{
		
		
		boolean flag = false;
		
		if(group.getId()==0){
			group.setCreateDate(new Date());
			group = basicDao.save(group);
			flag = true;
		}else{
			flag = basicDao.update(group);
		}
		
		if(flag){
			return "[{success:true},"+Json.toJson(group, JsonFormat.full())+"]";
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
	@At("/admin/group/del")
	@Ok("json")
	public String del(@Param("id") int id,@Param("currentPage") int currentPage,Ioc ioc) {
		
//		GroupDao dao = new  GroupDao(ioc);
		
		int count = basicDao.searchCount(Group.class);
		int maxPage = basicDao.maxPageSize(count, SystemContext.PAGE_SIZE);

		StringBuffer sb = new StringBuffer("[");
		if (maxPage > 1) {
			List<Group> groups = basicDao.searchByPage(Group.class, (currentPage + 1),SystemContext.PAGE_SIZE, "sortNumber");
			for (Group g : groups) {
				sb.append(Json.toJson(g));
				//第一次执行完就停止执行
				break;
			}
		}
		sb.append("]");
		
		if (basicDao.delById(id, Group.class)) {	
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
	@At("/admin/group/delByIds")
	@Ok("json")
	public String delByIds(@Param("ids") String ids, Ioc ioc,
			@Param("currentPage") int currentPage,
			@Param("size") int size,
			ServletContext context) {

//		GroupDao dao = new  GroupDao(ioc);
		
		int count = basicDao.searchCount(Group.class);
		int maxPage = basicDao.maxPageSize(count, SystemContext.PAGE_SIZE);
		String str ="";
		StringBuffer sb = new StringBuffer("[");
		if (maxPage > 1) {
			List<Group> groups = basicDao.searchByPage(Group.class, (currentPage + 1),SystemContext.PAGE_SIZE, "sortNumber");
			int i=0;
			for (Group g : groups) {
				if(i==size){
					break;
				}else{
					sb.append(Json.toJson(g)).append(",");
					i++;
				}
			}
		}
		str = sb.toString();
		int dot = str.lastIndexOf(",");
		if (dot != -1) {
			str = str.substring(0, dot);
		}
		
		basicDao.deleteByIds(Group.class, ids);
		
		return str+"]";
	}
	/**
	 * 分页查询出所有的模板信息
	 * @param ioc
	 * @param currentPage
	 * @param type
	 * @return
	 */
	@At("/admin/group")
	public View list(Ioc ioc,@Param("currentPage") int currentPage,String type,HttpServletRequest req){
		
//		GroupDao dao = new  GroupDao(ioc);
		
		List<Group>  result  = basicDao.searchByPage(Group.class, currentPage,  SystemContext.PAGE_SIZE, "sortNumber");
		int count = basicDao.searchCount(Group.class);
		
		int maxPage = basicDao.maxPageSize(count, SystemContext.PAGE_SIZE);
		
		PageModel<Group> pm = new PageModel<Group>();
		pm.setMaxPage(maxPage);
		pm.setResult(result);
		
		req.setAttribute("pm", pm);
		
		return new JspView("admin.group");
	}
	/**
	 * 查询单条
	 * @param ioc
	 * @param id
	 * @return
	 */
	@At("/admin/group/find")
	@Ok("json")
	public String findone(Ioc ioc,@Param("id") int id){
//		GroupDao dao=new GroupDao(ioc);
		return Json.toJson(basicDao.find(id, Group.class));
	}
}
