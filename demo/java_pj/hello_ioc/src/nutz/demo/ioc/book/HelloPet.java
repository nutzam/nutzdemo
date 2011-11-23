package nutz.demo.ioc.book;

import org.nutz.ioc.Ioc;
import org.nutz.ioc.impl.NutIoc;
import org.nutz.ioc.loader.json.JsonLoader;

/**
 * 手册中 《Hello world》 一节的代码
 * 
 * @author zozoh(zozohtnt@gmail.com)
 */
public class HelloPet {

	public static void main(String[] args) {
		Ioc ioc = new NutIoc(new JsonLoader("nutz/demo/ioc/book/pets.js"));
		Pet pet = ioc.get(Pet.class, "xiaobai");
		System.out.printf("%s - [%s]\n", pet.getName(), pet.getBirthday().getTimeZone().getID());
		
		Pet xh = ioc.get(null, "xiaohei");
		System.out.printf("%s's friend is %s\n", xh.getName(), xh.getFriend().getName());
		
		Pet p1 = ioc.get(null, "xiaohei");
		Pet p2 = ioc.get(null, "xiaohei");
		System.out.println(p1==p2);
	}

}
