var ioc = {
	upload : {
		type :"org.nutz.mvc.upload.UploadAdaptor",
		args : [{
			type : "org.nutz.mvc.upload.UploadingContext",
			args : ["~/tmp"],
			fields : {
				nameFilter : '^.+\\.(jpg|png|gif|bmp|doc|xls|ppt|zip|rar)$'
			}
		}]
	},
    json : {
        type : "org.nutz.mvc.view.UTF8JsonView",
        args : [{
    		type : 'org.nutz.json.JsonFormat',
    		fields: {
    			autoUnicode : true
    		}
    	}]
    }
};