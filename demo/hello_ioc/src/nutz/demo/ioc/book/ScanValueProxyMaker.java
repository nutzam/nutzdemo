package nutz.demo.ioc.book;

import org.nutz.ioc.IocMaking;
import org.nutz.ioc.ValueProxy;
import org.nutz.ioc.ValueProxyMaker;
import org.nutz.ioc.meta.IocValue;
import org.nutz.lang.Lang;

public class ScanValueProxyMaker implements ValueProxyMaker {

	@Override
	public ValueProxy make(IocMaking ing, IocValue iv) {
		if ("scan".equals(iv.getType())) {
			final String address = iv.getValue().toString();

			return new ValueProxy() {
				public Object get(IocMaking ing) {
					// 根据 address 创建一个对象
					throw Lang.noImplement();
				}

			};
		}
		return null;
	}

}
