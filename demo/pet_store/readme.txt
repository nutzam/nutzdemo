nutz的demo的pet store最基本的版本已经完成，非常简单的功能，用了这么久，实在惭愧啊。

svn：
	URL:https://nutzdemo.googlecode.com/svn/trunk/demo/pet_store
	用户名:用户名是google code的用户名
	密码:密码在 google code->Profile->Setting中能看到

里面所依赖的jar我没有上传到svn上面，觉得没什么用，但是我传到了http://code.google.com/p/nutzdemo/downloads/list 上面。
数据库的创建sql在目录ddl里面，由于我开发环境是postgres，所以只测试了PostgreSQL，过两天会在mysql下进行测试。
数据库的配置文件在src\org\nutz\demo\petstore\ioc\config\dao.js
默认的数据库名称是：Nutz_Demo_PetStore ， 请注意在PostgresSQL中数据库的名称是区分大小写的。
ddl目录中的sql文件时从java的ipetstore中copy过来的还没有进行更改，以后会对其进行优化。
由于此项目的ui是用jquery ui写的，所以项目中会有很多多余的代码，等有时间会对其进行精简。
