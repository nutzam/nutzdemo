package nutz.demo.ioc.hello;

import nutz.demo.ioc.Demo;
import nutz.demo.ioc.meta.*;

import org.nutz.ioc.Ioc;
import org.nutz.ioc.impl.NutIoc;
import org.nutz.ioc.loader.json.JsonLoader;
import org.nutz.lang.Lang;

import static java.lang.System.*;

/**
 * 这个例子中，我们将围绕着一组简单的对象，来看看通过 Ioc 可以让它们之间的组合有多好玩：
 * <p>
 * 比如，一台计算机，它最主要的两个部件就是 CPU 和内存了。因为我建立如下对象：
 * 
 * <pre>
 * 计算机 (Computer)
 * 	CPU
 * 	内存
 * 	其他组件
 * </pre>
 * 
 * 在 nutz.demo.ioc.meta 包里，就是这些对象的实现和接口。 我最关心的是，根据不同组合，到底 我的计算机需要花费多少钱才能到手。
 * 
 * @author zozoh(zozohtnt@gmail.com)
 */
public class HelloIoc {

	public static void main(String[] args) throws Exception {
		Demo.doDemo(new HelloIoc());
	}

	/**
	 * Nutz.Ioc 最重要的一种注入对象映射，就是利用 JSON。 你可以写一个 JSON 文件，或者直接硬编码 你的配置字符串。因为 JSON
	 * 的小巧的有点，硬编码也是可以接受的。如果是 XML，我想不会有人想要硬编码它的。
	 * <p>
	 * 在阅读这个例子之前，我想如果花几分钟了解一下 JSON 配置的语法是个好主意，下面是JSON注入语法的简要说明:
	 * 
	 * <pre>
	 * &lt;xxx.js&gt; // JSON 配置文件，虚线以下为文件正文
	 * --------------------------------------------------------------
	 * obj1 : {
	 * 	type : 'com.you.ObjTypeName',  // 对象类型全名，默认为 Ioc.get() 第一个参数
	 * 	singleton : true,	// 是否为单例，默认为 true
	 * 	args : [ $V1, $V2 ],  // 构造函数参数数组，
	 * 	parent : 'xxx',  // 当前对象的配置信息继承自哪个对象，默认为 null
	 * 	lifecycle : { // 三个属性的值为字符串，可以是当前对象某个方法名，或 org.nutz.ioc.ObjCallback 接口的某个实现
	 *  		create : 'xxx',	// 当对象被创建时调用
	 *  		depose : 'xxx', // 当对象被丢弃时调用
	 *  		fetch  : 'xxx'  // 当每次 Ioc.get() 都会被调用
	 * 	}, // 这个属性，默认为 null。
	 * 	fields : {		// 说明了对象每个字段的值
	 * 		field1 : $V ,
	 * 		field2 : $V
	 * 	}
	 * } , 
	 * obj2 : {
	 * 	... // 类似 obj1 
	 * }
	 * </pre>
	 * 
	 * 在上面的例子中，<b>$V</b> 代表值。它可以是：
	 * <ul>
	 * <li>字符串 ： 由 单引号（'）或者双引号（"）包裹
	 * <li>数字 ： 整数或者浮点数均可，整数后缀 L 表示其为一个长整型
	 * <li>布尔 ： true | false
	 * <li>一般 Java 对象 : 形式同字符串相同， Nutz.Ioc 会尝试自动为你转型成对应的对象。比如日期对象等，均可支持
	 * <li>引用 : {refer: '另外一个对象名'}
	 * <li>内部对象： 也就是匿名对象，{type:'xxx',fields:{...}}
	 * <li>环境变量 : {env : '系统环境变量名'}
	 * <li>文件 : {disk: '文件路径'}，会生成一个 java.io.File 对象
	 * <li>数组或列表 ： 形式为 [$V, $V ...]， 根据对应字段的类型决定
	 * <li>Map : 形式为 {key1: $V, key2: $V}
	 * <li>Java 调用 : {java: '类全名.函数名'}，函数不能有参数，且必须为静态
	 * </ul>
	 * 
	 * 
	 * 你要是想看更多关于 Nutz.Ioc 深入的阐述，请去它的官方网站下载用户手册
	 * <p>
	 * 下面请看这个例子，我一步一步的给你详细讲解。
	 */
	public void demo_simple_ioc_by_string() {
		/*
		 * 这就是 JSON 配置信息，存放在一个字符串中
		 */
		String s = "{";
		s = s + "\n		intel : {type:'nutz.demo.ioc.meta.IntelE5300'},";
		s = s + "\n		amd : {},";
		s = s + "\n		c1 : {";
		s = s + "\n			type : 'nutz.demo.ioc.meta.Computer',";
		s = s + "\n			fields : {";
		s = s + "\n				cpu : {refer: 'intel'},";
		s = s + "\n				memory : {type : 'nutz.demo.ioc.meta.Kingston'},";
		s = s + "\n				others : 2000";
		s = s + "\n			}";
		s = s + "\n		}";
		s = s + "\n	}";
		/*
		 * 我们通过一个 Reader 把字符串连接到 JsonLoader。
		 */
		Ioc ioc = new NutIoc(new JsonLoader(Lang.inr(s)));
		/*
		 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		 * 因为 intel 对象声明了类型，所以你不用传入类型也能获得正确的结果
		 */
		CPU cpu = ioc.get(null, "intel");
		out.println("inter: " + cpu.getClass().getName());

		/*
		 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		 * 由于 amd 对象没有声明类型，所以你必须指明一个类型
		 */
		cpu = ioc.get(AmdAthlonII.class, "amd");
		out.println("amd: " + cpu.getClass().getName());

		/*
		 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		 * 所以，有趣的是，我们甚至还可以来个张冠李戴，因为配置信息中并没有 限制对象的类型
		 */
		ioc.reset(); // 原来的 "amd" 对象已经被缓存了，这里需要先清除一下。
		cpu = ioc.get(IntelE5300.class, "amd");
		out.println("amd: " + cpu.getClass().getName());

		/*
		 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		 * 如果在配置中声明了对象的类型，它的优先级比你传入参数时声明的还要高
		 */
		cpu = ioc.get(AmdAthlonII.class, "intel");
		out.println("inter: " + cpu.getClass().getName());

		// 请注意，如果你的对象没有声明 type，那么在其他的对象中 refer 它，多半会出错的
		// 除非“其他对象” 对应字段的类型不是抽象类型，是可以直接被创建的。

		/*
		 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		 * 下面我们试着来获取个一个复杂些的对象看看。 请仔细阅读函数首部的配置:
		 */
		Computer c1 = ioc.get(Computer.class, "c1");
		c1.printBrief();

		// 对于 c1 对象，我们为它声明了三个字段的值：
		// "cpu" 字段，我们直接引用了前面声明的 'intel' 对象
		out.printf("c1 is same? %s\n", ioc.get(null, "intel") == c1.getCPU());

		// 对于 memory 对象，我们使用了“内联”方法，它就是个“内部对象”
	}

