package net.wendal.nutz;

import org.nutz.integration.shiro.ShiroActionFilter;
import org.nutz.mvc.annotation.By;
import org.nutz.mvc.annotation.Fail;
import org.nutz.mvc.annotation.Filters;
import org.nutz.mvc.annotation.IocBy;
import org.nutz.mvc.annotation.Modules;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.SetupBy;
import org.nutz.mvc.ioc.provider.ComboIocProvider;

@Modules(scanPackage=true)
@Ok("json")
@Fail("json")
@IocBy(type=ComboIocProvider.class, args={
	"*org.nutz.ioc.loader.json.JsonLoader", "ioc/",
	"*org.nutz.ioc.loader.annotation.AnnotationIocLoader", "net.wendal.nutz"
})
@SetupBy(value=WendalSetup.class)
@Filters(@By(type=ShiroActionFilter.class, args="/index.jsp")) //全局的Shiro注解过滤器
public class MainModule {

}
