var ioc = {
	xb : {
		name : 'XiaoBai',
		// 请注意，在这里， friend 字段，直接声明了另外一个对象
		friend : {
			type : 'nutz.demo.ioc.book.Pet',
			fields : {
				name : 'XiaoHei'
			}
		}
	}
}