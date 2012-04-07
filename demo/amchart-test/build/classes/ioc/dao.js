var ioc = {
	dataSource : {
		type : "org.apache.commons.dbcp.BasicDataSource",
		events : {
			depose : "close"
		},
		fields : {
			driverClassName : "com.mysql.jdbc.Driver",
			url : "jdbc:mysql://127.0.0.1:3306/amchart",
			username : "root",
			password : "root"
		}
	},
	dao : {
		type : "org.nutz.dao.impl.NutDao",
		args : [ {
			refer : "dataSource"
		} ]
	}
};