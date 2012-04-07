<%@include file="/WEB-INF/jsp/head.jsp"%>
<h1>${msg.title}</h1>
<br><br>
<form action="${base}/pet/login.nut" method="POST">
<table border="0" align="center" cellspacing="4" cellpadding="4">
	<tr>
		<td>${msg.login_name}:</td>
		<td><input name="name"></td>
	</tr>
	<tr>
		<td>${msg.login_password}:</td>
		<td><input name="pwd"></td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td><input type="submit" value="&nbsp;&nbsp;${msg.login_submit}&nbsp;&nbsp;" /></td>
	</tr>
</table>
</form>
<%@include file="/WEB-INF/jsp/tail.jsp"%>