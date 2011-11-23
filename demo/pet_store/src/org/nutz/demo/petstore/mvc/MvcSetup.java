package org.nutz.demo.petstore.mvc;

import org.nutz.mvc.NutConfig;
import org.nutz.mvc.Setup;

public class MvcSetup implements Setup {

	@Override
	public void init(NutConfig config) {
		System.out.println("I start!!");
	}

	@Override
	public void destroy(NutConfig config) {
		System.out.println("I stop!!");
	}

	

}
