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
<title>${msg.index_jsp_page_title}</title>
<link type="text/css" href="themes/base/ui.all.css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="ui/ui.core.js"></script>
<script type="text/javascript" src="ui/ui.tabs.js"></script>
<style type="text/css">
	li { font-size: 15px; }
</style>
<script type="text/javascript">
	$(function() {
		$("#tabs").tabs( {
			collapsible : false
		});
	});
</script>
</head>
<body>
<div class="ui-tabs ui-widget ui-widget-content ui-corner-all" id="tabs">
<ul
	class="ui-tabs-nav ui-helper-reset ui-helper-clearfix ui-widget-header ui-corner-all">
	<li
		class="ui-state-default ui-corner-top ui-tabs-selected ui-state-active"><a
		href="#tabs-1">${msg.index_jsp_tab1_title}</a></li>
	<li class="ui-state-default ui-corner-top"><a href="#tabs-2">${msg.index_jsp_tab2_title}</a></li>
	<li class="ui-state-default ui-corner-top"><a href="#tabs-3">${msg.index_jsp_tab3_title}</a></li>
</ul>
<div id="tabs-1"><iframe width="100%" height="600px"
	name="iframe" id="iframe" src="mvc/account/showAllAccounts.do"
	frameborder="0"></iframe></div>
<div id="tabs-2">
<p>Not Implement</p>
</div>
<div id="tabs-3">
<p>Not Implement</p>
</div>
</div>
</body>
</html>