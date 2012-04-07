<%@page language="java" contentType="text/html; charset=utf-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<title>服务器出错</title>
</head>
<body>
	<%= exception.getMessage()%>
</body>
</html>