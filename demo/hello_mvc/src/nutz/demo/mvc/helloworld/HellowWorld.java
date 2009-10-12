package nutz.demo.mvc.helloworld;

import org.nutz.lang.Strings;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.Param;

public class HellowWorld {

	@At
	@Ok("json")
	public String say() {
		return "Hello world";
	}

	@At
	@Ok("json")
	public String sayMore(@Param("word") String word) {
		if (Strings.isBlank(word))
			return say();
		return "You said: " + word;
	}

}
