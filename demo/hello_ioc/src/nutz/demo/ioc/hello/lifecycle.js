var ioc = {
	/*
	 * 这个对象不是单例
	 */
	computer : {
		singleton : false,
		lifecycle : {
			create : 'init',
			fetch : 'nutz.demo.ioc.hello.ComputerCallback',
			depose : 'depose'
		},
		fields : {
			cpu : {
				refer : 'intel'
			},
			memory : {
				type : 'nutz.demo.ioc.meta.VData'
			},
			others : 2000
		}
	},
	/*
	 * 直接继承自 computer 对象，不过是本对象是 “单例”
	 */
	c3 : {
		parent : 'computer',
		singleton : true
	}
};