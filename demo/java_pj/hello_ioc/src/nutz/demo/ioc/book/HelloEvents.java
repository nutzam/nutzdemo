package nutz.demo.ioc.book;

import org.nutz.ioc.Ioc;
import org.nutz.ioc.impl.NutIoc;
import org.nutz.ioc.loader.json.JsonLoader;

public class HelloEvents {

	/**
	 * 手册中 《事件监听》 一节的代码
	 * 
	 * @author zozoh(zozohtnt@gmail.com)
	 */
	public static void main(String[] args) {
		Ioc ioc = new NutIoc(new JsonLoader("nutz/demo/ioc/book/events.js"));
		Pet pet = ioc.get(Pet.class, "xb");
		ioc.get(Pet.class, "xb");
		ioc.get(Pet.class, "xb");
		System.out.printf("%s be fetch %d times\n", pet.getName(), pet.getFetchCount());
		
		Pet xh = ioc.get(Pet.class, "xh");
		ioc.get(Pet.class, "xh");
		System.out.printf("%s be fetch %d times\n", xh.getName(), xh.getFetchCount());
	}

}
