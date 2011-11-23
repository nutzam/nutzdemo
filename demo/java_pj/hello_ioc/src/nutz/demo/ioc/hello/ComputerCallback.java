package nutz.demo.ioc.hello;

import org.nutz.ioc.IocEventTrigger;

public class ComputerCallback<Computer> implements IocEventTrigger<Computer> {

	@Override
	public void trigger(Computer obj) {
		System.out.println("Fetch one computer!");
	}

}
