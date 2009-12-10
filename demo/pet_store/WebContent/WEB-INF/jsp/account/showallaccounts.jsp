<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery.js"></script>
<style type="text/css">
.userid {
	color: red;
	event: expression(
		onclick = function() {
			alert(1);
		}
	);
}
</style>
<script type="text/javascript">
	
</script>
</head>
<body>
<table width="100%" border="1" cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<td>User ID</td>
			<td>First Name</td>
			<td>Last Name</td>
			<td>Email Addreass</td>
			<td>phone</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="account" items="${accounts}">
			<tr>
				<td><a href="javascript:void(0);" class="userid">${account.userid}</a></td>
				<td>${account.firstName}</td>
				<td>${account.lastName}</td>
				<td>${account.email}</td>
				<td>${account.phone}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</body>
</html>