package org.nutz.demo.petstore.test;

import org.nutz.ioc.Ioc;
import org.nutz.ioc.impl.NutIoc;
import org.nutz.ioc.loader.json.JsonLoader;

public class Nutzs {

	private static Ioc nut = null;

	public static Ioc getIoc(String... files) {
		if(nut==null){
			nut = new NutIoc(new JsonLoader(files));
		}
		return nut;
	}
}
