package nutz.demo.mvc;

import javax.servlet.ServletConfig;

import nutz.demo.mvc.pet.Pet;

import org.nutz.dao.Dao;
import org.nutz.dao.Sqls;
import org.nutz.ioc.Ioc;
import org.nutz.mvc.Mvcs;
import org.nutz.mvc.Setup;

public class HelloMvcSetup implements Setup {
	
	/**
	 * 当服务启动的时候，自动检查数据库，如果必要的数据表不存在，创建它们
	 */
	public void init(ServletConfig config) {
		Ioc ioc = Mvcs.getIoc(config.getServletContext());
		Dao dao = ioc.get(Dao.class, "dao");
		if (!dao.exists(Pet.class)) {
			Sqls.executeDefinitionFile(dao, "tables.dod");
		}
	}

	public void destroy(ServletConfig config) {}

}
