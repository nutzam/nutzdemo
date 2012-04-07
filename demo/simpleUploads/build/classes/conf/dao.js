var ioc = {
        dataSource : {
                type : "org.apache.commons.dbcp.BasicDataSource",
                events : {
                        depose : 'close'
                },
                fields : {
                        driverClassName : 'org.h2.Driver',
                        url : 'jdbc:h2:nutzpan',
                        username : 'sa',
                        password : ''
                }
        },
        dao : {
        		type : "org.nutz.dao.impl.NutDao",
        		fields : {
        				dataSource : {refer : 'dataSource'}
        		}
        }
}