package org.nutz.demo.petstore.test;

import org.junit.After;
import org.junit.Before;
import org.nutz.dao.Dao;
import org.nutz.ioc.Ioc;

public abstract class DaoCase {

	protected Dao dao;
	protected Ioc ioc;

	@Before
	public void setUp() {
		ioc = Nutzs.getIoc("org/nutz/demo/petstore/ioc/config/ioc.js","org/nutz/demo/petstore/ioc/config/dao.js");
//		ioc = new NutIoc(new JsonLoader("org/nutz/demo/petstore/ioc/config/ioc.js","org/nutz/demo/petstore/ioc/config/dao.js"));
		dao = ioc.get(Dao.class, "dao");
		before();
	}

	@After
	public void tearDown() {
		after();
	}

	protected void before() {}

	protected void after() {}

}
