package com.scxxs.cms.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.jsp.tagext.TagSupport;

public class FilterHTMLTag extends TagSupport {

	private static final long serialVersionUID = -3087821236259316254L;

	/**
	 * 去掉所有的HTML标签和空白符号
	 * @param htmlStr
	 * @return
	 */
	public static String delHTMLTag(String htmlStr) {
		String regEx_script = "<script[^>]*?>[\\s\\S]*?<\\/script>"; // 定义script的正则表达式
		String regEx_style = "<style[^>]*?>[\\s\\S]*?<\\/style>"; // 定义style的正则表达式
		String regEx_html = "<[^>]+>"; // 定义HTML标签的正则表达式
		String regEx_Space ="(\r?\n(\\s*\r?\n)+)";
		String regEx_white = "&nbsp;";
		
		Pattern p_script = Pattern.compile(regEx_script,
				Pattern.CASE_INSENSITIVE);
		Matcher m_script = p_script.matcher(htmlStr);
		htmlStr = m_script.replaceAll(""); // 过滤script标签

		Pattern p_style = Pattern
				.compile(regEx_style, Pattern.CASE_INSENSITIVE);
		Matcher m_style = p_style.matcher(htmlStr);
		htmlStr = m_style.replaceAll(""); // 过滤style标签

		Pattern p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
		Matcher m_html = p_html.matcher(htmlStr);
		htmlStr = m_html.replaceAll(""); // 过滤html标签
		
		Pattern p_space = Pattern.compile(regEx_Space, Pattern.CASE_INSENSITIVE);
		Matcher m_space = p_space.matcher(htmlStr);
		htmlStr = m_space.replaceAll("");//过滤空白数据
		
		htmlStr = htmlStr.replaceAll(regEx_white, "");//过滤&nbsp;
		
		return htmlStr.trim(); // 返回文本字符串
	}
	/**
	 * 判断文件是否为图片
	 * @param str
	 * @return
	 */
	public static boolean isPic(String str){
		if(str==null||"".equals(str)){
			return false;
		}
		return CheckFileType.isPic(str);
		
	}
	/**
	 * 判断是否有权限
	 * @param action
	 * @param acl
	 * @return
	 */
	public static boolean hasPermission(int action,int acl){
		boolean flag = false;
		if ((acl & action) == action) {
			// 判断角色优先级
			flag = !flag;
		}
		return flag;
	}

}
