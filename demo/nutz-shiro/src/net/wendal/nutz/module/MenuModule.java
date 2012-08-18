package net.wendal.nutz.module;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;

@IocBean
@At("/admin/menu")
public class MenuModule {
	
	@At
	@Ok("fm:admin.menu_setting")
	@RequiresAuthentication
	public void setting() {}

	@At
	@Ok("fm:admin.menu_member")
	@RequiresAuthentication
	public void member() {}

	@At
	@Ok("fm:admin.menu_goods")
	@RequiresAuthentication
	public void goods() {}

	@At
	@Ok("fm:admin.menu_content")
	@RequiresAuthentication
	public void content() {}

	@At
	@Ok("fm:admin.menu_order")
	@RequiresAuthentication
	public void order() {}

	@At
	@Ok("fm:admin.menu_admin")
	@RequiresAuthentication
	public void admin() {}

}
