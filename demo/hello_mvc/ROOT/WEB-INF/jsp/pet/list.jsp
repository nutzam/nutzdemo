<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="/WEB-INF/tld/c.tld"%>
<html>
<head>
</head>
<body>
<ol>
	<c:forEach var="pet" items="${obj.list}">
		<li>${pet.name}</li>
	</c:forEach>
</ol>
</body>
</html>