package nutz.demo.mvc;

import java.sql.Timestamp;

import javax.servlet.ServletConfig;

import nutz.demo.mvc.pet.Master;
import nutz.demo.mvc.pet.Pet;

import org.nutz.dao.Dao;
import org.nutz.dao.Sqls;
import org.nutz.ioc.Ioc;
import org.nutz.mvc.Mvcs;
import org.nutz.mvc.Setup;

public class HelloMvcSetup implements Setup {

	/**
	 * 当服务启动的时候，自动检查数据库，如果必要的数据表不存在，创建它们 并创建一个默认的 master 记录
	 */
	public void init(ServletConfig config) {
		Ioc ioc = Mvcs.getIoc(config.getServletContext());
		Dao dao = ioc.get(Dao.class, "dao");
		if (!dao.exists(Pet.class)) {
			// Create tables
			Sqls.executeDefinitionFile(dao, "tables.dod");

			// Create master account
			Master m = new Master();
			m.setName("peter");
			m.setPassword("123456");
			m.setBirthday(new Timestamp(System.currentTimeMillis()));
			dao.insert(m);
		}
	}

	public void destroy(ServletConfig config) {}

}