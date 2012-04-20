<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	if(request.getParameter("name") != null){
		if(request.getParameter("name").equals("admin") && request.getParameter("password").equals("password")){
			request.getSession(false).setAttribute("name","admin");
			response.sendRedirect("./index.jsp");
		}
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>易耗品管理 登录</title>
</head>
<body>
<table width="100%" border="0" cellspacing="0" cellpadding="4">

	<tr> 

		<td bgcolor="#000099"> 

			<table width="100%" border="0" cellspacing="0" cellpadding="4">

				<tr> 

					<td bgcolor="#FFFFFF">&nbsp;<b>*</b>&nbsp;</td>

						<td width="100%"><font color="#CCCCCC">&nbsp; <font color="#FFFFFF">请登录</font></font></td>

				</tr>

			</table></td>

	</tr>

	<tr> 

		<td width="100%" bgcolor="#EAEAEA" colspan="2"> 

			<form name="login" method="post" action="login.jsp"><p>

				<label for="textfield">用户名</label>

				<br>

				<input type="text" name="name" id="name">

				</p>

				<p>

				<label for="textfield2">密码</label>

				<br>

				<input type="password" name="password" id="password">

				</p>

				<p> 

				<input type="submit" name="Submit" value="提交">

				</p>

				<p>&nbsp; </p>

				</form>

		</td>

  </tr>

</table>
</body>
</html>