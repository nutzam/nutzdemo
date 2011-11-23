package org.nutz.extras.mvc.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.nutz.mvc.UrlMap;

/**
 * @author <a href="mailto:json.shen@gmail.com">Json Shen</a>
 * 2010-7-18 下午02:54:41
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface UrlMapBy {
	public abstract Class<? extends UrlMap> value();
}
