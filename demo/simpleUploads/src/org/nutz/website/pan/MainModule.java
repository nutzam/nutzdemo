package org.nutz.website.pan;

import org.nutz.mvc.annotation.Encoding;
import org.nutz.mvc.annotation.Fail;
import org.nutz.mvc.annotation.IocBy;
import org.nutz.mvc.annotation.Modules;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.ioc.provider.ComboIocProvider;
import org.nutz.website.pan.action.FileAction;

@IocBy(type=ComboIocProvider.class,args={"*org.nutz.ioc.loader.json.JsonLoader","conf",
										  "*org.nutz.ioc.loader.annotation.AnnotationIocLoader","org.nutz.website.pan"})
@Encoding(input="utf8",output="utf8")
@Modules(value={FileAction.class})
@Ok("json")
@Fail("json")
public class MainModule {

}
