package org.nutz.aop.demo.target;

import org.nutz.ioc.aop.Aop;

public class GetMinValue {
	
	@Aop(value={"cr","log"}) /*可以定义多个拦截器*/
	public Integer getMin(){
		return Integer.MIN_VALUE;/*返回最小值*/
	}

}
