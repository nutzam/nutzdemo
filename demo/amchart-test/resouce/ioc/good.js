var ioc = {
	goodSevice : {
		type : "com.xvxv.amchart.sevice.GoodSevice",
		args : [ {
			refer : "dao"
		} ]
	},
	goodModule : {
		type : "com.xvxv.amchart.web.good.GoodModule",
		fields : {
			goodSevice : {
				refer : "goodSevice"
			}
		}
	}
};