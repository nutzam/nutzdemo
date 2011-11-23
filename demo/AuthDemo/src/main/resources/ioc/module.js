/*
 * 这个配置文件配置了两个服务类， PetService 和  MasterService，用来封装这两个实体的数据库访问。
 * 并且，为 PetModule 注入这两个服务类
 */
var ioc = {
	/*
	 * 组合 JeeggModule，该模块，需要有两个属性是 accountService。 JeeggModule 类上，必须声明注入名
	 * @InjectName("jeeggModule")
	 */
	authDemoModule : {
		type : "org.nutz.authdemo.web.module.AuthDemoModule"
	}
};