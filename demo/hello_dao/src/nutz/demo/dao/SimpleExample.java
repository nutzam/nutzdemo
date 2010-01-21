package nutz.demo.dao;

import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import nutz.demo.dao.meta.Pet;

import org.apache.commons.dbcp.BasicDataSource;
import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.dao.impl.NutDao;
import org.nutz.dao.pager.Pager;
import org.nutz.dao.tools.Tables;
import org.nutz.lang.Files;
import org.nutz.lang.Strings;
import org.nutz.lang.random.R;
import org.nutz.lang.random.StringGenerator;

import static java.lang.System.*;

/**
 * 本例子将展示如何使用 Nutz.Dao 做基本的增删改查
 * <p>
 * 运行任何一个例子前，请确保你创建了数据库 daodemo 以及数据库里有数据表：
 * <p>
 * <b>t_pet</b>
 * <table border=1>
 * <tr>
 * <td>ID</td>
 * <td>Name</td>
 * <td>Age</td>
 * </tr>
 * <tr>
 * <td>1</td>
 * <td>XiaoBai</td>
 * <td>8</td>
 * </tr>
 * <tr>
 * <td>2</td>
 * <td>XiaoHei</td>
 * <td>5</td>
 * </tr>
 * <tr>
 * <td>3</td>
 * <td>Manto</td>
 * <td>11</td>
 * </tr>
 * </table>
 * </table> <br>
 * 如果你没有创建这个数据表，请通过调用函数 prepareData() 来创建
 * 
 * @author zozoh(zozohtnt@gmail.com)
 */
public class SimpleExample {

	/**
	 * 为本演示准备数据，当然，你可以不用这个函数而自己手工准备数据。
	 * <p>
	 * 执行完，数据库会有 数据表 t_pet ：
	 * 
	 * <pre>
	 *  id |  name   | age
	 * ----+---------+-----
	 *   1 | XiaoBai |   8
	 *   2 | XiaoHei |   5
	 *   3 | Manto   |  11
	 * </pre>
	 */
	public static void prepareData() {
		Dao dao = getDao();
		File dodFile = Files.findFile("nutz/demo/dao/meta/pet.dod");
		Tables.define(dao, dodFile);

		dao.insert(pet("XiaoBai", 8));
		dao.insert(pet("XiaoHei", 5));
		dao.insert(pet("Manto", 11));
	}

	private static Pet pet(String name, int age) {
		Pet pet = new Pet();
		pet.setName(name);
		pet.setAge(age);
		return pet;
	}

	private static BasicDataSource ds;
	private static Dao dao;

	/**
	 * 建立一个数据源，你可以根据自己数据库的实际情况修改下面的代码
	 * 
	 * @return 数据源对象
	 */
	public static DataSource getDataSource() {
		ds = new BasicDataSource();
		ds.setDriverClassName("org.postgresql.Driver");
		ds.setUrl("jdbc:postgresql://localhost:5432/daodemo");
		ds.setUsername("postgres");
		ds.setPassword("123456");
		return ds;
	}

	/**
	 * 关闭数据源
	 */
	public static void closeDataSource() {
		if (null != ds)
			try {
				ds.close();
			} catch (SQLException e) {}
	}

	/**
	 * 建立一个 Dao 对象。在你的项目里，你通常会在一个容器里缓存这个对象。
	 * 
	 * @return Dao 对象
	 */
	public static Dao getDao() {
		if (null == dao)
			dao = new NutDao(getDataSource());
		return dao;
	}

	/**
	 * 控制台打印的帮助函数
	 * 
	 * @param obj
	 *            对象
	 */
	private static void print(Object obj) {
		System.out.printf("<Demo>: %s\n", obj);
	}

	/**
	 * 打印演示标题的帮助函数
	 * 
	 * @param str
	 *            演示标题
	 */
	private static void title(String str) {
		out.println();
		out.printf(">> %s:\n", str);
	}

