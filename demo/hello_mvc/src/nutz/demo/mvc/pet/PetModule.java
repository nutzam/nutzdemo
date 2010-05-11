package nutz.demo.mvc.pet;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.nutz.dao.Cnd;
import org.nutz.mvc.annotation.*;
import org.nutz.mvc.filter.CheckSession;
import org.nutz.mvc.upload.UploadAdaptor;

/**
 * 本模块，使用了 Ioc 注入，Nutz.Ioc 将为本模块注入两个属性 "pets" 和 "masters"。 请参看 properties 目录下的
 * <ul>
 * <li>ioc/dao.js -- 数据库注入配置
 * <li>ioc/pets.js -- Pet 模块注入配置
 * </ul>
 * 这两个文件，由默认模块类 (nutz.demo.mvc.MainModule) 的 '@IocBy' 注解导入。
 * <p>
 * 还有几点是需要说明的：
 * <ol>
 * <li>'@InjectName("petModule")' 表示本模块注入的配置，是 "petMoudle"，请打开 ioc/pets.js
 * 文件，查看配置详情
 * <li>'@At("/pet")' 声明了前缀 "/pet"，也就是说，所有的入口函数地址都将是 /petXXXX
 * <li>'@Fail("json")' 表示我们模块函数如果出错（有异常抛出），将默认的把异常消息显示成 JSON 字符串
 * <li>'@Filters(XXXX)' 表示，所有的入口函数都要经过 CheckSession 的检查，如果 session 中不存在 master
 * 属性，则自动跳转到地址 /index.jsp
 * </ol>
 * 
 * @author zozoh
 * 
 */
@InjectName("petModule")
@At("/pet")
@Fail("json")
@Filters({@By(type = CheckSession.class, args = {"master", "/index.jsp"})})
public class PetModule {

	/*
	 * 这两属性将被注入，它们可以是私有的，不用提供 getter 和 setter
	 */
	private PetService pets;
	private MasterService masters;

	/**
	 * 用户登陆 : http://localhost:8080/hellomvc/pet/login.nut
	 * <p>
	 * 根据参数 "name" 和 "pwd" 来验证帐户。 如果成功，跳转到 /index.jsp ，否则跳转到 /wrong_master.jsp
	 */
	@At
	@Filters
	@Ok("redirect:/pet/all.nut")
	@Fail("redirect:/wrong_master.jsp")
	public void login(@Param("name") String name, @Param("pwd") String password, HttpSession session) {
		Master m = masters.fetch(Cnd.where("name", "=", name).and("password", "=", password));
		if (null == m)
			throw new RuntimeException("Error username or password");
		session.setAttribute("master", m);
	}

	/**
	 * 用户登出 : http://localhost:8080/hellomvc/pet/logout.nut
	 */
	@At
	@Ok("redirect:/index.jsp")
	public void logout(HttpSession session) {
		session.removeAttribute("account");
	}

	/**
	 * 增 ： http://localhost:8080/hellomvc/pet/add.nut
	 */
	@At
	@Ok("redirect:/pet/all.nut")
	public Pet add(@Param("nm") String name, HttpSession session) {
		Master m = (Master) session.getAttribute("master");
		Pet pet = new Pet();
		pet.setName(name);
		pet.setMasterId(m.getId());
		return pets.dao().insert(pet);
	}

	/**
	 * 删 : http://localhost:8080/hellomvc/pet/remove.nut
	 */
	@At
	@Ok("redirect:/pet/all.nut")
	public List<Pet> remove(@Param("id") int id, HttpSession session) {
		pets.delete(id);
		return all(session);
	}

	/**
	 * 改 : http://localhost:8080/hellomvc/pet/update.nut
	 * <p>
	 * 声明了 '@Param("..")' 表示，这个参数 Pet 将按照名值对的方式，从整个 Request 加载。 request 中的参数名将 与
	 * pet 的字段名对应。如果你想为 pet 的某一个字段指定特殊的参数名，请用 '@Param' 注解为其指定特殊名称
	 * <p>
	 * 跳转的目标地址支持模板写法，这个 ${id} 会被本函数的返回值填充
	 * <p>
	 * 如果你的目标地址串带有 ${XXXX} 占位符，更多的关于跳转的规则为：
	 * <ul>
	 * <li>返回值为类字符串（CharSequence 的子类），数字，布尔，字符，则所有的占位符将被该值替代
	 * <li>返回值类 Map ，占位符将按名称被这个 Map 填充
	 * <li>返回值为 POJO，占位符将按名称被这个 POJO 的各个字段的值填充
	 * <li>返回值为 null 或者 函数返回 void ， 占位符将按名称，被 request 里的参数的值填充
	 * </ul>
	 */
	@At
	@Ok("redirect:/pet/detail.nut?id=${id}")
	public int update(@Param("..") Pet pet) {
		pets.dao().update(pet);
		return pet.getId();
	}

