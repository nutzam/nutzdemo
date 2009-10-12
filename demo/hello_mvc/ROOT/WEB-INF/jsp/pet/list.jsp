<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="/WEB-INF/tld/c.tld"%>
<html>
<head>
</head>
<body>
<c:forEach var="user" items="${obj.list}">
<span>${user.name}</span>
</c:forEach>
</body>
</html>