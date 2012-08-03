package net.wendal.nutz.module;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresGuest;
import org.apache.shiro.subject.Subject;
import org.nutz.integration.shiro.realm.bean.User;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.Strings;
import org.nutz.lang.Times;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Fail;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.Param;

@IocBean
@At("/usr")
public class UserModule {
	
	@At
	@Fail(">>:/index.jsp")
	public boolean login(@Param("name")String name, 
						 @Param("passwd")String passwd,
						 @Param("remeberMe")boolean remeberMe) {
		if (Strings.isBlank(name) || Strings.isBlank(passwd))
			return false;
		
		Subject currentUser = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(name, passwd);
		token.setRememberMe(remeberMe);
	    currentUser.login(token); //这里的授权,请查看shiro.ini中的nutRealm
		return true;
	}
	
	//没登录就不要登出了
	@RequiresAuthentication
	@At
	@Ok(">>:/")
	public void logout() {
		SecurityUtils.getSubject().logout();
	}
	
	@At
	public User me() {
		return (User) SecurityUtils.getSubject().getPrincipal();
	}
	
	//无需登录,就可以直接访问, 跟没写一样....
	@RequiresGuest
	@At("/ping")
	public Object ping() {
		return Times.now();
	}

	//需要登录之后才能访问,否则跳转到首页
	@RequiresAuthentication
	@At
	public Object authOnly() {
		return "You are authed!";
	}
}
