<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="/WEB-INF/tld/c.tld"%>
<%@ taglib prefix="fn" uri="/WEB-INF/tld/fn.tld"%>
<html>
<head>
<title>Hello world</title>
<script language="Javascript" src="${base}/js/jquery-1.3.2.js"></script>
<script language="Javascript" src="${base}/js/nutz.js"></script>
<script language="Javascript">
	function setParam(str) {
		$("#params").text(str);
	}

	function initParams() {
		var urls = $("#urls")[0];
		switch (urls.value) {
		case '/say':
		case '/time':
		case '/map':
		case '/tls':
		case '/lots':
		case '/path/14':
		case '/path/789':
			setParam("");
			break;
		case '/yousay':
		case '/params':
		case '/path2/23':
		case '/path2/879/text':
			setParam("word=My Word");
			break;
		case '/msg':
			setParam("key=title");
			break;
		}
	}

	function doDemo() {
		var theUrl = "${base}" + $("#urls")[0].value + ".nut?" + $("#params")[0].value;
		$.ajax( {
			type : "GET",
			url : theUrl,
			//data : data,
			dataType : "json",
			processData : true,
			success : function(obj) {
				$("#resp").text(nutz.json(obj));
			}
		});
	}
</script>
</head>
<body>
&gt;&gt; <a target="_blank" href="${base}/auto/jump.nut">try auto jump</a>
<br>
<select id="urls" onchange="initParams()">
	<option>-- Choose One URL --</option>
	<option value="/say">/say</option>
	<option value="/time">/time</option>
	<option value="/map">/map</option>
	<option value="/tls">/tls</option>
	<option value="/lots">/lots</option>
	<option value="/path/14">/path/14</option>
	<option value="/path/789">/path/789</option>
	<option value="/yousay">/yousay</option>
	<option value="/params">/params</option>
	<option value="/path2/23">/path2/23</option>
	<option value="/path2/879/text">/path2/879/text</option>
	<option value="/msg">/msg</option>
</select>
<input type="button" onclick="doDemo();" value="Do Demo" />
<hr />
<b>Params:</b>
<br>
<textarea id="params" style="width: 500px; height: 200px;"></textarea>
<hr>
<b>Response:</b>
<br>
<textarea id="resp" style="width: 500px; height: 200px;"></textarea>
</body>
</html>