var ioc = {
	// 对象，仅声明了类型
	intel : {
		type : 'nutz.demo.ioc.meta.IntelE5300'
	},
	// 对象
	amd : {},
	// 对象，声明了类型，以及每个字段
	c1 : {
		type : 'nutz.demo.ioc.meta.Computer',
		fields : {
			cpu : {
				refer : 'intel'
			},
			memory : {
				type : 'nutz.demo.ioc.meta.Kingston'
			},
			others : 2000
		}
	}
}