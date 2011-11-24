package jetty7up;

import org.eclipse.jetty.server.Server;

/**
 * 使用Jetty运行调试Web应用, 在Console输入回车停止服务.
 * 
 */
public class NutzDwzHrStart {

	public static final int PORT = 81;
	public static final String CONTEXT = "";
	public static final String BASE_URL = "http://localhost:81";
	public static final String WEB_APP="WebRoot";
	public static void main(String[] args) throws Exception {
		long start=System.currentTimeMillis();
		Server server = JettyUtils.buildNormalServer(PORT, CONTEXT,WEB_APP);
		server.start();
		long timeSec = (System.currentTimeMillis() - start) / 1000;
		System.out.println("启动用时："+timeSec/60+"分"+timeSec%60+"秒\t"+BASE_URL);
		Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+BASE_URL);
	}
}
