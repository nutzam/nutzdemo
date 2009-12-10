<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<base href="<%=basePath%>">
<title>Insert title here</title>
</head>
<body>
<table width="100%" height="100%" border="1" cellpadding="0"
	cellspacing="0">
	<tr height="100%">
		<td width="200px" height="100%" valign="top"><a
			href="mvc/account/showAllAccounts.do" target="iframe">Account
		Management</a></td>
		<td><iframe width="100%" height="100%" name="iframe" id="iframe"
			src=""></iframe></td>
	</tr>
</table>
</body>
</html>