package net.wendal.nutz.module;

import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.View;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Fail;
import org.nutz.mvc.view.JPEGView;

@IocBean
@At("/security")
public class CaptchaModule {
	
	/**
	 * 验证码
	 */
	@At
	@Fail("jsp:error.404")
	public View captcha()
	{
		return new JPEGView();
	}
}
