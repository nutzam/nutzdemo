<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>分配权限</title>  
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<%@include file="/common/common.jsp"%>
	<script type="text/javascript">
	$(document).ready(function(){
		<c:if test="${role eq null}">
			alert("角色不存在不能分配权限");
			history.go(-1);
		</c:if>
		<c:if test="${role.permission ne null}">
			<c:forEach var="p" items="${role.permission}">
				<c:if test="${fht:hasPermission(1,p.acl)}">
					document.getElementById("C_${p.resource}").checked=true;
				</c:if>
				<c:if test="${fht:hasPermission(2,p.acl)}">
					document.getElementById("R_${p.resource}").checked=true;
				</c:if>
				<c:if test="${fht:hasPermission(4,p.acl)}">
					document.getElementById("U_${p.resource}").checked=true;
				</c:if>
				<c:if test="${fht:hasPermission(8,p.acl)}">
					document.getElementById("D_${p.resource}").checked=true;
				</c:if>
			</c:forEach>
		</c:if>
	});
		function setPermission(resource,o){
			var action = 0;
			if(o.checked){
				action = o.value;
			}else{
				action -= o.value;
			}
			
			var url = '${ctx}/admin/permission/set';
			
			$.post(url,{resource:resource,role:${role.id},acl:action},function(data){
				var o = eval("("+data+")");
				if(!o.success){
					alert("分配权限失败！");
				}
			},'json');
			
		}
	</script>    
  </head>
  <body style="background: none;">
    <table width="100%">
    	<thead >
    		<tr>
    			<th colspan="5" style="text-align: center;">正在为【${role.name}】分配权限</th>
    		</tr>
    		<tr>
    			<th>模块名称</th>
    			<th>创建操作</th>
    			<th>读取操作</th>
    			<th>写入操作</th>
    			<th>更新操作</th>
    		</tr>
    	</thead>
    	<tbody>
    		<tr style="background-color: silver;">
    			<td colspan="1">内容管理</td>
    			<td></td>
    			<td><input type="checkbox" onclick="setPermission(1,this)" value="2"  id="R_1"/></td>
    			<td colspan="2">
    		</tr>
    		<tr>
    			<td colspan="1">文章管理</td>
    			<td><input type="checkbox"  value="1" onclick="setPermission(2,this)" id="C_2"/></td>
    			<td><input type="checkbox"  value="2" onclick="setPermission(2,this)" id="R_2"/></td>
    			<td><input type="checkbox"  value="4" onclick="setPermission(2,this)" id="U_2"/></td>
    			<td><input type="checkbox"  value="8" onclick="setPermission(2,this)" id="D_2"/></td>
    		</tr>
    		<tr>
    			<td colspan="1">单页管理</td>
    			<td><input type="checkbox" value="1" onclick="setPermission(3,this)"  id="C_3"/></td>
    			<td><input type="checkbox" value="2" onclick="setPermission(3,this)"  id="R_3"/></td>
    			<td><input type="checkbox" value="4" onclick="setPermission(3,this)"  id="U_3"/></td>
    			<td><input type="checkbox" value="8" onclick="setPermission(3,this)"  id="D_3"/></td>
    		</tr>
    		<tr>
    			<td colspan="1">资料下载</td>
    			<td><input type="checkbox" value="1" onclick="setPermission(4,this)"  id="C_4"/></td>
    			<td><input type="checkbox" value="2" onclick="setPermission(4,this)"  id="R_4"/></td>
    			<td><input type="checkbox" value="4" onclick="setPermission(4,this)"  id="U_4"/></td>
    			<td><input type="checkbox" value="8" onclick="setPermission(4,this)"  id="D_4"/></td>
    		</tr>
    		<tr>
    			<td colspan="1">友情链接</td>
    			<td><input type="checkbox" value="1" onclick="setPermission(19,this)"  id="C_19"/></td>
    			<td><input type="checkbox" value="2" onclick="setPermission(19,this)"  id="R_19"/></td>
    			<td><input type="checkbox" value="4" onclick="setPermission(19,this)"  id="U_19"/></td>
    			<td><input type="checkbox" value="8" onclick="setPermission(19,this)"  id="D_19"/></td>
    		</tr>
    		<!-- 第二模块开始 -->
    		<tr style="background-color: silver;">
    			<td colspan="1">网站管理</td>
    			<td></td>
    			<td><input type="checkbox" value="2" onclick="setPermission(5,this)"  id="R_5"/></td>
    			<td colspan="2">
    		</tr>
    		<tr>
    			<td colspan="1">导航设置</td>
    			<td><input type="checkbox" value="1" onclick="setPermission(6,this)"  id="C_6"/></td>
    			<td><input type="checkbox" value="2" onclick="setPermission(6,this)"  id="R_6"/></td>
    			<td><input type="checkbox" value="4" onclick="setPermission(6,this)"  id="U_6"/></td>
    			<td><input type="checkbox" value="8" onclick="setPermission(6,this)"  id="D_6"/></td>
    		</tr>
    		<tr>
    			<td colspan="1">模板管理</td>
    			<td><input type="checkbox" value="1" onclick="setPermission(7,this)"  id="C_7"/></td>
    			<td><input type="checkbox" value="2" onclick="setPermission(7,this)"  id="R_7"/></td>
    			<td><input type="checkbox" value="4" onclick="setPermission(7,this)"  id="U_7"/></td>
    			<td><input type="checkbox" value="8" onclick="setPermission(7,this)"  id="D_7"/></td>
    		</tr>
    		<tr>
    			<td colspan="1">首页图片</td>
    			<td><input type="checkbox" value="1" onclick="setPermission(8,this)"  id="C_8"/></td>
    			<td><input type="checkbox" value="2" onclick="setPermission(8,this)"  id="R_8"/></td>
    			<td><input type="checkbox" value="4" onclick="setPermission(8,this)"  id="U_8"/></td>
    			<td><input type="checkbox" value="8" onclick="setPermission(8,this)"  id="D_8"/></td>
    		</tr>
    		<!-- 第三模块开始 -->
    		<tr style="background-color: silver;">
    			<td colspan="1">留言及其他管理</td>
    			<td></td>
    			<td><input type="checkbox" value="2" onclick="setPermission(9,this)"  id="R_9"/></td>
    			<td colspan="2">
    		</tr>
    		<tr>
    			<td colspan="1">留言管理</td>
    			<td><input type="checkbox" value="1" onclick="setPermission(10,this)"  id="C_10"/></td>
    			<td><input type="checkbox" value="2" onclick="setPermission(10,this)"  id="R_10"/></td>
    			<td><input type="checkbox" value="4" onclick="setPermission(10,this)"  id="U_10"/></td>
    			<td><input type="checkbox" value="8" onclick="setPermission(10,this)"  id="D_10"/></td>
    		</tr>
    		<tr>
    			<td colspan="1">联系我们</td>
    			<td><input type="checkbox" value="1" onclick="setPermission(11,this)"  id="C_11"/></td>
    			<td><input type="checkbox" value="2" onclick="setPermission(11,this)"  id="R_11"/></td>
    			<td><input type="checkbox" value="4" onclick="setPermission(11,this)"  id="U_11"/></td>
    			<td><input type="checkbox" value="8" onclick="setPermission(11,this)"  id="D_11"/></td>
    		</tr>
    		<tr>
    			<td colspan="1">学术小组</td>
    			<td><input type="checkbox" value="1" onclick="setPermission(12,this)"  id="C_12"/></td>
    			<td><input type="checkbox" value="2" onclick="setPermission(12,this)"  id="R_12"/></td>
    			<td><input type="checkbox" value="4" onclick="setPermission(12,this)"  id="U_12"/></td>
    			<td><input type="checkbox" value="8" onclick="setPermission(12,this)"  id="D_12"/></td>
    		</tr>
    		<!-- 第四模块 -->
    		<tr style="background-color: silver;">
    			<td colspan="1">我的资料</td>
    			<td></td>
    			<td><input type="checkbox" value="2" onclick="setPermission(13,this)"  id="R_13"/></td>
    			<td colspan="2">
    		</tr>
    		<tr>
    			<td colspan="1">修改密码</td>
    			<td><input type="checkbox" value="1" onclick="setPermission(14,this)"  id="C_14"/></td>
    			<td><input type="checkbox" value="2" onclick="setPermission(14,this)"  id="R_14"/></td>
    			<td><input type="checkbox" value="4" onclick="setPermission(14,this)"  id="U_14"/></td>
    			<td><input type="checkbox" value="8" onclick="setPermission(14,this)"  id="D_14"/></td>
    		</tr>
    		<!-- 第五模块 -->
    		<tr style="background-color: silver;">
    			<td colspan="1">系统设置</td>
    			<td></td>
    			<td><input type="checkbox" value="2" onclick="setPermission(15,this)"  id="R_15"/></td>
    			<td colspan="2">
    		</tr>
    		<tr>
    			<td colspan="1">网站信息</td>
    			<td><input type="checkbox" value="1" onclick="setPermission(16,this)"  id="C_16"/></td>
    			<td><input type="checkbox" value="2" onclick="setPermission(16,this)"  id="R_16"/></td>
    			<td><input type="checkbox" value="4" onclick="setPermission(16,this)"  id="U_16"/></td>
    			<td><input type="checkbox" value="8" onclick="setPermission(16,this)"  id="D_16"/></td>
    		</tr>
    		<tr>
    			<td colspan="1">角色管理</td>
    			<td><input type="checkbox" value="1" onclick="setPermission(17,this)"  id="C_17"/></td>
    			<td><input type="checkbox" value="2" onclick="setPermission(17,this)"  id="R_17"/></td>
    			<td><input type="checkbox" value="4" onclick="setPermission(17,this)"  id="U_17"/></td>
    			<td><input type="checkbox" value="8" onclick="setPermission(17,this)"  id="D_17"/></td>
    		</tr>
    		<tr>
    			<td colspan="1">人员管理</td>
    			<td><input type="checkbox" value="1" onclick="setPermission(18,this)"  id="C_18"/></td>
    			<td><input type="checkbox" value="2" onclick="setPermission(18,this)"  id="R_18"/></td>
    			<td><input type="checkbox" value="4" onclick="setPermission(18,this)"  id="U_18"/></td>
    			<td><input type="checkbox" value="8" onclick="setPermission(18,this)"  id="D_18"/></td>
    		</tr>
    	</tbody>
    </table>
  </body>
</html>
