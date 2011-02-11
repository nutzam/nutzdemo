package com.scxxs.cms.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.nutz.dao.Cnd;
import org.nutz.dao.Expression;
import org.nutz.ioc.Ioc;
import org.nutz.ioc.annotation.InjectName;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.json.Json;
import org.nutz.mvc.View;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.Param;
import org.nutz.mvc.view.JspView;

import com.scxxs.cms.dao.MessageTypeDao;
import com.scxxs.cms.model.Message;
import com.scxxs.cms.model.MessageType;
import com.scxxs.cms.model.PageModel;
import com.scxxs.cms.utils.FilterHTMLTag;
import com.scxxs.cms.utils.SystemContext;
/**
 * 留言管理Action
 * @author Administrator
 *
 */
@IocBean
@InjectName
public class MessageAction extends BaseAction{

	@Inject
	MessageTypeDao messageTypeDao; 
		
	/**
	 * 页面跳转/查询
	 * @param ioc
	 * @param req
	 * @param tid 
	 * @param currentPage
	 * @return
	 */
	@At("/admin/message/messagemanager")
	public View messagemanager(Ioc ioc,HttpServletRequest req,@Param("tid") Integer tid,@Param("currentPage") int currentPage){
		Cnd condition = Cnd.where("1","=",1);
		if(tid!=null&&tid!=0){
		condition.and("tid", "=", tid);
		}
		int count = basicDao.searchCount(Message.class, condition);
		int maxPage = basicDao.maxPageSize(count, SystemContext.PAGE_SIZE);
		List<Message> list=basicDao.searchByPage(Message.class, condition.desc("insertTime"), currentPage, SystemContext.PAGE_SIZE);
		PageModel<Message> pm = new PageModel<Message>(list, maxPage);
		req.setAttribute("pm", pm);
		req.setAttribute("alltype", messageTypeDao.search(MessageType.class, "sortNumber"));
		if(tid==null){
			tid=0;
		}
		req.setAttribute("tid", tid.toString());
		return new JspView("admin.messagemanager");
	}
	/**
	 * 查询单个记录
	 * @param ioc
	 * @param id
	 * @return
	 */
	@At("/admin/message/find")
	@Ok("json")
	public String find(Ioc ioc,@Param("id") int id){
//		MessageDao dao=new MessageDao(ioc);
		Message m=basicDao.find(id, Message.class);
		m.setType(basicDao.find(m.getTid(),MessageType.class));
		return Json.toJson(m);
	}
	
	/**
	 * 根据ids删除数据信息
	 * 
	 * @param ids
	 * @param ioc
	 * @return
	 */
	@At("/admin/message/delByIds")
	@Ok("json")
	public String delByIds(@Param("ids") String ids, Ioc ioc,
			@Param("currentPage") int currentPage, @Param("size") int size) {
//
//		MessageDao dao = new MessageDao(ioc);

		int count = basicDao.searchCount(Message.class);
		int maxPage = basicDao.maxPageSize(count, SystemContext.PAGE_SIZE);
		String str = "";
		StringBuffer sb = new StringBuffer("[");
		if (maxPage > 1) {
			List<Message> types = basicDao.searchByPage(Message.class,
					(currentPage + 1), SystemContext.PAGE_SIZE, "id");
			int i = 0;
			for (Message type : types) {
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
		basicDao.deleteByIds(Message.class, ids);

		return str+"]";
	}
	/**
	 *修改记录
	 * @param ioc
	 * @param mess
	 * @return
	 */
	@At("/admin/message/update")
	@Ok("json")
	public String update(Ioc ioc,@Param("::mess.") Message mess){
//		MessageDao dao=new MessageDao(ioc);
		mess.setReplayTime(new Date());
		boolean flag=basicDao.update(mess);
		return "{success:"+flag+"}";
	}
	/**
	 * 添加
	 * @param ioc
	 * @param mess
	 * @return
	 */
	@At("/message/add")
	@Ok("json")
	public String add(Ioc ioc,@Param("::mess.") Message mess){
//		MessageDao dao=new MessageDao(ioc);
		mess.setContent(FilterHTMLTag.delHTMLTag(mess.getContent()));
		mess.setVistor(FilterHTMLTag.delHTMLTag(mess.getVistor()));
		mess.setEmail(FilterHTMLTag.delHTMLTag(mess.getEmail()));
		mess.setInsertTime(new Date());	
		if(basicDao.save(mess)!=null){
			Expression e = Cnd.exp("navid", "=", mess.getNavid());
			
			List<Message> list=basicDao.searchByPage(Message.class, Cnd.where(e).desc("insertTime"), 1, SystemContext.PAGE_SIZE);
			return Json.toJson(list);
		}
		return "";
	}
}
