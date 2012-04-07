package org.nutz.authdemo.web.module;

import javax.servlet.http.HttpServletRequest;

import org.nutz.extras.mvc.annotation.Authority;
import org.nutz.ioc.annotation.InjectName;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;


/**
 * @author <a href="mailto:json.shen@gmail.com">Json Shen</a>
 * 2010-4-28 下午08:27:07
 */

@InjectName("authDemoModule")
public class AuthDemoModule{
	
	
	@At("/index")
	@Ok("jsp:jsp.index")
	//@Authority(value="A001",desc="首页")
	public void index(){
	}
	
	@At("/logout")
	@Ok("jsp:jsp.logout")
	@Authority(value="A002",desc="退出")
	public void logout(HttpServletRequest req){
		//注销session,退出后就只能访问 login ,访问其它的则提示403.
		req.getSession().invalidate();
	}
	
	@At("/login")
	@Ok("jsp:jsp.login")
	@Authority(value="A003",isDefault=true,desc="登录")
	public void login(HttpServletRequest req){
		//添加权限到session中,登录后就可以访问 index 和  logout 了.
		req.getSession().setAttribute("__AUTHORITY_STRING__", "A001;A002;");
	}
}
