package org.nutz.mvc.view;

import org.nutz.ioc.Ioc;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mvc.View;
import org.nutz.mvc.ViewMaker;

/**
 * @author idor(sjbwylbs@gmail.com)
 */
public class JPEGViewMaker implements ViewMaker {
	private static final Log log = Logs.getLog(JPEGViewMaker.class);

	@Override
	public View make(Ioc ioc, String type, String value) {
		log.debugf("Type:%s,Value:%s", type, value);
		if ("jpg".equalsIgnoreCase(type)) {
			return new JPEGView();
		}
		return null;
	}

}
