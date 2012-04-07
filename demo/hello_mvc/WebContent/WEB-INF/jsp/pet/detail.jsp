<%@include file="/WEB-INF/jsp/head.jsp"%>
<%@include file="sky.jsp"%>
<div id="menu">
	<a href="${base}/pet/all.nut">${msg.pets_title }</a>
	&gt; <b>${obj.name}</b>
</div>
<!--
====================================================================== 
-->
<form id="photo" action="${base}/pet/uploadphoto.nut" method="POST"
	enctype="multipart/form-data" target="photoTag">
	<c:choose>
		<c:when test="${obj.photoPath==null}">
			 <h2>${fn:replace(msg.pet_upload_title,'%s',obj.name)}</h2>
		</c:when>
		<c:otherwise>
			<div id="photoWrapper">
				<img src="${base}${obj.photoPath}"
				width="200"/>
			</div>
		</c:otherwise>
	</c:choose>
	<input type="hidden" name="id" value="${obj.id }"/>
	<input type="file" name="photo"/>
	<input type="submit" value="${msg.upload }"/>
</form>
<iframe name="photoTag" style="display:none"></iframe>
<!--
====================================================================== 
-->
<form action="${base}/pet/update.nut"  name="pet" method="POST" class="detail">
<input type="hidden" name="id" value="${obj.id}"/>
<input type="hidden" name="masterId" value="${obj.masterId}"/>
<table border="0">
	<tr>
		<td nowrap>${msg.pet_name }:</td>
		<td><input name="name" value="${obj.name }" /></td>
	</tr>
	<tr>
		<td nowrap>${msg.pet_age }:</td>
		<td><input name="age" value="${obj.age }" /></td>
	</tr>
	<tr>
		<td nowrap>${msg.pet_race }:</td>
		<td><input name="race" value="${obj.race }" /></td>
	</tr>
	<tr>
		<td nowrap>${msg.pet_color }:</td>
		<td><input name="color" value="${obj.color }" /></td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td><input type="submit" value="${msg.save}"/></td>
	</tr>
</table>
</form>
<%@include file="/WEB-INF/jsp/tail.jsp"%>