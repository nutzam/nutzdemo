package net.wendal.nutz.ioc;

import javax.sql.DataSource;

import net.wendal.nutz.module.UserModule;

import org.junit.Test;
import org.nutz.dao.Dao;
import org.nutz.dao.impl.NutDao;
import org.nutz.ioc.Ioc;
import org.nutz.ioc.impl.NutIoc;
import org.nutz.ioc.loader.combo.ComboIocLoader;
import org.nutz.ioc.loader.json.JsonLoader;
import org.nutz.json.Json;

import com.alibaba.druid.pool.DruidDataSource;

public class IocTest {

	@Test
	public void test_conv_mvc_iocby() throws Throwable {
		ComboIocLoader loader = new ComboIocLoader(new String[]{
				"*org.nutz.ioc.loader.json.JsonLoader", "ioc/",
				"*org.nutz.ioc.loader.annotation.AnnotationIocLoader", "net.wendal.nutz"
			});
		NutIoc ioc = new NutIoc(loader);
//		Dao dao = ioc.get(Dao.class);
		UserModule module = ioc.get(UserModule.class);
		System.out.println(module.ping());
	}
	
	@Test
	public void test_js_ioc() {
		JsonLoader loader = new JsonLoader("ioc/");
		NutIoc ioc = new NutIoc(loader);
		Dao dao =  ioc.get(Dao.class);
		System.out.println(dao);
	}
	
	@Test
	public void test_conv_js_ioc() {
		DruidDataSource dataSource = null;
		try {
			dataSource = new DruidDataSource();
			dataSource.setDriverClassName("org.h2.Driver");
			dataSource.setUrl("jdbc:h2:nutz");
			NutDao dao = new NutDao(dataSource);
			System.out.println(dao);
		} finally {
			if (dataSource != null)
				dataSource.close();
		}
	}
	
	public static Dao dao;
	public static DataSource dataSource;
	public static UserModule userModule;
	
	public static Ioc ioc;
	
	
	
	
	
	
	@Test
	public void test_pet_ioc() {
		JsonLoader loader = new JsonLoader("net/wendal/nutz/ioc/");
		NutIoc ioc = new NutIoc(loader);
		PetService petService = ioc.get(PetService.class);
		System.out.println(Json.toJson(petService));
		
		System.out.println(petService);
		System.out.println(ioc.get(PetService.class));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
