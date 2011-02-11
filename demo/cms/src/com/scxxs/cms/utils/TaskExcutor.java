package com.scxxs.cms.utils;

import java.util.Timer;

import org.nutz.ioc.Ioc;
import org.nutz.ioc.annotation.InjectName;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;

@IocBean
@InjectName
public class TaskExcutor {
	
	private Timer timer;

	@At("/shine/start")
	public void excutor(Ioc ioc){
		
		System.out.println("start task...");
		
		timer = new Timer();
		//每天执行
		timer.schedule(ioc.get(Task.class),0,1000*60*60*24);
		//timer.schedule(new Task(ioc),0,10000);
	}
	
}
