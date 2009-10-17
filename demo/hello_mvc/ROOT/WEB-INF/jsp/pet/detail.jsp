<%@include file="/WEB-INF/jsp/head.jsp"%>
<%@include file="sky.jsp"%>
<div id="menu">
	<a href="${base}/pet/all.nut">&lt;&lt;${msg.back_to_list }</a>
</div>
<h2>${msg.edit } : ${obj.name }</h2>
<form action="${base}/pet/update.nut"  name="pet" method="POST">
<input type="hidden" name="id" value="${obj.id}"/>
<input type="hidden" name="masterId" value="${obj.masterId}"/>
<table>
	<tr>
		<td>${msg.pet_name }:</td>
		<td><input name="name" value="${obj.name }" /></td>
	</tr>
	<tr>
		<td>${msg.pet_age }:</td>
		<td><input name="age" value="${obj.age }" /></td>
	</tr>
	<tr>
		<td>${msg.pet_race }:</td>
		<td><input name="race" value="${obj.race }" /></td>
	</tr>
	<tr>
		<td>${msg.pet_color }:</td>
		<td><input name="color" value="${obj.color }" /></td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td><input type="submit" value="${msg.save}"/></td>
	</tr>
</table>
</form>
<%@include file="/WEB-INF/jsp/tail.jsp"%>