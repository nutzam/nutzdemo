package nutz.demo.mvc;

import nutz.demo.mvc.helloworld.HellowWorld;

import org.nutz.mvc.annotation.Fail;
import org.nutz.mvc.annotation.Modules;

@Modules({HellowWorld.class})
@Fail("json")
public class HelloModules {}
