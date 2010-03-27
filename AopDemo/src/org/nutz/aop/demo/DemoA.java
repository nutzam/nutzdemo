package org.nutz.aop.demo;

import org.nutz.aop.demo.interceptor.DiffMethodInterceptor;
import org.nutz.aop.demo.target.CanPass;
import org.nutz.aop.demo.target.GetMinValue;
import org.nutz.aop.demo.target.SecurityMethod;
import org.nutz.aop.demo.target.TwoMethod;
import org.nutz.ioc.Ioc;
import org.nutz.ioc.impl.NutIoc;
import org.nutz.ioc.loader.json.JsonLoader;

public class DemoA {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Ioc ioc = new NutIoc(new JsonLoader("ioc.js"));
		Integer integer = ioc.get(GetMinValue.class, "getmax").getMin();
		System.out.printf("得到的值: %s \n",integer);
		
		System.out.println("=============华丽的分隔线====================================");
		TwoMethod tm = ioc.get(TwoMethod.class, "tm");
		DiffMethodInterceptor diffm = ioc.get(DiffMethodInterceptor.class, "diffm");
		tm.methodA();//呼叫一下方法A,看看什么被执行了
		//现在我对方法A不满,我觉得方法B会好些,so..
		diffm.setCanOrgl(false);//告诉拦截器,我不想调用方法A了
		tm.methodA();
		
		System.out.println("=============华丽的分隔线====================================");
		ioc.get(CanPass.class, "canpass").getIt(); //看看你拿得多少钱
		System.out.println("我是强盗,看看能拿到多少钱: "+ ioc.get(SecurityMethod.class, "securityMethod").giveMeMoney());
	}

}
