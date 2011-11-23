package org.nutz.demo.petstore.mvc.module;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.nutz.json.Json;
import org.nutz.mvc.Mvcs;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;

@At("/mvc/message")
public class MessageModule {
	@At
	@Ok("void")
	public void getMessage(HttpServletRequest request, HttpServletResponse response) throws IOException{
		Map<String, String> msgs = Mvcs.getMessages(request);
		String json = "{}";
		if(msgs!=null){
			json = Json.toJson(msgs);
		}
		response.getWriter().write("window.nutz_message="+json);
	}
}
