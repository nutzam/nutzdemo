package nutz.demo.ioc.book;

import org.nutz.ioc.Ioc2;
import org.nutz.ioc.impl.NutIoc;
import org.nutz.ioc.loader.json.JsonLoader;

public class HelloValueMaker {

	public static void main(String[] args) {
		Ioc2 ioc = new NutIoc(new JsonLoader("path/path/name.js"));
		ioc.addValueProxyMaker(new ScanValueProxyMaker());
	}

}
