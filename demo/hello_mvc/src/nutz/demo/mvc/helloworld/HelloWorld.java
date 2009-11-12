package nutz.demo.mvc.helloworld;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.nutz.json.Json;
import org.nutz.lang.Lang;
import org.nutz.lang.Strings;
import org.nutz.lang.meta.Email;
import org.nutz.mvc.Mvcs;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.Param;

/**
 * 这是一个非常简单的模块，它甚至都没有用到注入。
 * <p>
 * 通过这个例子我只是想 告诉大家， Nutz.Mvc 可以让你的代码变得有多简洁
 * <p>
 * 你还可以在模块类上声明：
 * <ul>
 * <li>'@At' 整个模块的 URL 的前缀，如果不声明，则如前缀。如果不声明值，对于本模块，为 /helloworld
 * <li>'@Ok' 整个模块默认的，顺利执行完操作后的渲染视图
 * <li>'@Fail' 整个模块默认的，执行操作期间发生 Exception 的渲染视图
 * <li>'@AdaptBy' 这个模块默认的，处理 HTTP 请求的方式。 如不声明,则用整个应用的默认值。
 * 如果应用没有设置这个注解，则采用普通名值对的方式处理请求。 细节，请参看 org.nutz.mvc.param.PairHttpAdaptor 的说明
 * </ul>
 * 如果你想让 Nutz.Ioc 来让你的模块类拥有更灵活的结构，请用注解 '@InjectName' 来声明当前模块的 Ioc 注入名。
 * 当然，前提是，你必须在你的应用配置类上（你声明在 web.xml 的那个类）注明 '@IocBy'。 以便框架知道如何为你生成 Ioc 接口的实现
 * <p>
 * 我假设你是了解 Nutz.Ioc 的，如果不了解，并且想用注入的办法组织的你应用程序，请起码先从 Demo 项目中找找 HelloIoc 来看看
 * <p>
 * 本模块类的 '@Ok' 注解说明了某模块所有函数执行成功后默认的渲染方式，如果模块内的入口函数没有声明自己的 @Ok， 那么将使用 Json
 * 的方式默认进行渲染
 * <p>
 * <p>
 * 延伸阅读，建议大家阅读一下 org.nutz.mvc.ViewMaker 的 JDoc， 上面写的很清楚。 尤其是告诉你如何自己动手
 * 支持其他的模板引擎。总的来说，就是实现两个接口，以及在自己的应用上增加一项配置
 * 
 * @author zozoh
 */
@Ok("json")
@At
public class HelloWorld {

	/**
	 * 任何一个函数都可以作为入口函数。只要它是 public 并且声明了 @At 注解，那么就会被框架 当做入 口函数 当前的函数将自动和路径
	 * "/全小写函数名" 挂接。
	 * <p>
	 * 当然，如果你在整个模块类上也声明了 '@At' 注解，那么显然你当前的函数挂接的 URL 就得和模块的 Url 合并了。
	 * <p>
	 * <i>网址示意： http://localhost:8080/hellomvc/say.nut</i>
	 */
	@At
	public String say() {
		return "Hello world";
	}

	/**
	 * 这个函数显示了更多的配置。 你可以随意定义你的函数所要挂接的 URL。 在默认的适配方式下（名值对的方式）你也可以通过 '@Param'
	 * 注解将你的函数任意的参数对应到 HTTP 的参数上。
	 * <p>
	 * <i>网址示意： http://localhost:8080/hellomvc/yousay.nut?word=xxx</i>
	 * 
	 * @param word
	 *            : 这个参数是从浏览器传上来的 '@Param' 注解声明了它的 HTTP 参数名
	 * @return 函数的返回对象是个字符串，这个字符串将按照 JSON 的方式，显示在浏览器上
	 */
	@At("/yousay")
	public String sayMore(@Param("word") String word) {
		if (Strings.isBlank(word))
			return say();
		return "You said: " + word;
	}

	/**
	 * 你可以返回各种类型的对象， 框架会帮你转换成正确的 Json 字符串
	 * <p>
	 * <i>网址示意： http://localhost:8080/hellomvc/time.nut</i>
	 */
	@At("/time")
	public Calendar tellTime() {
		return Calendar.getInstance();
	}

