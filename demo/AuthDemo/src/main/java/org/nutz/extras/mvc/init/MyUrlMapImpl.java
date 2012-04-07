package org.nutz.extras.mvc.init;

import java.lang.reflect.Method;

import org.nutz.extras.mvc.annotation.Authority;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mvc.ActionChainMaker;
import org.nutz.mvc.ActionInfo;
import org.nutz.mvc.NutConfig;
import org.nutz.mvc.impl.UrlMappingImpl;

/**
 * @author <a href="mailto:json.shen@gmail.com">Json Shen</a> 2010-7-18
 *         下午02:44:08
 */
public class MyUrlMapImpl extends UrlMappingImpl {

	private static final Log log = Logs.getLog(MyUrlMapImpl.class);

	/**
	 * 添加URL时初始化权限
	 */
	@Override
	public void add(ActionChainMaker maker, ActionInfo ai, NutConfig config) {
		super.add(maker, ai, config);
		Method method = ai.getMethod();
		Authority a = method.getAnnotation(Authority.class);
		if (null == a) {
			return;
		}
		String id = a.value();
		String module = a.module();
		String desc = a.desc();
		boolean isDefault = a.isDefault();

		// 在这里可以把权限写入数据库以及其它操作,此处为运行demo简单只写日志.
		log.infof("AuthID=%s Module=%s Default=%s Desc=%s", id, module,
				isDefault, desc);
	}
}
