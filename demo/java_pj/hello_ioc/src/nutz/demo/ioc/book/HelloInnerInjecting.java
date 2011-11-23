package nutz.demo.ioc.book;

import org.nutz.ioc.Ioc;
import org.nutz.ioc.impl.NutIoc;
import org.nutz.ioc.loader.json.JsonLoader;

/**
 * 手册中  《匿名对象》 一节的代码
 * 
 * @author zozoh(zozohtnt@gmail.com)
 */
public class HelloInnerInjecting {

	public static void main(String[] args) {
		Ioc ioc = new NutIoc(new JsonLoader("nutz/demo/ioc/book/inner.js"));
		Pet pet = ioc.get(Pet.class, "xb");
		System.out.println(pet.getFriend().getName());
	}

}
