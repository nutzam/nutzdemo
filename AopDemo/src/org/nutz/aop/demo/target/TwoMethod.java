package org.nutz.aop.demo.target;

import org.nutz.ioc.aop.Aop;

public class TwoMethod {

	@Aop(value={"log","diffm"}) //先经过logranh到diffm
//	@Aop(value={"diffm","log"}) //试试这种,看看打印的信息有何不同,记得配置log哦
	//拦截器之间的调用顺序,与value里面的顺序是一样的. 还有就是beforeInvoke调用的顺序 与afterInvoke是一致的,并非相反!!
	// A拦截器beforeInvoke-->B拦截器beforeInvoke-->方法调用 -->A拦截器afterInvoke-->B拦截器afterInvoke
	public void methodA(){
		System.out.println("我是方法A");//我可是名正言顺地被调用的!
	}
	
	public void methodB(){
		System.out.println("我是方法B! 我竟然被调用了!"); //我很想被调用
		//打印一下堆栈
		System.out.println("一起来看看堆栈==============================");
		new Throwable().printStackTrace(System.out);
		System.out.println("堆栈结束==============================");
		System.out.println("看到了? 往上追溯,竟然是通过methodA调用到我的!!");
	}

}
