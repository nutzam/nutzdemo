var ioc = {
	configuration : {
		type : "freemarker.template.Configuration"
	},
	freeMarkerConfigurer: {
		type : "net.wendal.nutz.freemarker.model.FreeMarkerConfigurer",
		args : [ {
			refer : "configuration"
		} ]
	}
};