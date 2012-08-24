package com.rekoe.module;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;

import com.rekoe.service.UserService;

@IocBean
@At("/admin/page")
public class PageModule {

	@Inject
	private UserService userService;

	@At
	@Ok("fm:admin.page_main")
	@RequiresAuthentication
	public void main() {
	}

	@At
	@Ok("fm:admin.page_header")
	@RequiresAuthentication
	public void header() {
	}

	@At
	@Ok("fm:admin.page_middle")
	@RequiresAuthentication
	public void middle() {
	}

	@At
	@Ok("fm:admin.page_index")
	@RequiresAuthentication
	public int index() {
		return userService.count(null);
	}
}
