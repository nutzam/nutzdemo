package cn.nutz_dwz_hr.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * web工具类
 *
 */
public class WebUtil {
	/**
	 * 获取登录员工
	 * @param request
	 * @return
	 */
//	public static Employee getEmployee(HttpServletRequest request) {
//		return (Employee) request.getSession().getAttribute("employee");
//	}
//
//	/**
//	 * 获取登录用户
//	 */
//	public static Member getMember(HttpServletRequest request) {
//		return (Member) request.getSession().getAttribute("user");
//	}
	public static String getLoginUser() {
		return "Dawn";
	}
	/***
	 * 获取URI的路径,如路径为http://www.lankew.com/action/post.htm?method=add, 得到的值为"/action/post.htm"
	 * @param request
	 * @return
	 */
	public static String getRequestURI(HttpServletRequest request) {
		return request.getRequestURI();
	}

	/**
	 * 获取完整请求路径(含内容路径及请求参数)
	 * @param request
	 * @return
	 */
	public static String getRequestURIWithParam(HttpServletRequest request) {
		return getRequestURI(request) + (request.getQueryString() == null ? "" : "?" + request.getQueryString());
	}

	/**
	 * @param request
	 * @return 应用程序的访问地址（不含端口号，因为发布后要使用80端口，即不用指定），如 http://localhost/lankew/
	 */
	public static String getBaseAccessUrlWithoutPort(HttpServletRequest request) {
		String path = request.getContextPath();
		// FIXME 把应用放到ROOT下时，path是否为'/'?!
		// 如果是，就应如下：
		if ("/".equals(path)) {
			path = ""; // 就忽略他
		}
		// FIXME 不加path了，是同一网站就行。   
		String basePath = request.getScheme() + "://" + request.getServerName(); // + path + "/";
		return basePath;
	}

	/**
	 * 添加cookie
	 * @param response
	 * @param name cookie的名称
	 * @param value cookie的值
	 * @param maxAge cookie存放的时间(以秒为单位,假如存放三天,即3*24*60*60; 如果值为0,cookie将随浏览器关闭而清除)
	 */
	public static void addCookie(HttpServletResponse response, String name, String value, int maxAge) {
		Cookie cookie = new Cookie(name, value);
		cookie.setPath("/");
		if (maxAge > 0)
			cookie.setMaxAge(maxAge);
		response.addCookie(cookie);
	}

	/**
	 * 添加cookie
	 * 
	 * @param response
	 * @param name Cookie的名称，不能为null
	 * @param value Cookie的值，默认值空字符串
	 * @param maxAge
	 * @param path 默认值'/'
	 */
	public static void addCookie(HttpServletResponse response, String name, String value, Integer maxAge, String path) {
		if (value == null) {
			value = "";
		}
		if (path == null) {
			path = "/";
		}

		Cookie cookie = new Cookie(name, value);
		cookie.setPath(path);
		if (maxAge != null) {
			cookie.setMaxAge(maxAge);
		}

		response.addCookie(cookie);
	}

	/**
	 * 获取cookie的值
	 * @param request
	 * @param name cookie的名称
	 * @return
	 */
	public static String getCookieByName(HttpServletRequest request, String name) {
		Map<String, Cookie> cookieMap = WebUtil.readCookieMap(request);
		if (cookieMap.containsKey(name)) {
			Cookie cookie = (Cookie) cookieMap.get(name);
			return cookie.getValue();
		} else {
			return null;
		}
	}

	/**
	 * 清空Cookie
	 * @param request
	 * @param response
	 */
	public static void removeCookie(HttpServletRequest request, HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				Cookie cookie = new Cookie("", null);
				cookie.setMaxAge(0);
				cookie.setPath("/");
				response.addCookie(cookie);
			}
		}
	}

	/**
	 * 通知浏览器删除自动登录的Cookie，并把用户实体的AutoLoginAuthKey清除。<br>
	 * 需要在外面update一下User对象。
	 * 
	 * @param response
	 * @param user
	 */
	public static void delCookie(HttpServletResponse response) {
		// 1，保存到客户端(发送Cookie)
		String cookieName = "userName";
		String cookieValue = "";
		Integer cookieAge = 0;
		String cookiePath = "/";
		// add cookie
		addCookie(response, cookieName, cookieValue, cookieAge, cookiePath);

		// 2，更新到用户实体中（需要update一下）
		// 不设置也可以
		// user.setAutoLoginAuthKey(null);
	}

	protected static Map<String, Cookie> readCookieMap(HttpServletRequest request) {
		Map<String, Cookie> cookieMap = new HashMap<String, Cookie>();
		Cookie[] cookies = request.getCookies();
		if (null != cookies) {
			for (int i = 0; i < cookies.length; i++) {
				cookieMap.put(cookies[i].getName(), cookies[i]);
			}
		}
		return cookieMap;
	}

	/**
	 * 去除html代码
	 * @param inputString
	 * @return
	 */
	public static String HtmltoText(String inputString) {
		String htmlStr = inputString; //含html标签的字符串
		String textStr = "";
		java.util.regex.Pattern p_script;
		java.util.regex.Matcher m_script;
		java.util.regex.Pattern p_style;
		java.util.regex.Matcher m_style;
		java.util.regex.Pattern p_html;
		java.util.regex.Matcher m_html;
		java.util.regex.Pattern p_ba;
		java.util.regex.Matcher m_ba;

		try {
			String regEx_script = "<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>"; //定义script的正则表达式{或<script[^>]*?>[\\s\\S]*?<\\/script> }
			String regEx_style = "<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>"; //定义style的正则表达式{或<style[^>]*?>[\\s\\S]*?<\\/style> }
			String regEx_html = "<[^>]+>"; //定义HTML标签的正则表达式
			String patternStr = "\\s+";

			p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);
			m_script = p_script.matcher(htmlStr);
			htmlStr = m_script.replaceAll(""); //过滤script标签

			p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);
			m_style = p_style.matcher(htmlStr);
			htmlStr = m_style.replaceAll(""); //过滤style标签

			p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
			m_html = p_html.matcher(htmlStr);
			htmlStr = m_html.replaceAll(""); //过滤html标签

			p_ba = Pattern.compile(patternStr, Pattern.CASE_INSENSITIVE);
			m_ba = p_ba.matcher(htmlStr);
			htmlStr = m_ba.replaceAll(""); //过滤空格

			textStr = htmlStr;

		} catch (Exception e) {
			System.err.println("Html2Text: " + e.getMessage());
		}
		return textStr;//返回文本字符串
	}

	/**
	 * 判断一个值是不是空值
	 * @param value
	 * @return
	 */
	public static boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}

	
}
