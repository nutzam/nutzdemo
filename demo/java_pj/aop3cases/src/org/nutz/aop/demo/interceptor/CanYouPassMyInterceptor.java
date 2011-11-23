package org.nutz.aop.demo.interceptor;

import org.nutz.aop.InterceptorChain;
import org.nutz.aop.MethodInterceptor;
import org.nutz.aop.demo.target.CanPass;

/**
 * 通过判断堆栈中的类是否有CanPass来决定是否调用原本的方法
 */
public class CanYouPassMyInterceptor implements MethodInterceptor {
	
	/**
	 * 通过判断堆栈中的类是否有CanPass来决定是否调用原本的方法
	 */
	public void filter(InterceptorChain chain) throws Throwable {
		Throwable throwable = new Throwable();
		for (StackTraceElement ste : throwable.getStackTrace()) {
			if (CanPass.class.getName().equals(ste.getClassName())) {
				chain.doChain();
				return;
			}
		}
	}
}
