package cn.nutz.tool;

import java.util.Map;

import org.nutz.http.Http;

/**
 * HttpClient提交工具类
 * @author Howe
 *
 */
public class HttpClientTool {

	/**
	 * POST提交
	 * @param url
	 * @return
	 */
	public static String post(String url, Map<String, Object> parms){
		
		try {
			
			return Http.post(url, parms, "utf-8", "utf-8");
		} catch (Exception e) {			
			return null;
		}
	}
	
	/**
	 * Get提交
	 * @param url
	 * @return
	 */
	public static String get(String url){
		
		try {
		
			return Http.get(url).getContent("utf-8");
		} catch (Exception e) {
			return null;
		}
	}
}
