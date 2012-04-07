var ioc = {
	accountService : {
		type : "org.nutz.demo.petstore.service.AccountServiceImpl",
		fields : {
			dao : {
				refer : 'dao'
			}
		}
	},
	accountModule : {
		type : "org.nutz.demo.petstore.mvc.module.AccountModule",
		fields : {
			accountService : {
				refer : 'accountService'
			}
		}
	}
};
