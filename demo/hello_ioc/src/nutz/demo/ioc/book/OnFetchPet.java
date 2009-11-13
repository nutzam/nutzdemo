package nutz.demo.ioc.book;

import org.nutz.ioc.IocEventTrigger;

public class OnFetchPet implements IocEventTrigger<Pet> {

	public void trigger(Pet pet) {
		pet.setFetchCount(pet.getFetchCount() + 1);
	}

}
