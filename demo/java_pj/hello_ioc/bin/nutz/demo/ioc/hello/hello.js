/*
 * 在前部加入 var ioc = ，字符串，主要是为了能让 Eclipse 的  Javascript 编辑器自动格式化
 * 当前的 JSON 文件
 */
var ioc = {
	intel : {
		type : 'nutz.demo.ioc.meta.IntelE5300'
	},
	amd : {
		type : 'nutz.demo.ioc.meta.AmdAthlonII'
	},
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
	},
	/*
	 * 如果对象的配置只有 fields ，那么可以将 fields 省略，直接书写字段。
	 */
	c2 : {
		cpu : {
			refer : 'amd'
		},
		memory : {
			type : 'nutz.demo.ioc.meta.VData'
		},
		others : 2000
	}
};