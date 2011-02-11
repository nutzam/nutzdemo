package com.scxxs.cms;

import org.nutz.dao.Dao;
import org.nutz.dao.tools.Tables;
import org.nutz.ioc.Ioc;
import org.nutz.ioc.impl.NutIoc;
import org.nutz.ioc.loader.json.JsonLoader;
import org.nutz.mvc.annotation.Encoding;
import org.nutz.mvc.annotation.Fail;
import org.nutz.mvc.annotation.IocBy;
import org.nutz.mvc.annotation.Modules;
import org.nutz.mvc.ioc.provider.ComboIocProvider;

import com.scxxs.cms.model.Link;

@Fail("json")
@IocBy(type=ComboIocProvider.class,args={
	"*org.nutz.ioc.loader.json.JsonLoader","/conf/datasource.json",
	"*org.nutz.ioc.loader.annotation.AnnotationIocLoader","com.scxxs.cms"})
@Modules(scanPackage=true)
@Encoding(input="UTF-8",output="UTF-8")
public class MainModule {
	
	public static void main(String[] args) {
		Ioc ioc = new NutIoc(new JsonLoader("/conf/datasource.json"));
		Tables.define(ioc.get(Dao.class), Tables.parse(Link.class));
	}
}
