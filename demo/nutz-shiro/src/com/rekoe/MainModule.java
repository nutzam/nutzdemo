package com.rekoe;

import org.nutz.integration.shiro.ShiroActionFilter;
import org.nutz.mvc.annotation.By;
import org.nutz.mvc.annotation.Fail;
import org.nutz.mvc.annotation.Filters;
import org.nutz.mvc.annotation.IocBy;
import org.nutz.mvc.annotation.Localization;
import org.nutz.mvc.annotation.Modules;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.SetupBy;
import org.nutz.mvc.annotation.Views;
import org.nutz.mvc.ioc.provider.ComboIocProvider;
import org.nutz.mvc.view.FreemarkerViewMaker;
import org.nutz.mvc.view.JPEGViewMaker;

@Modules(scanPackage = true)
@Ok("json")
@Fail("json")
@IocBy(type = ComboIocProvider.class, args = {
		"*org.nutz.ioc.loader.json.JsonLoader", "ioc/",
		"*org.nutz.ioc.loader.annotation.AnnotationIocLoader", "com.rekoe" })
@SetupBy(value = RekoeCmsSetup.class)
// 全局的Shiro注解过滤器
@Filters(@By(type = ShiroActionFilter.class, args = "/index.jsp"))
@Localization("msg")
@Views({ FreemarkerViewMaker.class, JPEGViewMaker.class })
public class MainModule {

}
