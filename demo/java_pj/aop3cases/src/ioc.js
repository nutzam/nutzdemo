{
	getmax : {
		type : 'org.nutz.aop.demo.target.GetMinValue'
	},
	cr : {
		type : 'org.nutz.aop.demo.interceptor.ChangeReturnInterceptor'
	},
	
	tm : {
		type : 'org.nutz.aop.demo.target.TwoMethod'
	},
	diffm : {
		type : 'org.nutz.aop.demo.interceptor.DiffMethodInterceptor'
	},
	
	securityMethod : {
		type : 'org.nutz.aop.demo.target.SecurityMethod'
	},
	canpass : {
		type : 'org.nutz.aop.demo.target.CanPass',
		fields : {
			securityMethod : {refer : 'securityMethod'}
		}
	},
	check : {
		type : 'org.nutz.aop.demo.interceptor.CanYouPassMyInterceptor'
	},
	
	
	
	
	
	
	log : {
		type : 'org.nutz.aop.interceptor.LoggingMethodInterceptor'
	}
}