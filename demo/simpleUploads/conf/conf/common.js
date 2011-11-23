var ioc = {
	txNONE : {
		type : 'org.nutz.aop.interceptor.TransactionInterceptor',
		args : [ 0 ]
	},
	txREAD_UNCOMMITTED : {
		type : 'org.nutz.aop.interceptor.TransactionInterceptor',
		args : [ 1 ]
	},
	txREAD_COMMITTED : {
		type : 'org.nutz.aop.interceptor.TransactionInterceptor',
		args : [ 2 ]
	},
	txREPEATABLE_READ : {
		type : 'org.nutz.aop.interceptor.TransactionInterceptor',
		args : [ 4 ]
	},
	txSERIALIZABLE : {
		type : 'org.nutz.aop.interceptor.TransactionInterceptor',
		args : [ 8 ]
	},
	log : {
		type : "org.nutz.aop.interceptor.LoggingMethodInterceptor"
	}
}