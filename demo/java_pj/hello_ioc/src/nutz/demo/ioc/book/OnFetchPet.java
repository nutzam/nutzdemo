package nutz.demo.ioc.book;

import org.nutz.ioc.IocEventTrigger;

/**
 * 手册中 《事件监听》 一节的代码
 * 
 * @author zozoh(zozohtnt@gmail.com)
 */
public class OnFetchPet implements IocEventTrigger<Pet> {

	public void trigger(Pet pet) {
		pet.setFetchCount(pet.getFetchCount() + 1);
	}

}
