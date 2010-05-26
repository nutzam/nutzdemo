package org.nutz.demo.petstore.mvc;

import org.nutz.demo.petstore.mvc.module.AccountModule;
import org.nutz.demo.petstore.mvc.module.MessageModule;
import org.nutz.mvc.annotation.Fail;
import org.nutz.mvc.annotation.IocBy;
import org.nutz.mvc.annotation.Localization;
import org.nutz.mvc.annotation.Modules;
import org.nutz.mvc.annotation.SetupBy;
import org.nutz.mvc.ioc.provider.JsonIocProvider;

@Modules( { AccountModule.class, MessageModule.class})
@IocBy(type = JsonIocProvider.class, args = { "org/nutz/demo/petstore/ioc/config/dao.js", "org/nutz/demo/petstore/ioc/config/ioc.js" })
@SetupBy(MvcSetup.class)
@Localization("msg")
@Fail("json")
public class MainModule {

}
