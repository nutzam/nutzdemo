<%@page import="org.apache.shiro.SecurityUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${base}/js/jquery-1.7.2.js"></script>
<script type="text/javascript">
var login = <%=SecurityUtils.getSubject().getPrincipal() != null %>;
$(function () {
	if (login) {
		$("#login_status").html("已登陆");
		$("#login_form").hide();
	} else {
		$("#login_status").html("未登陆");
		$("#logout_link").hide();
	}
	$("#login_form").submit(function () {
		//alert($("#login_form").serialize());
		$.ajax({
			url : "${base}/usr/login",
			data : $("#login_form").serialize() + "&remeberMe=true",
			success : function (res) {
				if (res == "true") {
					alert("登陆成功!!");
					$("#logout_link").show();
					$("#login_form").hide();
					$("#login_status").html("已登陆");
				} else {
					alert("登陆失败!!");
					$("#logout_link").hide();
					$("#login_form").show();
				}
				return false;
			},
			fail : function(res) {
				alert("系统错误?!");
			}
		});
		return false;
	});
});
</script>
<title>首页</title>
</head>
<body>
	<h1 id="login_status">未知</h1><p/>
	
	<form id="login_form" action="#">
		用户名:<input name="name"></input>
		密   码:<input name="passwd"></input>
		<input type="submit" value="提交"></input>
	</form>
	
	<a href="${base}/usr/logout" id="logout_link">登出</a>
</body>
</html>