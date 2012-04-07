/*
 * 开始写上 var ioc = { ， 是为了利用 eclipse 的  javascript 编辑器的自动格式化功能
 */
var ioc = {
	/*
	 * 默认的，你仅仅需要直接声明每个字段的值即可，Nutz.Ioc 会为你转型
	 */
	xiaobai : {
		name : 'XiaoBai',
		birthday : '2009-10-25 15:23:40'
	},
	/*
	 * 你当然也可以做更细致的设置
	 */
	xiaohei : {
		type : 'nutz.demo.ioc.book.Pet', // 类型
		singleton : false, // 是否为单件
		args : [ 'XiaoHei' ], // 构造函数参数
		fields : {
			birthday : '2009-11-3 08:02:14',
			friend : {refer : 'xiaobai'}	// 指向容器里另外一个对象
		}
	}
}}