<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="icon" href="favicon.ico" type="image/x-icon" />
<link href="${base}/template/admin/css/base.css" rel="stylesheet" type="text/css" />
<link href="${base}/template/admin/css/admin.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${base}/js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="${base}/template/admin/js/base.js"></script>
<script type="text/javascript" src="${base}/template/admin/js/admin.js"></script>
<script type="text/javascript">
$(function () {
	var $loginForm = $("#login_form");
	var $username = $("#username");
	var $password = $("#password");
	var $captcha = $("#captcha");
	var $isRememberUsername = $("#isRememberUsername");
	$loginForm.submit(function () {
		if ($username.val() == "") {
			$.dialog({type: "warn", content: "请输入您的用户名!", modal: true, autoCloseTime: 3000});
			return false;
		}
		if ($password.val() == "") {
			$.dialog({type: "warn", content: "请输入您的密码!", modal: true, autoCloseTime: 3000});
			return false;
		}
		if ($captcha.val() == "") {
			$.dialog({type: "warn", content: "请输入您的验证码!", modal: true, autoCloseTime: 3000});
			return false;
		}
		$.post("${base}/admin/usr/login", {
			"name" : $username.val(),
			"passwd" : $password.val(),
			"remeberMe":true,
			"code":$captcha.val()
		}, function(data) {
			if (data.ok==true) {
				location.href='/admin/page/main';
			} else {
				$.dialog({type: "error", content: data.msg, modal: true, autoCloseTime: 3000});
			}
		}, "json");
		return false;
	});
	// 刷新验证码
	var $captchaImage = $("#captchaImage");
	$captchaImage.click( function() {
		var timestamp = (new Date()).valueOf();
		var imageSrc = $captchaImage.attr("src");
		if(imageSrc.indexOf("?") >= 0) {
			imageSrc = imageSrc.substring(0, imageSrc.indexOf("?"));
		}
		imageSrc = imageSrc + "?timestamp=" + timestamp;
		$captchaImage.attr("src", imageSrc);
	});
});
</script>
<title>首页</title>
</head>
<body class="login">
	<div class="body">
		<form id="login_form" action="#" method="post">
            <table class="loginTable">
            	<tr>
            		<td rowspan="3">
            			<img src="${base}/template/admin/images/login_logo.gif" alt="管理中心" />
            		</td>
                    <th>
                    	用户名:
                    </th>
					<td>
                    	<input type="text" id="username" name="name" class="formText" />
                    </td>
                </tr>
                <tr>
					<th>
						密&nbsp;&nbsp;&nbsp;码:
					</th>
                    <td>
                    	<input type="password" id="password" name="passwd" class="formText" />
                    </td>
                </tr>
                <tr>
                	<th>
                	验证码:
                	</th>
                    <td>
                    <input type="text" id="captcha" name="code" class="formText captcha" />
                   		<img id="captchaImage" class="captchaImage" src="${base}/security/captcha" alt="换一张" />
                    </td>
                </tr>
                <tr>
                	<td>
                		&nbsp;
                	</td>
                	<th>
                		&nbsp;
                	</th>
                    <td>
                    	<label>
                    		<input type="checkbox" id="isRememberUsername"/>&nbsp;记住用户名
                    	</label>
                    </td>
                </tr>
                <tr>
                	<td>
                		&nbsp;
                	</td>
                	<th>
                		&nbsp;
                	</th>
                    <td>
                        <input type="button" class="homeButton" value="" onclick="window.open('${base}/')" hidefocus /><input type="submit" class="submitButton" value="登 录" hidefocus />
                    </td>
                </tr>
            </table>
            <div class="powered">
            	COPYRIGHT © 2005-2011 NUTZ.ORG ALL RIGHTS RESERVED.
            </div>
            <div class="link">
            	<a href="${base}/">前台首页</a> |
				<a href="#">官方网站</a> |
				<a href="#">交流论坛</a> |
				<a href="#">关于我们</a> |
				<a href="#">联系我们</a> |
				<a href="#">授权查询</a>
            </div>
        </form>
	</div>
</body>
</html>