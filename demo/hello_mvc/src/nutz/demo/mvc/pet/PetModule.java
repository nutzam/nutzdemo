package nutz.demo.mvc.pet;

import org.nutz.mvc.annotation.*;

/**
 * 本模块，使用了 Ioc 注入，Nutz.Ioc 将为本模块注入两个属性 "pets" 和 "masters"。 请参看 properties 目录下的
 * <ul>
 * <li>ioc/dao.js -- 数据库注入配置
 * <li>ioc/pets.js -- Pet 模块注入配置
 * </ul>
 * 这两个文件，由默认模块类的 '@IocBy' 注解导入。
 * 
 * @author zozoh
 * 
 */
@InjectName("petModule")
@At("/pet")
@Fail("json")
public class PetModule {

	/*
	 * 这两属性将被注入，它们可以是私有的，不用提供 getter 和 setter
	 */
	private PetService pets;
	private MasterService masters;

	/**
	 * 增 ： /pet/addpet
	 * 
	 * 声明了 '@Param("..")' 表示，这个参数 Pet 将按照名值对的方式，从整个 Request 加载。 request 中的参数名将 与
	 * pet 的字段名对应。如果你想为 pet 的某一个字段指定特殊的参数名，请用 '@Param' 注解为其指定特殊名称
	 * 
	 * '@Ok' 注解将用 /WEB-INF/jsp/pet/detail.jsp 来渲染函数返回的 Pet 对象。 在 JSP
	 * 中，<%=request.getAttribute("obj")=%> 就可以得到这个对象
	 */
	@At
	@Ok("jsp:jsp.pet.detail")
	public Pet addPet(@Param("..") Pet pet) {
		return pets.dao().insert(pet);
	}

	/**
	 * 同上面一样，也是增加一个 Master，不过返回的方式是 JSON 字符串
	 */
	@At
	@Ok("json")
	public Master addMaster(@Param("..") Master master) {
		return masters.dao().insert(master);
	}
}
