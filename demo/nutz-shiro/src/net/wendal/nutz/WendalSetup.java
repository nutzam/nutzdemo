package net.wendal.nutz;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.nutz.dao.Dao;
import org.nutz.dao.entity.annotation.Table;
import org.nutz.integration.shiro.realm.bean.User;
import org.nutz.json.Json;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mvc.NutConfig;
import org.nutz.mvc.Setup;
import org.nutz.resource.Scans;

public class WendalSetup implements Setup {
	
	private static final Log log = Logs.get();

	public void init(NutConfig config) {
		
		Dao dao = config.getIoc().get(Dao.class);
		//自动建表,这里仅建立了nutz-shiro所需的表
		for (Class<?> klass : Scans.me().scanPackage(User.class.getPackage().getName())) {
			if (null != klass.getAnnotation(Table.class))
				dao.create(klass, false);
		}
		
		if (dao.count(User.class) == 0) {
			log.debug("Create Admin user");
			RandomNumberGenerator rng = new SecureRandomNumberGenerator();
			String salt = rng.nextBytes().toBase64();
			String hashedPasswordBase64 = new Sha256Hash("123", salt, 1024).toBase64();
			dao.insert(Json.fromJson(User.class, "{name:'admin',passwd:'"+hashedPasswordBase64+"',salt:'"+ salt +"'}"));
		}
	}

	public void destroy(NutConfig config) {
	}

}
