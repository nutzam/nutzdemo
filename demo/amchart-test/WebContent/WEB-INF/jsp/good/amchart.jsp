<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${base}/amchart/swfobject.js"></script>
</head>
<body>
	<div id="amcharts_1261636719173">You need to upgrade your Flash Player</div>
	<script type="text/javascript">
		var so = new SWFObject("${base}/amchart/amcolumn_1.6.0.1/amcolumn/amcolumn.swf", "amcolumn", "600", "400", "8", "#FFFFFF");
		so.addVariable("path", "amcolumn/");
		so.addVariable("settings_file", encodeURIComponent("${base}/WEB-INF/jsp/good/amline_settings.xml"));
		so.addVariable("data_file", encodeURIComponent("${base}/"));
		so.write("amcharts_1261636719173");
	</script>
</body>
</html>