<%@include file="/WEB-INF/jsp/head.jsp"%>
<%@include file="sky.jsp"%>
<!--
====================================================================== 
-->
<div id="menu">
	<button onclick="document.getElementById('new_pet').style.display = 'inline';">
		${msg.pet_new_button}
	</button>
	<form id="new_pet" action="${base}/pet/add.nut" method="POST" style="display: none">
		${msg.pet_name}: <input name="nm" />
		<input type="submit" value="${msg.save} >>">
	</form>
</div>
<!--
====================================================================== 
-->
<table cellspacing="2" cellpadding="4" border="0" id="pets">
<c:forEach var="pet" items="${obj}">
	<tr>
		<td><li>&nbsp;</li></td>
		<td><a href="${base}/pet/detail.nut?id=${pet.id}">${pet.name}</a></td>
		<td><i>(${pet.age} ${msg.age} / ${pet.color} / ${pet.race})</i></td>
		<td>&nbsp;</td>
		<td> &gt;<a href="${base}/pet/remove.nut?id=${pet.id}">${msg.remove}</a></td>
	</tr>
</c:forEach>
</table>
<%@include file="/WEB-INF/jsp/tail.jsp"%>