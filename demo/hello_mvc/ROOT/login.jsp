<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="/WEB-INF/tld/c.tld"%>
<html>
<head>
<title>Hello Mvc</title>
<link type="text/css" rel="stylesheet" href="${base}/css/hello.css"/>
</head>
<body>
<h1>Hello Mvc</h1>
<form action="${base}/login.o" method="POST">
<table>
	<tr>
		<td>${msg.login_name}</td>
		<td><input name="name"></td>
	</tr>
	<tr>
		<td>${msg.login_password}</td>
		<td><input name="pwd"></td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td><input type="submit" value="${msg.login_submit}" /></td>
	</tr>
</table>
</form>
</body>
</html>