package org.nutz.aop.demo.target;

import org.nutz.ioc.aop.Aop;

public class SecurityMethod {
	
	/**
	 * 我是非常非常重要的方法,麻烦你们保护一下拉!
	 * @return 钱的数量
	 */
	@Aop(value={"log","check"})
	public int giveMeMoney(){
		return Integer.MAX_VALUE;
	}

}
