var ioc = {
	$aop : {
        type : 'org.nutz.ioc.aop.config.impl.ComboAopConfigration',
        fields : {
                aopConfigrations  : [
                        { type : 'org.nutz.ioc.aop.config.impl.XmlAopConfigration',
                          args : ['conf/declaration-aop.xml']},
                        { type : 'org.nutz.ioc.aop.config.impl.AnnotationAopConfigration'}
                ]
        }
	}
}