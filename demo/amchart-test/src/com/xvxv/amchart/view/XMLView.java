package com.xvxv.amchart.view;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.nutz.mvc.View;

/**
 * 定制的xml视图,使响应为xml数据
 * @author yinxvxv
 */
public class XMLView implements View {

	@Override
	public void render(HttpServletRequest request, HttpServletResponse response,
			Object obj) throws Throwable {
		response.setContentType("text/xml;charset=UTF-8");
		response.getWriter().print(obj.toString());
	}

}