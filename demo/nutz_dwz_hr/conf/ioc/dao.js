var ioc = {
	dataSource : {
		type :"org.apache.commons.dbcp.BasicDataSource",
		events : {
			depose :"close"
		},
		fields : {
			driverClassName : 'org.h2.Driver',
			url             : 'jdbc:h2:~/nutz_dwz_hr',
			username        : 'nutz',
			password        : 'dwz',
			initialSize     : 10,
			maxActive       : 100,
			minIdle         : 10,
			maxIdle         : 20//,
			//defaultAutoCommit: false,
			
			//validationQueryTimeout : 5,
//			validationQuery : "select 1"
		}
	},
    dao : {
        type : "org.nutz.dao.impl.NutDao",
        fields : {
        	dataSource : {refer : 'dataSource'}
        }
    }
}