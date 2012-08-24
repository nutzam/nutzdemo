package org.nutz.mvc.view;

import org.nutz.ioc.Ioc;
import org.nutz.mvc.View;
import org.nutz.mvc.ViewMaker;

/**
 * @author idor(sjbwylbs@gmail.com)
 */
public class JPEGViewMaker implements ViewMaker {
	
	public View make(Ioc ioc, String type, String value) {
		if ("jpg".equalsIgnoreCase(type)) {
			return new JPEGView();
		}
		return null;
	}

}
