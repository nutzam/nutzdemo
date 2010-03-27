package org.nutz.aop.demo.interceptor;

import java.lang.reflect.Method;

import org.nutz.aop.AbstractMethodInterceptor;

public class DiffMethodInterceptor extends AbstractMethodInterceptor {
	
	private boolean canOrgl = true;
	
	public void setCanOrgl(boolean canOrgl) {
		this.canOrgl = canOrgl;
	}

	@Override
	public boolean beforeInvoke(Object obj, Method method, Object... args) {
		return canOrgl;//如果返回true,就调用原本method,反之,不调用,调往afterInvoke
	}
	
	@Override
	public Object afterInvoke(Object obj, Object returnObj, Method method, Object... args) {
		if (canOrgl)
			return super.afterInvoke(obj, returnObj, method, args);
		else //咦,不想调用原本的方法,好吧,我调用方法B
			try {
				return obj.getClass().getMethod("methodB").invoke(obj);
			}
			catch (Throwable e) {
				e.printStackTrace();
				return null;
			}
	}
}