	/**
	 * 查 : http://localhost:8080/hellomvc/pet/all.nut
	 * <p>
	 * 将只查看当前登陆的 Master 的所有 Pet。本入口函数已经被 CheckSession 保护，所以 Session 中一定有 master
	 * 对象。
	 * <p>
	 *'@Ok' 注解将用 /WEB-INF/jsp/pet/detail.jsp 来渲染函数返回的 Pet 对象。 <br>
	 * 在 JSP 中，&lt;%=request.getAttribute("obj")=%&gt; 就可以得到这个对象
	 * <p>
	 * <b>注意：</b> <br>
	 * "jsp:jsp.pet.detail" 是一个约定，对应路径 /WEB-INF/jsp/pet/detail.jsp
	 */
	@At
	@Ok("jsp:jsp.pet.list")
	public List<Pet> all(HttpSession session) {
		// Get master
		Master m = (Master) session.getAttribute("master");
		// Do query
		return pets.query(Cnd.where("masterId", "=", m.getId()).asc("name"), null);
	}

	/**
	 * 查看单条记录 : http://localhost:8080/hellomvc/pet/detail.nut
	 * <p>
	 * 将使用 /WEB-INF/jsp/pet/detail.jsp 来渲染 Pet 对象
	 */
	@At
	@Ok("jsp:jsp.pet.detail")
	public Pet detail(@Param("id") int id) {
		return pets.fetch(id);
	}

	/**
	 * 文件上传: http://localhost:8080/hellomvc/pet/uploadphoto.nut
	 * <p>
	 * 利用注解 '@AdaptBy' 可以切换当前入口函数默认的适配适配器。 Nutz.Mvc 提供了 UploadAdaptor 专门处理 HTTP
	 * 方式的文件上传。它的工作机理，请参看 UploadAdaptor 的 JDoc 文档。
	 * <p>
	 * 这个入口函数将所有上传的文件，存放在目录 "D:/tmp/demo/upload" 中，buffer的大小为8K，编码为UTF-8，这个临时目录中最对有 10 个临时文件
	 * 
	 * @throws IOException
	 * 
	 * @see org.nutz.mvc.upload.UploadAdaptor
	 * @see org.nutz.mvc.annotation.AdaptBy
	 */
	@At
	@AdaptBy(type = UploadAdaptor.class, args = {"~/nutz/demo/hellomvc/petm/tmp", "8192", "UTF-8", "10" })
	@Ok("jsp:jsp.upload.done")
	@Fail("jsp:jsp.upload.fail")
	public void uploadPhoto(@Param("id") int id, @Param("photo") File f, ServletContext context)
			throws IOException {
		pets.uploadPhoto(id, f, context.getRealPath("/"));
	}

	/**
	 * 支持参数前缀 (Issue 72)
	 * <p>
	 * 如果你的请求表单包含了2个对象，每个对象的字段都有一个规定的前缀，那么为你的 入口函数每个参数声明一下
	 * '@Param("::前缀名")'，则会根据这个前缀名来构建对象
	 * <p>
	 * <b style=color:red>注意：</b>前缀名大小写敏感
	 * <p>
	 * <b>网址示意：</b> http://localhost:8080/hellomvc/pet/add2.nut <br>
	 * 传入参数<br>
	 * A.age=12&A.name=AA&B.age=15&B.name=BB
	 * 
	 */
	@At("/add2")
	@Ok("json")
	public Pet[] insertTwo(@Param("::A.") Pet a, @Param("::B.") Pet b, HttpSession session) {
		// 应该支持 @Attr ，可以从 request, session, context 里取属性
		Master m = (Master) session.getAttribute("master");
		a.setMasterId(m.getId());
		b.setMasterId(m.getId());
		Pet[] list = new Pet[2];
		list[0] = a;
		list[1] = b;
		pets.dao().insert(list);
		return list;
	}

	/**
	 * 支持数组参数 (Issue 86)
	 * <p>
	 * 参数是数组的话，自动适配 HTTP 参数数组
	 * <p>
	 * <b>网址示意：</b> http://localhost:8080/hellomvc/pet/getpets.nut?id=1&id=2<br>
	 */
	@At("/getpets")
	@Ok("json")
	public Pet[] getPets(@Param("id") int[] ids) {
		Pet[] list = new Pet[ids.length];
		for (int i = 0; i < ids.length; i++)
			list[i] = pets.fetch(ids[i]);
		return list;
	}
}
