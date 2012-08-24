package com.rekoe.module;

import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;

public class IndexModule {

	@At({"/","/index"})
	@Ok("fm:front.index")
	public void index() {}
}
