package nutz.demo.mvc.pet;

import org.nutz.dao.Dao;
import org.nutz.service.IdNameEntityService;

public class MasterService extends IdNameEntityService<Master> {

	public MasterService(Dao dao) {
		super(dao);
	}

}
