var ioc = {
	configuration : {
		type : "freemarker.template.Configuration"
	},
	freeMarkerConfigurer: {
		type : "com.rekoe.freemarker.model.FreeMarkerConfigurer",
		args : [ {
			refer : "configuration"
		} ]
	}
};