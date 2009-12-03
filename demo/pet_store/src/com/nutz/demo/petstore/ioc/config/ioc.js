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
	
	dao : {
		type : 'org.nutz.dao.impl.NutDao',
		args : [{refer:'dataSource'}]		
	},
	
	accountService : {
		type : "com.nutz.demo.petstore.service.AccountService",
		args: [{refer:'dao'}]
	}
};
