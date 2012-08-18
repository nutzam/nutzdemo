package net.wendal.nutz.module;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.wendal.nutz.freemarker.model.CaptchaServiceSingleton;
import net.wendal.nutz.service.UserService;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresGuest;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.nutz.integration.shiro.realm.bean.User;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.Strings;
import org.nutz.lang.Times;
import org.nutz.mvc.Mvcs;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Fail;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.Param;
import org.nutz.web.ajax.Ajax;
import org.nutz.web.ajax.AjaxReturn;

import com.octo.captcha.service.CaptchaServiceException;

@IocBean
@At("/admin/usr")
public class UserModule {
	
	
	@At
	@Fail(">>:/index.jsp")
	@Ok("json")
	public AjaxReturn login(@Param("name")String name, 
						 @Param("passwd")String passwd,
						 @Param("remeberMe")boolean remeberMe,@Param("code")String code,HttpServletRequest request) {
		if (Strings.isBlank(name)){
			return Ajax.fail().setMsg("请输入您的用户名!");
		}else if(Strings.isBlank(passwd))
		{
			return Ajax.fail().setMsg("请输入您的密码!");
		}else if( Strings.isBlank(code)){
			return Ajax.fail().setMsg("请输入您的验证码!");
		}else{
			String auth = org.apache.commons.lang.StringUtils.upperCase(code);
			try {
				boolean isRight = CaptchaServiceSingleton.getInstance().validateResponseForID(Mvcs.getHttpSession(true).getId(),auth);
				if(isRight)
				{
					Subject currentUser = SecurityUtils.getSubject();
					UsernamePasswordToken token = new UsernamePasswordToken(name, passwd);
					token.setRememberMe(remeberMe);
				    currentUser.login(token); //这里的授权,请查看shiro.ini中的nutRealm
				    return Ajax.ok();
				}else{
					return Ajax.fail().setMsg("验证码错误");
				}
			} catch (CaptchaServiceException e) {
				return Ajax.fail().setMsg("Invalid ID, could not validate unexisting or already validated captcha");
			}catch(LockedAccountException e){
				return Ajax.fail().setMsg("帐号已被锁定");
			} catch (AuthenticationException e) {
				return Ajax.fail().setMsg("密码错误或用户不存在");
			} catch (Exception e) {
				e.printStackTrace();
				return Ajax.fail().setMsg("登录失败");
			}
		}
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
	@Inject
	private UserService userService;

	@At
	@Ok("jsp:jsp.user_list")
	@RequiresPermissions("user:read:*")
	public List<User> all() {
		return userService.list();
	}

	@At
	@Ok("jsp:jsp.user_view")
	@RequiresPermissions("user:read:*")
	public User view(@Param("id") Long id) {
		return userService.view(id);
	}

	@At
	@Ok("jsp:jsp.user_add")
	@RequiresRoles(value={"admin","user-superadmin","user-admin"},logical=Logical.OR)
	public void p_add() {}
	
	@At
	@Ok(">>:/admin/usr/view?id=${p.userId}")
	@RequiresPermissions("user:roleAssign:*")
	public void addRole(@Param("userId") Long userId,@Param("roleId") Long roleId) {
		userService.addRole(userId, roleId);
	}

	@At
	@Ok(">>:/admin/usr/view?id=${p.userId}")
	@RequiresPermissions("user:roleAssign:*")
	public void removeRole(@Param("userId") Long userId,@Param("roleId") Long roleId) {
		userService.removeRole(userId, roleId);
	}
}
