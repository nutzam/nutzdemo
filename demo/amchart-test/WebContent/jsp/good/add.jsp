<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加商品</title>
</head>
<body>
	<form action="${base }/good/add.nut">
		商品名:<input type="text" name="name">
		<br/>
		详细:<textarea rows="4" cols="40" name="detailed"></textarea>
		<input type="submit" value="提交">
	</form>
</body>
</html>