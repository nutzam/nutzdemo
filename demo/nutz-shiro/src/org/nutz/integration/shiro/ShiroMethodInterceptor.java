package org.nutz.integration.shiro;

import java.lang.reflect.Method;

import org.apache.shiro.aop.MethodInvocation;
import org.apache.shiro.authz.AuthorizationException;
import org.nutz.aop.InterceptorChain;
import org.nutz.aop.MethodInterceptor;
import org.nutz.lang.Lang;

/**
 * 将Shiro注解,映射为NutAop的拦截器
 * 
 * @author wendal
 * 
 */
public class ShiroMethodInterceptor implements MethodInterceptor {

	@Override
	public void filter(final InterceptorChain chain) throws Throwable {

		try {
			ShiroAnnotationsAuthorizingMethodInterceptor.defaultAuth
					.assertAuthorized(new MethodInvocation() {

						// 这个方法不会被执行的.
						@Override
						public Object proceed() throws Throwable {
							throw Lang.noImplement();
						}

						@Override
						public Object getThis() {
							return chain.getCallingObj();
						}

						@Override
						public Method getMethod() {
							return chain.getCallingMethod();
						}

						@Override
						public Object[] getArguments() {
							return chain.getArgs();
						}
					});
		} catch (AuthorizationException e) {
			// TODO 该如何处理呢? 交给用户自定义?
			throw Lang.wrapThrow(e);
		}
		chain.doChain(); // 继续下一个拦截器
	}

}
