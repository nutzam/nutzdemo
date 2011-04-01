添加一个Nutz的Captcha(验证码)的View插件
用法：
1.在主模块添加@Views(JPEGViewMaker.class)
2.在返回的地方使用JPEGView即可
3.获取Captcha的Session值,Session.getAttribute(JPEGView.CAPTCHA);