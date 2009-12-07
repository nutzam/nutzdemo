package org.nutz.demo.petstore.utils;

import javax.servlet.ServletContext;

import org.nutz.ioc.Ioc;
import org.nutz.ioc.impl.NutIoc;
import org.nutz.ioc.loader.json.JsonLoader;

public class ContextUtil {
    private static Ioc ioc;

	public static <T> T getBean(Class<T> type, String name) {
		if (ioc != null) {
			return ioc.get(type, name);
		}
		return null;
	}
    public static void initSpringContext(ServletContext servletContext) {
    	ioc = new NutIoc(new JsonLoader("org/nutz/demo/petstore/ioc/config/ioc.js","org/nutz/demo/petstore/ioc/config/dao.js"));
    }
}
