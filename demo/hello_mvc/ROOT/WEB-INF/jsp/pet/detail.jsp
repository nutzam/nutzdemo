<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="/WEB-INF/tld/c.tld"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Hello Mvc</title>
</head>
<body>
<form name="pet">
<table>
	<tr>
		<td>${msg.pet_name }:</td>
		<td><input name="name" value="${obj.name }" /></td>
	</tr>
	<tr>
		<td>${msg.pet_age }:</td>
		<td><input name="age" value="${obj.age }" /></td>
	</tr>
	<tr>
		<td>${msg.pet_race }:</td>
		<td><input name="race" value="${obj.race }" /></td>
	</tr>
	<tr>
		<td>${msg.pet_color }:</td>
		<td><input name="color" value="${obj.color }" /></td>
	</tr>
</table>
</form>
</body>
</html>