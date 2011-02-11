package com.scxxs.cms.controller;

import java.util.List;

import org.nutz.ioc.Ioc;
import org.nutz.ioc.annotation.InjectName;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.json.Json;
import org.nutz.json.JsonFormat;
import org.nutz.mvc.View;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.Param;
import org.nutz.mvc.view.JspView;

import com.scxxs.cms.dao.MessageTypeDao;
import com.scxxs.cms.model.MessageType;

/**
 * 留言模板ACTION
 * @author Administrator
 *
 */
@IocBean
@InjectName
public class MessageTypeAction {
	@Inject
	MessageTypeDao dao;
	/**
	 * 页面转发
	 * @return
	 */
	@At("/admin/message/messagetype")
	public View messagetype(){
		return new JspView("admin.messagetype");
	}
	/**
	 * 查询所有类型
	 * @param ioc
	 * @return
	 */
	@At("/admin/message/selecttype")
	@Ok("json")
	public String selecttype(Ioc ioc){
		List<MessageType> list=dao.search(MessageType.class, "sortNumber");
		return Json.toJson(list, JsonFormat.full());
	}
	/**
	 * 添加类型
	 * @param mt
	 * @param ioc
	 * @return
	 */
	@At("/admin/message/addmessagetype")
	@Ok("json")	
	public String addtype(@Param("::mt.") MessageType mt,Ioc ioc){
//		MessageTypeDao dao=new MessageTypeDao(ioc);
		List<MessageType> list=dao.search(MessageType.class, "sortNumber");
		if(list.size()>0){
		mt.setSortNumber(list.get(0).getSortNumber()+1);
		}else{
			mt.setSortNumber(1);
		}
		MessageType met=dao.save(mt);
		return Json.toJson(met);
	}
	/**
	 * 删除类型
	 * @param id
	 * @param ioc
	 * @return
	 */
	@At("/admin/message/deletype")
	@Ok("json")	
	public String deletype(@Param("id") int id,Ioc ioc){
//		MessageTypeDao dao=new MessageTypeDao(ioc);
		String sql="delete from t_message where tid="+id;
		dao.updatesort(sql);
		boolean flag=dao.delById(id, MessageType.class);
		if (flag) {
			return "{success:true}";
		}

		return "{success:false}";
	}
	/**
	 * 排序
	 * @param ioc
	 * @param newid
	 * @param oldid
	 * @return
	 */
	@At("/admin/message/updatesort")
	@Ok("json")
	public String updatesort(Ioc ioc,@Param("newid") int newid,@Param("oldid") int oldid){
//		MessageTypeDao dao=new MessageTypeDao(ioc);
		MessageType mt1=dao.find(newid, MessageType.class);
		MessageType mt2=dao.find(oldid, MessageType.class);
		if(mt2!=null){
		String sql="";
		if(mt1.getSortNumber()>mt2.getSortNumber()){
		sql="update t_messagetype set sortNumber=sortNumber+1 where sortNumber>="+mt2.getSortNumber()+" and sortNumber<"+mt1.getSortNumber();
		}else if(mt1.getSortNumber()<mt2.getSortNumber()){
		sql="update t_messagetype set sortNumber=sortNumber-1 where sortNumber>"+mt1.getSortNumber()+" and sortNumber<="+mt2.getSortNumber();
		}
		if(!sql.equals("")){
			dao.updatesort(sql);
		}
		mt1.setSortNumber(mt2.getSortNumber());
		boolean flag=dao.update(mt1);
		if (flag) {
			return "{success:true}";
		}
		}
		return "{success:false}";
	}
	/**
	 * 修改
	 * @param mest
	 * @param ioc
	 * @return
	 */
	@At("/admin/messaget/update")
	@Ok("json")
	public String update(@Param("::mest.") MessageType mest,Ioc ioc){
//		MessageTypeDao dao=new MessageTypeDao(ioc);
		boolean flag=dao.update(mest);
		if (flag) {
			return "{success:true}";
		}

		return "{success:false}";
	}
}
