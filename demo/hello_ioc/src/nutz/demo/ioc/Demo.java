package nutz.demo.ioc;

import static java.lang.System.out;

import java.lang.reflect.Method;

import org.nutz.lang.Lang;
import org.nutz.lang.Strings;

public class Demo {

	public static void doDemo(Object demo) throws Exception {
		for (Method m : demo.getClass().getMethods()) {
			if (m.getName().startsWith("demo")) {
				out.println();
				out.println();
				out.println(Strings.dup('*', 40) + "<" + Demo.title(m.getName()) + ">");
				m.invoke(demo);
			}
		}
	}

	static String title(String title) {
		String[] ss = Strings.splitIgnoreBlank(title, "_");
		for (int i = 0; i < ss.length; i++)
			ss[i] = Strings.capitalize(ss[i]);
		return Lang.concat(' ', ss).toString();
	}

}
