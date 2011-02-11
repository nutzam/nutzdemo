package com.scxxs.cms.controller;

import javax.servlet.http.HttpServletRequest;

import org.nutz.ioc.Ioc;
import org.nutz.ioc.annotation.InjectName;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.Param;

import com.scxxs.cms.model.WebConfig;
/**
 * 网站配置管理
 * @author Administrator
 *
 */
@IocBean
@InjectName
public class SiteAction extends BaseAction{

	@At("/admin/site")
	@Ok("jsp:admin.site")
	public void configSite(HttpServletRequest req,Ioc ioc){
		
		
		WebConfig cfg = basicDao.find(1, WebConfig.class);
		
		req.setAttribute("cfg", cfg);
		
	}
	
	@At("/admin/site/add")
	@Ok("redirect:/admin/site")
	public void config(@Param("::cfg.") WebConfig cfg,Ioc ioc){
		
//		WebConfigDao dao = new WebConfigDao(ioc);
		if(cfg.getId()!=0){
			basicDao.update(cfg);
		}else{
			basicDao.save(cfg);
		}
	}
}