	/**
	 * 这个例子演示了 singleton 的用法
	 */
	public void demo_singleton() {
		String s = "{amd:{},intel:{singleton:false}}";
		Ioc ioc = new NutIoc(new JsonLoader(Lang.inr(s)));
		/*
		 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		 * 连续获取两遍 amd 对象，看看它们是否相同
		 */
		CPU cpu = ioc.get(AmdAthlonII.class, "amd");
		CPU cpu2 = ioc.get(AmdAthlonII.class, "amd");
		out.println("Object 'amd' is singleton? " + (cpu == cpu2));

		/*
		 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		 * 而 intel 对象不是单例，所以每次，获取，都会创建一个新的实例
		 */
		cpu = ioc.get(IntelE5300.class, "intel");
		cpu2 = ioc.get(IntelE5300.class, "intel");
		out.println("Object 'intel' is singleton? " + (cpu == cpu2));

		/*
		 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		 * 无论什么类型
		 */
		cpu = ioc.get(AmdAthlonII.class, "intel");
		cpu2 = ioc.get(AmdAthlonII.class, "intel");
		out.println("Object 'intel/amd' is singleton? " + (cpu == cpu2));
	}

	/**
	 * JSON 配置的硬编码，适用于一些不太复杂的配置，如果配置的复杂了，单独做一个 JSON 文件 会比较方便。
	 */
	public void demo_json_in_file() {
		Ioc ioc = new NutIoc(new JsonLoader("nutz/demo/ioc/hello/hello.js"));
		Computer c1 = ioc.get(Computer.class, "c1");
		Computer c2 = ioc.get(Computer.class, "c2");

		c1.printBrief();
		c2.printBrief();
	}

	/**
	 * 让我们再创建一个文件 -- lifecycle.js，并将它同 hello.js 一起使用
	 */
	public void demo_events() {
		// JsonLoader 很容易组合很多个配置文件
		Ioc ioc = new NutIoc(new JsonLoader("nutz/demo/ioc/hello/hello.js",
				"nutz/demo/ioc/hello/events.js"));
		out.println("[For 'computer'] : ");
		// 因为对象不是单例， 将会触发 create 和 fetch
		out.println("> first ...");
		ioc.get(Computer.class, "computer");
		// 第二次获取，还会触发 create 和 fetch
		out.println("> second ...");
		ioc.get(Computer.class, "computer");
		// 因为对象不是单例，将不会触发 depose
		out.println("> depose ...");
		ioc.reset();

		out.println("\n[For 'c3'] : ");
		// 让我们获取一个单例对象看看
		// 第一次获取，将会触发 create 和 fetch
		out.println("> first ...");
		ioc.get(Computer.class, "c3");
		// 第二次获取，将只会触发 fetch
		out.println("> second ...");
		ioc.get(Computer.class, "c3");
		// 将会触发 depose
		out.println("> depose ...");
		ioc.reset();
	}

}
