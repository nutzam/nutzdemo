package yhp;

import org.nutz.dao.Dao;
import org.nutz.dao.impl.NutDao;
import org.nutz.mvc.NutConfig;
import org.nutz.mvc.Setup;

import yhp.bean.Application;
import yhp.bean.Department;
import yhp.bean.Item;


public class AppSetup implements Setup {

	public void destroy(NutConfig config) {
	
	}

	public void init(NutConfig config) {
		NutDao dao = (NutDao) config.getIoc().get(Dao.class);
		dao.create(Application.class, true);
		dao.create(Department.class, true);
		dao.create(Item.class, true);
		Department department = new Department();
		department.setName("财务科");
		department.setId(1);
		dao.insert(department);
		
		department.setName("办公室");
		department.setId(2);
		dao.insert(department);
		
		Item item = new Item();
		item.setDepartment("财务科");
		item.setName("饮水机");
		item.setVersion("APC-SC10001");
		item.setId(1);
		item.setPrice(260);
		dao.insert(item);
		
		item.setDepartment("办公室");
		item.setName("文件柜");
		item.setVersion("APC-SC10001");
		item.setId(2);
		item.setPrice(1980);
		dao.insert(item);
		
		item.setDepartment("办公室");
		item.setName("齐心碎纸机");
		item.setVersion("APC-SC10001");
		item.setId(3);
		item.setPrice(700);
		dao.insert(item);
	}
}