	/**
	 * 即使是数组，集合，Map，都不在话下
	 * <p>
	 * <i>网址示意： http://localhost:8080/hellomvc/map.nut</i>
	 */
	@At("/map")
	@Ok("json:{compact:false, quoteName:false}")
	public Map<String, Object> tellMap() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("anotherMap", Json.fromJson(HashMap.class, "{a:2,b:'ttt'}"));
		map.put("customized object", new Email("zozohtnt@gmail.com"));
		map.put("array", Lang.array(new Email("A@B"), new Email("C@D")));
		map.put("list", Json.fromJson(ArrayList.class, "[2,3,'tttt']"));
		return map;
	}

	/**
	 * 在你的逻辑中，很多时候，你可能会用到下面这些接口：
	 * <ul>
	 * <li>HttpServletRequest
	 * <li>ServletRequest
	 * <li>HttpServletResponse
	 * <li>ServletResponse
	 * <li>HttpSesssion
	 * <li>ServletContext
	 * <li>Ioc
	 * </ul>
	 * 很简单，你直接在入口函数中声明它们就是了，框架会自动为你设置值的。并且不限顺序，不限个数。 比如下面的例子中，我们就需要一个
	 * HttpServletRequest，声明了，你就会得到它。
	 * <p>
	 * <i>网址示意： http://localhost:8080/hellomvc/params.nut</i>
	 * 
	 * @param request
	 *            : 这个参数会被正确设置
	 * @Param session: 这个参数会被正确设置
	 * @param word
	 *            你传入的参数
	 * @return 一个字符串，将被渲染成 Json 字符串
	 */
	@At("/params")
	public String tellMore(	HttpServletRequest request,
							@Param("word") String word,
							HttpSession session) {
		return "You said: " + word + " => " + request.getLocale().toString() + " :: session: "
				+ session.getId();
	}

	/**
	 * '@At' 注解支持你写多个路径，这些路径都会映射到你的这个入口函数
	 * 
	 * <p>
	 * <b>网址示意：</b><br>
	 * <i> http://localhost:8080/hellomvc/tls.nut</i><br>
	 * 或<br>
	 * <i>http://localhost:8080/hellomvc/lots.nut</i>
	 */
	@At({"/tls", "/lots"})
	public String tellLots(HttpServletRequest req) {
		return String.format("URL is '%s'", Mvcs.getRequestPath(req));
	}

	/**
	 * 如果你用 '@At' 注解声明了一个通配符， 那么通配符之后的内容，都会被框架自动拆分成参数 并填充到入口函数的参数中。
	 * <p>
	 * 比如下面这个例子，如果你访问 <b>/path/1234</b>， 那么，这个函数的第一个参数会被赋值为 1234 <br>
	 * 如果你访问 <b>/path/1234/TTT</b>，那么，第一个参数会被赋值为 1234，第二个参数被赋值为 TTT，但是遗憾的
	 * 是，你没有第二个参数，并且框架也不支持同名的入口函数（那会引发不可预知的错误）
	 * <p>
	 * 当然，如果你访问 /path/123TTT，会引发类型转换失败的错误，因为 123TTT 是不能被转成数字的。
	 * <p>
	 * 如果你声明 '@At("/path*")'，并访问 /path/1234，那么框架会试图将 <b>/1234</b>
	 * 转成数字，同样也会引发类型转换错误。
	 * <p>
	 * <i>网址示意： http://localhost:8080/hellomvc/path/1234.nut</i>
	 */
	@At("/path/*")
	public String pathId(int id) {
		return String.format("My is id [%d]", id);
	}

	/**
	 * 这个例子展示了一个路径多个参数
	 * <p>
	 * <b>网址示意</b>
	 * <ul>
	 * <li>http://localhost:8080/hellomvc/path2/1234.nut<br>
	 * 输入: <b>"id: 1234 | txt: null | word: null"</b>
	 * <li>http://localhost:8080/hellomvc/path2/1234/sometxt.nut<br>
	 * 输入: <b>"id: 1234 | txt: sometxt | word: null"</b>
	 * <li>http://localhost:8080/hellomvc/path2/1234/sometxt/abc.nut<br>
	 * 输入: <b>"id: 1234 | txt: sometxt | word: abc"</b>
	 * <li>http://localhost:8080/hellomvc/path2/1234/sometxt.nut?word=TTT<br>
	 * 输入: <b>"id: 1234 | txt: sometxt | word: TTT"</b>
	 * <li>http://localhost:8080/hellomvc/path2/1234/sometxt/abc.nut?word=TTT<br>
	 * 输入: <b>"id: 1234 | txt: sometxt | word: abc"</b>
	 * </ul>
	 * 
	 * 由此可见，路径参数比 GET 参数优先级更高。
	 * <p>
	 * <b>注意：</b>，如果你的函数的参数为数字（整数浮点），你必须保证它是有值的。否则，会造成类型转换错误
	 * 
	 */
	@At("/path2/*")
	public String pathMulti(int id, String txt, @Param("word") String word) {
		return String.format("id: %d | txt: %s | word: %s", id, txt, word);
	}
}
