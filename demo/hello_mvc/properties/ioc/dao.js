/*
 * 本配置文件声明了整个应用的数据库连接部分。
 */
var ioc = {
	/*
	 * 数据库连接池，采用 Apache 的 BasiceDataSource，具体的配置信息，请视自己本地数据库 情况进行修改
	 */
	dataSource : {
		type : "org.apache.commons.dbcp.BasicDataSource",
		events : {
			depose : "close"
		},
		fields : {
			driverClassName : "org.postgresql.Driver",
			url : "jdbc:postgresql://localhost:5432/hellomvc",
			username : "demo",
			password : "123456"
		}
	},
	/*
	 * 这个配置很好理解， args 表示这个对象构造函数的参数。显然，下面的注入方式将调用 new NutDao(dataSource)
	 */
	dao : {
		type : "org.nutz.dao.impl.NutDao",
		args : [ {
			refer : "dataSource"
		} ]
	}
};