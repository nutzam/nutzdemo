package com.scxxs.cms.controller;

import org.nutz.dao.Cnd;
import org.nutz.ioc.Ioc;
import org.nutz.ioc.annotation.InjectName;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Fail;
import org.nutz.mvc.annotation.Param;

import com.scxxs.cms.model.Permission;
/**
 * 权限控制类
 * @author Administrator
 *
 */
@IocBean
@InjectName
public class PermissionAction extends BaseAction{

	@At("/admin/permission/set")
	@Fail("json")
	public String add(@Param("role") int role,@Param("resource") int resource,@Param("acl") int acl,Ioc ioc){
		
//		PermissionDao dao = new PermissionDao(ioc);
		
		Permission p = basicDao.findByCondition(Permission.class, Cnd.where("resource", "=", resource).and("roleid", "=", role));
		
		if(p!=null){
			p.setAcl(p.getAcl()+acl);
			basicDao.update(p);
		}else{
			p = new Permission();
			p.setAcl(acl);
			p.setResource(resource);
			p.setRoleid(role);
			basicDao.save(p);
		}
		
		return "{success:true}";
	}
}
