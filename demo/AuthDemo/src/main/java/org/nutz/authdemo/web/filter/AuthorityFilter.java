package org.nutz.authdemo.web.filter;

import java.lang.reflect.Method;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.nutz.extras.mvc.annotation.Authority;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mvc.ActionFilter;
import org.nutz.mvc.View;
import org.nutz.mvc.view.HttpStatusView;


/**
 * @author <a href="mailto:json.shen@gmail.com">Json Shen</a>
 * 2010-7-18 下午04:08:41
 */
public class AuthorityFilter implements ActionFilter{
	
	private static final Log log = Logs.getLog(AuthorityFilter.class);
	
	private static final View UNAUTH =  new HttpStatusView(403);

	@Override
	public View match(ServletContext context,HttpServletRequest req,Method method){
		Authority a = method.getAnnotation(Authority.class);
		if(a == null || a.isDefault())
			return null;
		String id = a.value();
		Object auths = req.getSession().getAttribute("__AUTHORITY_STRING__");
		if(auths == null){
			if(log.isWarnEnabled())
				log.warnf("%s 没有权限操作: [%s]", req.getRemoteHost(),a.desc());
			return UNAUTH;
		}
		int index = auths.toString().indexOf(id+";");
		if(index < 0){
			if(log.isWarnEnabled())
				log.warnf("%s 没有权限操作: [%s]", req.getRemoteHost(),a.desc());
			return UNAUTH;
		}else{
			if(log.isInfoEnabled())
				log.infof("%s 操作了: [%s]", req.getRemoteHost(),a.desc());
			return null;
		}
	}
}
