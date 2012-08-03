var ioc = {
	petService :{
		type : "net.wendal.nutz.ioc.PetService",
		args : ["wendal"],
		fields : {
			age : 90,
			javaHome : {env : "PATH"}
		},
		singleton : false,
		events : {
			create : "init",
			fetch  : "fetchMe",
			depose : "close"
		}
	}
};