package nutz.demo.mvc;

import nutz.demo.mvc.helloworld.HellowWorld;
import nutz.demo.mvc.pet.PetModule;

import org.nutz.mvc.annotation.Fail;
import org.nutz.mvc.annotation.IocBy;
import org.nutz.mvc.annotation.Modules;
import org.nutz.mvc.annotation.SetupBy;
import org.nutz.mvc.init.JsonIocProvider;

/**
 * 本类为整个应用的默认模块类。在这个类上，你可以：
 * <ul>
 * <li>通过 '@Modules' 注解声明整个应用有哪些模块
 * <li>通过 '@IocBy' 注解声明整个应用，应采用何种方式进行反转注入。如果没有声明，整个应用将不支持 Ioc
 * <li>通过 '@Localization' 注解声明整个应用的本地地化字符串的目录
 * <li>通过 '@SetupBy' 注解声明应用启动的关闭时，应该进行的处理。（通过 Setup 接口）
 * <li>通过 '@Ok' 注解声明整个应用，默认的成功视图
 * <li>通过 '@Fail' 注解声明整个应用默认的失败视图
 * </ul>
 * 
 * @author zozoh
 * 
 */
@Modules( { HellowWorld.class, PetModule.class })
@IocBy(type = JsonIocProvider.class, args = { "ioc/dao.js", "ioc/pets.js" })
@SetupBy(HelloMvcSetup.class)
@Fail("json")
public class MainModule {}
