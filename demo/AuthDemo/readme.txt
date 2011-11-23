AuthDemo 是nutz mvc中的一个权限验证的demo.

目标:
	1,对action进行权限检查.
	2,在程序启动时自动维护权限到目标数据库.(注:此demo中没有用到数据库,只输出了日志.)

思路:
	在action上添加一个自定义注解,通nutz的ActionFilter进行检查.并在UrlMapImpl加入将权限自动维护到数据库的功能.
	
实现:
	org.nutz.extras.mvc.annotation.Authority 自定义权限注解
	org.nutz.extras.mvc.annotation.UrlMapBy  UrlMap接口实现定义注解,用法见MainModule
	
	org.nutz.extras.mvc.init.MyLoading 初始化载入实现
	org.nutz.extras.mvc.init.MyUrlMapImpl UrlMap接口实现
	
	org.nutz.authdemo.web.filter.AuthorityFilter 权限检查Filter实现
	
	org.nutz.authdemo.web.module.AuthDemoModule 测试Module