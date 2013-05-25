package cn.nutz.tool;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;

/**
 * 工具类
 * 
 * @author Howe
 * 
 */
public class ToolUtility {

	/**
	 * 获取IP
	 * 
	 * @param request
	 * @return
	 */
	public static String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	/**
	 * 判断是否是数字
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNumeric(String str) {
		
		if(str==null || str.equals(""))
			return false;
		for (int i = str.length(); --i >= 0;) {
			if (!Character.isDigit(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 生成随机数字
	 * 
	 * @param length
	 *            长度
	 * @return
	 */
	public static String getRandomNumber(int length) {
		String base = "0123456789";
		Random random = new Random();
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int number = random.nextInt(base.length());
			buffer.append(base.charAt(number));
		}
		return buffer.toString();
	}

	/**
	 * 生成随机字符
	 * 
	 * @param length
	 *            长度
	 * @return
	 */
	public static String getRandomString(int length) {
		String base = "abcdefghijklmnopqrstuvwxyz0123456789";
		Random random = new Random();
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int number = random.nextInt(base.length());
			buffer.append(base.charAt(number));
		}
		return buffer.toString();
	}
}
