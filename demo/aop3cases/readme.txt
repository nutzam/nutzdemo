3个Aop例子,让你轻松入门Nut.Aop
By Wendal

依赖的jar,最新的nutz,为了输出日志,你还需要log4j,可以在lab中找到.

1. 例子A 改变返回值
Ioc ioc = new NutIoc(new JsonLoader("ioc.js"));
Integer integer = ioc.get(GetMinValue.class, "getmax").getMin();
System.out.printf("得到的值: %s \n",integer);

这个例子,通过拦截器,无视原有的返回值,自行返回一个值.

2. 例子B 改为调用其他方法
TwoMethod tm = ioc.get(TwoMethod.class, "tm");
DiffMethodInterceptor diffm = ioc.get(DiffMethodInterceptor.class, "diffm");
tm.methodA();//呼叫一下方法A,看看什么被执行了
//现在我对方法A不满,我觉得方法B会好些,so..
diffm.setCanOrgl(false);//告诉拦截器,我不想调用方法A了
tm.methodA();

通过设置拦截器的状态,可以随意改变调用哪一个方法,这可是运行时更改哦

3. 例子C 是一个简化的权限拦截器
ioc.get(CanPass.class, "canpass").getIt(); //看看你拿得多少钱
System.out.println("我是强盗,看看能拿到多少钱: "+ ioc.get(SecurityMethod.class, "securityMethod").giveMeMoney());
System.out.println(ioc.get(null, "securityMethod") instanceof SecurityMethod);

通过获取调用者的信息,判断是否允许调用原方法



4. 记住哦,这个都是需要Ioc支持的. O(∩_∩)O哈哈~
Any question? free to ask !