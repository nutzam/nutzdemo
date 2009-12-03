var ioc = {
    dataSource: {
        type: "com.mchange.v2.c3p0.ComboPooledDataSource",
        fields: {
            driver: 'org.postgresql.Driver',
            driverUrl: 'jdbc:postgresql://localhost/nutz_demo_petstore',
            user: 'postgres',
            password: 'postgres'
        }
    },
    accountDao : {
		type : "com.nutz.demo.petstore.dao.AccountDao",
		fields : {
			dataSource : {
				refer : 'dataSource'
			}
		}
	},
	accountService : {
		type : "com.nutz.demo.petstore.service.AccountService",
		fields : {
			accountDao : {
				refer : 'accountDao'
			}
		}
	}
};
