package org.nutz.authdemo.web;

import org.nutz.authdemo.web.filter.AuthorityFilter;
import org.nutz.authdemo.web.module.AuthDemoModule;
import org.nutz.extras.mvc.init.MyUrlMappingImpl;
import org.nutz.mvc.annotation.By;
import org.nutz.mvc.annotation.Encoding;
import org.nutz.mvc.annotation.Fail;
import org.nutz.mvc.annotation.Filters;
import org.nutz.mvc.annotation.IocBy;
import org.nutz.mvc.annotation.Localization;
import org.nutz.mvc.annotation.Modules;
import org.nutz.mvc.annotation.UrlMappingBy;
import org.nutz.mvc.ioc.provider.JsonIocProvider;


/**
 * @author <a href="mailto:json.shen@gmail.com">Json Shen</a>
 * 
 */
@UrlMappingBy(MyUrlMappingImpl.class)
@IocBy(
	type = JsonIocProvider.class, 
	args = {
		"ioc/module.js"
	}
)
@Modules({
	AuthDemoModule.class,
})
@Localization("i18n")
@Encoding(
	input="utf-8",
	output="utf-8"
)
@Filters({
	@By(type=AuthorityFilter.class)
})
@Fail("jsp:/WEB-INF/err/500.jsp")
public class MainModule {}
