package com.xvxv.amchart.web;

import org.nutz.mvc.annotation.Fail;
import org.nutz.mvc.annotation.IocBy;
import org.nutz.mvc.annotation.Localization;
import org.nutz.mvc.annotation.Modules;
import org.nutz.mvc.annotation.Views;
import org.nutz.mvc.init.JsonIocProvider;

import com.xvxv.amchart.view.XMLViewMaker;
import com.xvxv.amchart.web.good.GoodModule;

@Modules( { GoodModule.class })
@Views( { XMLViewMaker.class } )
@IocBy(type = JsonIocProvider.class, args = { "ioc/dao.js", "ioc/good.js" })
@Localization("msg")
@Fail("json")
public class MainModule {}
