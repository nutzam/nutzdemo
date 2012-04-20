var ioc = {
	$aop : {
		type : 'org.nutz.ioc.aop.config.impl.ComboAopConfigration',
        fields : {
        	aopConfigrations  : [
            	{	type : 'org.nutz.ioc.aop.config.impl.JsonAopConfigration',
                    fields : {
                    	itemList : [
                        	//['yhp.+','.+','ioc:log'],
                            ['yhp.+','.+','ioc:txREAD_COMMITTED']
                        ]
                     }
                 },
                 {	type : 'org.nutz.ioc.aop.config.impl.AnnotationAopConfigration'}
			]
        }
		
	},

	txNONE : {
		type : 'org.nutz.aop.interceptor.TransactionInterceptor',
		args : [0]
	},
	txREAD_UNCOMMITTED : {
		type : 'org.nutz.aop.interceptor.TransactionInterceptor',
		args : [1]
	},
	txREAD_COMMITTED : {
		type : 'org.nutz.aop.interceptor.TransactionInterceptor',
		args : [2]
	},
	txREPEATABLE_READ : {
		type : 'org.nutz.aop.interceptor.TransactionInterceptor',
		args : [4]
	},
	txSERIALIZABLE : {
		type : 'org.nutz.aop.interceptor.TransactionInterceptor',
		args : [8]
	},
    //声明一个log进行日志记录
	log : {
		type :'org.nutz.aop.interceptor.LoggingMethodInterceptor'
	}
}