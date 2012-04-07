package org.nutz.authdemo.web.filter;

import org.nutz.extras.mvc.annotation.Authority;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mvc.ActionContext;
import org.nutz.mvc.ActionFilter;
import org.nutz.mvc.View;
import org.nutz.mvc.view.HttpStatusView;

/**
 * @author <a href="mailto:json.shen@gmail.com">Json Shen</a> 2010-7-18
 *         下午04:08:41
 */
public class AuthorityFilter implements ActionFilter {

	private static final Log log = Logs.getLog(AuthorityFilter.class);

	private static final View UNAUTH = new HttpStatusView(403);

	public View match(ActionContext context) {
		Authority a = context.getMethod().getAnnotation(Authority.class);
		if (a == null || a.isDefault())
			return null;
		String id = a.value();
		Object auths = context.getRequest().getSession()
				.getAttribute("__AUTHORITY_STRING__");
		if (auths == null) {
			if (log.isWarnEnabled())
				log.warnf("%s 没有权限操作: [%s]", context.getRequest()
						.getRemoteHost(), a.desc());
			return UNAUTH;
		}
		int index = auths.toString().indexOf(id + ";");
		if (index < 0) {
			if (log.isWarnEnabled())
				log.warnf("%s 没有权限操作: [%s]", context.getRequest()
						.getRemoteHost(), a.desc());
			return UNAUTH;
		} else {
			if (log.isInfoEnabled())
				log.infof("%s 操作了: [%s]", context.getRequest().getRemoteHost(),
						a.desc());
			return null;
		}
	}
}
