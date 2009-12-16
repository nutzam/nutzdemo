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
	<link type="text/css" href="themes/base/ui.all.css" rel="stylesheet" />
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="ui/ui.core.js"></script>
	<script type="text/javascript" src="ui/ui.tabs.js"></script>
	<script type="text/javascript">
		$(function() {
			$("#tabs").tabs({
				collapsible: true
			});
		});
	</script>
</head>
<body>
<div id="tabs" >
<ul>
	<li><a href="#tabs-1">Account Management</a></li>
	<li><a href="#tabs-2">Tab 1</a></li>
	<li><a href="#tabs-3">Tab 2</a></li>
</ul>
<div id="tabs-1">
<iframe width="1000px" height="800px" name="iframe" id="iframe"
			src="mvc/account/showAllAccounts.do" frameborder="0"></iframe>
</div>
<div id="tabs-2">
<p>Not Implement</p>
</div>
<div id="tabs-3">
<p>Not Implement</p>
</div>
</div>
</body>
</html>