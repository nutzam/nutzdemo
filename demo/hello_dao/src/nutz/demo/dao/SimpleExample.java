package nutz.demo.dao;

import java.io.File;
import java.sql.SQLException;

import javax.sql.DataSource;

import nutz.demo.dao.meta.Pet;

import org.apache.commons.dbcp.BasicDataSource;
import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.dao.impl.NutDao;
import org.nutz.dao.tools.Tables;
import org.nutz.lang.Files;
import org.nutz.lang.Strings;

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
		Tables.run(dao, dodFile);

		Pet pet = new Pet();
		pet.setName("XiaoBai");
		pet.setAge(8);
		dao.insert(pet);

		pet = new Pet();
		pet.setName("XiaoHei");
		pet.setAge(5);
		dao.insert(pet);

		pet = new Pet();
		pet.setName("Manto");
		pet.setAge(11);
		dao.insert(pet);
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
		out.printf(">> %s:\n",str);
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
		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		closeDataSource();
		out.println(Strings.dup('=', 40));
		out.println("... Demo End");
	}

	/**
	 * 演示如何获取对象
	 */
	static void demoFetch() {
		title("依靠 @Id");
		Pet xb = dao.fetch(Pet.class, 1);
		print(xb);

		title("依靠 @Name");
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

}
