package org.nutz.aop.demo.target;

public class CanPass {
	
	private SecurityMethod securityMethod;
	
	public void getIt(){
		System.out.println("我拿到的钱: " + securityMethod.giveMeMoney());
	}

	public void setSecurityMethod(SecurityMethod securityMethod) {
		this.securityMethod = securityMethod;
	}
}
