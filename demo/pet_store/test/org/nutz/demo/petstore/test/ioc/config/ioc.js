var ioc = {
    dataSource: {
        type: "com.mchange.v2.c3p0.ComboPooledDataSource",
        fields: {
			driverClass: 'org.postgresql.Driver',
			jdbcUrl: 'jdbc:postgresql://localhost/nutz_demo_petstore',
            user: 'postgres',
            password: 'postgres'
        }
    },
	
	dao : {
		type : 'org.nutz.dao.impl.NutDao',
		args : [{refer:'dataSource'}]		
	},
	
	accountService : {
		type : "com.nutz.demo.petstore.service.AccountServiceImpl",
		args: [{refer:'dao'}]
	}
};
