package nutz.demo.mvc.pet;

import org.nutz.dao.Dao;
import org.nutz.service.IdNameEntityService;

public class PetService extends IdNameEntityService<Pet> {

	public PetService(Dao dao) {
		super(dao);
	}

}
