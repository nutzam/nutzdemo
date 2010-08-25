package org.nutz.aop.demo.interceptor;

import java.lang.reflect.Method;

import org.nutz.aop.interceptor.AbstractMethodInterceptor;

/**
 * 这个类演示如果改变原本的返回值
 * @author wendal(wendal1985@gmail.com)
 *
 */
public class ChangeReturnInterceptor extends AbstractMethodInterceptor {


	public Object afterInvoke(Object obj, Object returnObj, Method method, Object... args) {
		System.out.printf("原本的返回值: %s \n",returnObj);
		return Integer.MAX_VALUE;/*改为最大值*/
	}
}
