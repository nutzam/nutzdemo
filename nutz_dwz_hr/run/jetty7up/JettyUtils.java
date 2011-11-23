package jetty7up;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

/**
 * 创建Jetty Server的工具类.
 */
public class JettyUtils {
	

	/**
	 * 创建用于正常运行调试的Jetty Server, 以E:/ycsx/WebRoot为Web应用目录.
	 */
	public static Server buildNormalServer(int port, String contextPath,String weApp) {
		Server server = new Server(port);
		WebAppContext webContext = new WebAppContext(weApp, contextPath);
		webContext.setDefaultsDescriptor("./webdefault.xml");
		webContext.setClassLoader(Thread.currentThread().getContextClassLoader());
		server.setHandler(webContext);
		server.setStopAtShutdown(true);
		return server;
	}

	/**
	 * 创建用于Functional Test的Jetty Server:
	 * 1.以E:/ycsx/WebRoot为Web应用目录.
	 * 2.以conf/web.xml指向applicationContext-test.xml创建测试环境.
	 */
	public static Server buildTestServer(int port, String contextPath,String weApp) {
		Server server = buildNormalServer(port, contextPath,weApp);
		((WebAppContext) server.getHandler()).setDefaultsDescriptor(weApp+"/WEB-INF/web.xml");
		return server;
	}
}
