var ioc = {
	dataSource : {	
		type : "com.alibaba.druid.pool.DruidDataSource",
		fields : {
            driverClassName : 'org.h2.Driver',
            url : 'jdbc:h2:./nutz'
		},
		events : {
			depose : "close"
		}
	},
	dao : {
		type : "org.nutz.dao.impl.NutDao",
		args : [{refer : "dataSource"}]
	}
};