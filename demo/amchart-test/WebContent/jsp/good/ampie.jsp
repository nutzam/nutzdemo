<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<div id="amcharts_1261672227278" style="height: 100%;">You need to upgrade your Flash Player</div>
	<script type="text/javascript">
		var so = new SWFObject("${base}/amchart/ampie_1.6.0.1/ampie/ampie.swf", "amcolumn", "100%", "100%", "8", "#FFFFFF");
		so.addVariable("path", "${base}/amchart/");
		so.addVariable("settings_file", encodeURIComponent("${base}/jsp/good/ampie_settings.xml"));
		so.addVariable("data_file", encodeURIComponent("${base}/good/getPie/${param.command}.nut"));
		so.write("amcharts_1261672227278");
	</script>
</body>
</html>