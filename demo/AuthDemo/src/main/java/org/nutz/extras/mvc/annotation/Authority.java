package org.nutz.extras.mvc.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author <a href="mailto:json.shen@gmail.com">Json Shen</a>
 * 2010-7-18 下午03:17:10
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Authority {
	public abstract String value();
	public abstract String module() default "";
	public abstract boolean isDefault() default false;
	public abstract String desc() default "";
}