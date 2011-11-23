var ioc = {
	dataSource : {
		type :"org.apache.commons.dbcp.BasicDataSource",
		events : {
			depose :"close"
		},
		fields : {
			driverClassName : 'com.ibm.db2.jcc.DB2Driver',
			url             : 'jdbc:db2://192.168.1.110:50000/ychr',
			username        : 'db2admin',
			password        : 'db2admin',
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