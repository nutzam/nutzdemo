<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>上传商品图片</title>
</head>
<body>
	<form action="${base }/good/uploadImg.nut" enctype="MULTIPART/FORM-DATA" method="post">
		<input type="hidden" name="id" value="${obj.id }">
		<input type="file" name="img">
		<input type="submit" value="提交">
	</form>
</body>
</html>