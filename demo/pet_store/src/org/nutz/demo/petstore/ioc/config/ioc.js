var ioc = {
    dataSource: {
        type: "com.mchange.v2.c3p0.ComboPooledDataSource",
        fields: {
			driverClass: 'org.postgresql.Driver',
			jdbcUrl: 'jdbc:postgresql://localhost/Nutz_Demo_PetStore',
            user: 'postgres',
            password: 'postgres'
        }
    },
	
	dao : {
		type : 'org.nutz.dao.impl.NutDao',
		args : [{refer:'dataSource'}]		
	},
	
	accountService : {
		type : "org.nutz.demo.petstore.service.AccountServiceImpl",
		fields : {
			dao : {
				refer : 'dao'
			}
		}
	}
};
