package org.nutz.aop.demo.target;

public class CanPass {
	
	public SecurityMethod securityMethod;
	
	public void getIt(){
		System.out.println("我拿到的钱: " + securityMethod.giveMeMoney());
	}

}