	/**
	 * 主函数
	 */
	public static void main(String[] args) {
		prepareData();
		out.println("Demo Begin ...");
		out.print(Strings.dup('=', 40));
		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		demoFetch();
		demoUpdate();
		demoDelete();
		demoClear();
		demoInsertAndQuery();
		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		closeDataSource();
		out.println(Strings.dup('=', 40));
		out.println("... Demo End");
	}

	/**
	 * 演示如何获取对象
	 */
	static void demoFetch() {
		title("依靠 @Id 获取");
		Pet xb = dao.fetch(Pet.class, 1);
		print(xb);

		title("依靠 @Name 获取");
		Pet xh = dao.fetch(Pet.class, "XiaoHei");
		print(xh);

		title("依靠数据库自然排序，获取第一个宠物");
		Pet pet = dao.fetch(Pet.class);
		print(pet);

		title("获取第一个年龄大于 8 岁的宠物（按名称降序）");
		pet = dao.fetch(Pet.class, Cnd.where("age", ">", 8).asc("name"));
		print(pet);

		title("根据一个对象，自动决定用 @Id 还是 @Name");
		Pet p = new Pet();
		p.setId(2);
		pet = dao.fetch(p);
		print(pet);
	}

	/**
	 * 演示如何更新对象
	 */
	static void demoUpdate() {
		title("更新对象");
		Pet pet = dao.fetch(Pet.class);
		pet.setAge(50);
		dao.update(pet);
	}

	/**
	 * 演示如何删除对象
	 */
	static void demoDelete() {
		// Demo I ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		title("依靠 @Id 删除");
		int num = dao.count(Pet.class);
		print("数据表中有 " + num + " 条记录");

		dao.delete(Pet.class, 1);

		num = dao.count(Pet.class);
		print("数据表中有还剩 " + num + " 条记录");

		// Demo II ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		title("依靠 @Name 删除");
		num = dao.count(Pet.class);
		print("数据表中有 " + num + " 条记录");
		dao.delete(Pet.class, "Manto");
		num = dao.count(Pet.class);
		print("数据表中有还剩 " + num + " 条记录");
	}

	/**
	 * 演示如何清除对象
	 */
	static void demoClear() {
		print("\n\n重新准备数据 ...");
		prepareData();
		title("删除所有年龄大于 8 岁的宠物");
		int num = dao.count(Pet.class);
		print("数据表中有 " + num + " 条记录");

		dao.clear(Pet.class, Cnd.where("age", ">", 8));

		num = dao.count(Pet.class);
		print("数据表中有还剩 " + num + " 条记录");

		title("删除所有宠物");
		num = dao.count(Pet.class);
		print("数据表中有 " + num + " 条记录");

		dao.clear(Pet.class);

		num = dao.count(Pet.class);
		print("数据表中有还剩 " + num + " 条记录");
	}

	/**
	 * 演示如何插入以及查询数据
	 */
	static void demoInsertAndQuery() {
		title("插入40个新 宠物...");
		List<Pet> pets = new ArrayList<Pet>(40);
		StringGenerator sg = new StringGenerator(3, 8);
		for (int i = 0; i < 40; i++) {
			pets.add(pet(sg.next(), R.random(1, 5 + i)));
		}
		dao.insert(pets);

		title("查询全部宠物");
		pets = dao.query(Pet.class, null, null);
		for (Pet pet : pets)
			print(pet);

		title("查询全部宠物，并按名字排序");
		pets = dao.query(Pet.class, Cnd.orderBy().asc("name"), null);
		for (Pet pet : pets)
			print(pet);

		title("按页查询，每页4个宠物，列出第2页，并按名称排序");
		Pager pager = dao.createPager(2, 4);
		pets = dao.query(Pet.class, Cnd.orderBy().asc("name"), pager);
		for (Pet pet : pets)
			print(pet);
		pager.setRecordCount(dao.count(Pet.class));
		print(pager.toString());
	}

}
