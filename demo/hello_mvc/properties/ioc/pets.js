/*
 * 这个配置文件配置了两个服务类， PetService 和  MasterService，用来封装这两个实体的数据库访问。
 * 并且，为 PetModule 注入这两个服务类
 */
var ioc = {
	/*
	 * Pet 的服务类
	 */
	pets : {
		type : "nutz.demo.mvc.pet.PetService",
		args : [ {
			refer : "dao"
		} ]
	},
	/*
	 * Master 的服务类
	 */
	masters : {
		type : "nutz.demo.mvc.pet.MasterService",
		args : [ {
			refer : "dao"
		} ]
	},
	/*
	 * 组合 PetModule，该模块，需要有两个属性，分别是 pets 和 masters。 PetModule 类上，必须声明注入名
	 * @InjectName("petModule")
	 */
	petModule : {
		type : "nutz.demo.mvc.pet.PetModule",
		fields : {
			pets : {
				refer : "pets"
			},
			masters : {
				refer : "masters"
			}
		}
	}
};