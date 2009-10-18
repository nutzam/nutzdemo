package nutz.demo.ioc.hello;

import org.nutz.ioc.ObjCallback;

public class ComputerCallback<Computer> implements ObjCallback<Computer> {

	@Override
	public void invoke(Computer obj) {
		System.out.println("Fetch one computer!");
	}

}
