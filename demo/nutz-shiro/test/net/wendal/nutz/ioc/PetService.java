package net.wendal.nutz.ioc;

import org.nutz.log.Log;
import org.nutz.log.Logs;

public class PetService {
	
	public static final Log log = Logs.get();

	private String name;
	
	private String javaHome;
	
	private int age;
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public PetService(String name) {
		this.name = name;
	}
	
	public void init() {
//		new Throwable().printStackTrace();
		log.debug("I am initing ....");
	}
	
	public void fetchMe() throws Throwable {
//		Thread.sleep(1);
//		new Throwable().printStackTrace();
		log.debug("Fetch ing ");
	}
	
	public void close() {
		log.debug("Closing");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJavaHome() {
		return javaHome;
	}

	public void setJavaHome(String javaHome) {
		this.javaHome = javaHome;
	}
	
	
}
