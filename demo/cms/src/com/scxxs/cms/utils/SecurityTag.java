package com.scxxs.cms.utils;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import com.scxxs.cms.model.Manager;
import com.scxxs.cms.model.Permission;
import com.scxxs.cms.model.Role;

/**
 * 权限限制类
 * 
 * @author Administrator
 * 
 */
public class SecurityTag extends TagSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * 资源
	 */
	private int resource;
	/**
	 * 操作
	 */
	private int action;

	@Override
	public int doStartTag() throws JspException {

		HttpSession session = pageContext.getSession();
		Object o =  session.getAttribute("admin");
		if(o!=null){
			Manager m =	(Manager)o;
			List<Role> roles = m.getRoles();
			if(check(roles)){
				return EVAL_PAGE;
			}
		}

		return SKIP_BODY;
	}
	
	
	public int getResource() {
		return resource;
	}

	public void setResource(int resource) {
		this.resource = resource;
	}



	public int getAction() {
		return action;
	}



	public void setAction(int action) {
		this.action = action;
	}



	/*
	 * 检测用户执行权限
	 * @param roles
	 * @return
	 */
	private boolean check(List<Role> roles) {

		boolean flag = false;
		int rule = -1;

		if (roles != null && roles.size() > 0) {
			for (Role r : roles) {
				if (r.getRule() > rule) {
					List<Permission> permissions = r.getPermission();
					for (Permission p : permissions) {
						if (p.getResource() == this.resource) {
							// 判断权限
							if ((p.getAcl() & action) == action) {
								// 判断角色优先级
								flag = true;
							}else{
								flag = false;
							}
							rule = r.getRule();
						}
					}
				}
			}

		}

		return flag;
	}
}
