<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页</title>
<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
<script type="text/javascript">
	$( function(){
			$('#addMoreFile').click(function() {
				$(this).before('<input name="file" type="file"></input><p/>');
			});
		});
</script>
</head>
<body>
	<div id="result"></div>
	<div>
		<p>1. 单文件表单上传</p>
		<div>
			<form action="f/upload.nut" method="post" enctype="multipart/form-data">
				<input name="file" type="file"></input>
				<input type="submit" value="提交"/>
			</form>
		</div>
	</div>
	<div>
		<p><b>2. 多文件上传</b>
		<div>
			<form action="f/upload_mu.nut" method="post" enctype="multipart/form-data">
				<input type="submit" value="提交"/><p/>
				<input name="file" type="file"></input><p/>
				<a id="addMoreFile" href="#">再加文件</a>
			</form>
		</div>
	</div>
	<div>
		<p><b>3. Flash文件上传</b></p>
		<!-- 控件来自 http://manyinjin.javaeye.com/blog/182736 -->
		<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000"
			id="upload_swf" width="650" height="220"
			codebase="http://fpdownload.macromedia.com/get/flashplayer/current/swflash.cab">
			<param name="movie" value="swf/FileUpload.swf" />
			<param name="quality" value="high" />
			<param name="bgcolor" value="#76b900" />
			<param name="allowScriptAccess" value="sameDomain" />
			<param name="FlashVars" value='sessionId=<%=session==null?"":session.getId()%>&uploadPath=../f/upload_flash.nut&fileFilter=[{"name":"Zip", "postFix": "*.zip"},{"name":"Rar", "postFix": "*.rar"}]'/>
			<embed src="swf/FileUpload.swf" quality="high" bgcolor="#76b900"
				width="650" height="220" name="upload_swf" align="middle"
				play="true"
				loop="false"
				quality="high"
				allowScriptAccess="sameDomain"
				type="application/x-shockwave-flash"
				pluginspage="http://www.adobe.com/go/getflashplayer"
				FlashVars='sessionId=<%=session==null ? "" : session.getId()%>&uploadPath=../f/upload_flash.nut&fileFilter=[{"name":"Zip", "postFix": "*.zip"},{"name":"Rar", "postFix": "*.rar"}]'>
			</embed>
		</object>
		
	</div>
	<div></div>
	<div></div>
	<div></div>
</body>
</html>