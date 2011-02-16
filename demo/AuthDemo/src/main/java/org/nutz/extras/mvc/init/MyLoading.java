package org.nutz.extras.mvc.init;

import org.nutz.extras.mvc.annotation.UrlMapBy;
import org.nutz.lang.Mirror;
import org.nutz.lang.util.Context;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mvc.UrlMap;
import org.nutz.mvc.init.DefaultLoading;
import org.nutz.mvc.init.NutConfig;
import org.nutz.mvc.init.UrlMapImpl;


/**
 * @author Json.Shen
 * <p>e-mail:json.shen@gmail.com</p>
 * 2010-7-18 下午02:32:57
 */
public class MyLoading extends DefaultLoading {
	
	private static final Log log = Logs.getLog(MyLoading.class);
	
	/**
	 * 自定义UrlMap实现支持
	 */
	@Override
	protected UrlMap makeUrlMap(NutConfig config, Context context, Class<?> mainModule) {
		Class<? extends UrlMap> urlMapType;
		UrlMapBy umb = mainModule.getAnnotation(UrlMapBy.class);
		if(null != umb){
			urlMapType = umb.value();
		}else{
			urlMapType = UrlMapImpl.class;
		}
		log.infof("UrlMapImpl : <%s>", urlMapType);
		return Mirror.me(urlMapType).born(config,context,mainModule);
	}
}