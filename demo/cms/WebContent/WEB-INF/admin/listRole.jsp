<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>分配角色</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<%@include file="/common/common.jsp"%>
	<script type="text/javascript">
		$(document).ready(function(){
			<c:if test="${sessionScope.admin eq null}">
				alert("你还没有登录..");
				window.location='${ctx}/admin';
			</c:if>
			<c:if test="${m.roles ne null}">
				<c:forEach var='role' items='${m.roles}'>
					document.getElementById("c_${role.id}").checked=true;
				</c:forEach>
			</c:if>
		});
		
		function setRole(o){
			var id = o.value;
			var u = ${m.id};
			var action = o.checked;
			
			var url='${ctx}/admin/user/role';
			$.post(url,{id:u,role:id,action:action},function(data){
				var o = eval("("+data+")");
				if(!o.success){
					alert("分配角色失败");
				}
			},'json');
		}
		
	</script>    
  </head>
  
  <body style="background: none;">
 	<table width="100%">
 		<thead>
 			<tr>
 				<th colspan="2" style="text-align: center;">正在为【${m.username}】分配角色</th>
 			</tr>
 			<tr>
 				<th>角色名称</th>
 				<td>操作</td>
 			</tr>
 		</thead>
 		<tbody>
 			<c:forEach var="role" items="${roles}">
 				<tr>
 					<td>${role.name}</td>
 					<td><input type="checkbox" value="${role.id}" onclick="setRole(this)" id="c_${role.id}"/></td>
 				</tr>
 			</c:forEach>
 		</tbody>
 	</table>
  </body>
</html>
