package org.nutz.aop.demo.interceptor;

import java.lang.reflect.Method;

import org.nutz.aop.interceptor.AbstractMethodInterceptor;

public class CanYouPassMyInterceptor extends AbstractMethodInterceptor {


	public boolean beforeInvoke(Object obj, Method method, Object... args) {
		String who = whoCalling();
		System.out.println("谁在请求: "+who);
		if (who.endsWith("Pass"))
			return super.beforeInvoke(obj, method, args);
		else{
			return false;
		}
	}

	public Object afterInvoke(Object obj, Object returnObj, Method method, Object... args) {
		return super.afterInvoke(obj, returnObj, method, args);
	}
	
	public String whoCalling(){
		Throwable throwable = new Throwable();
		
		return throwable.getStackTrace()[4].getClassName();
	}
}
