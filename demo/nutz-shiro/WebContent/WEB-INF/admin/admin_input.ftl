<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>添加/编辑管理员 - Powered By SHOP++</title>
<meta name="Author" content="SHOP++ Team" />
<meta name="Copyright" content="SHOP++" />
<link rel="icon" href="favicon.ico" type="image/x-icon" />
<link href="${base}/template/admin/css/base.css" rel="stylesheet" type="text/css" />
<link href="${base}/template/admin/css/admin.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${base}/js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="${base}/template/common/js/jquery.tools.js"></script>
<script type="text/javascript" src="${base}/template/common/js/jquery.validate.js"></script>
<script type="text/javascript" src="${base}/template/common/js/jquery.validate.methods.js"></script>
<script type="text/javascript" src="${base}/template/admin/js/base.js"></script>
<script type="text/javascript" src="${base}/template/admin/js/admin.js"></script>
<script type="text/javascript">
$().ready( function() {
	var $validateErrorContainer = $("#validateErrorContainer");
	var $validateErrorLabelContainer = $("#validateErrorContainer ul");
	var $validateForm = $("#validateForm");
	var $tab = $("#tab");
	// Tab效果
	$tab.tabs(".tabContent", {
		tabs: "input"
	});
	// 表单验证
	$validateForm.validate({
		errorContainer: $validateErrorContainer,
		errorLabelContainer: $validateErrorLabelContainer,
		wrapper: "li",
		errorClass: "validateError",
		ignoreTitle: true,
		rules: {
			<#if isAddAction>
				"user.username": {
					required: true,
					username: true,
					minlength: 2,
					maxlength: 	 20,
					remote: "checkUsername"
				},
			</#if>
			"admin.password": {
				<#if isAddAction>
					required: true,
				</#if>
				minlength: 4,
				maxlength: 	 20
			},
			"rePassword": {
				<#if isAddAction>
					required: true,
				</#if>
				equalTo: "#password"
			},
			"user.email": {
				required: true,
				email: true
			},
			"roleList.id": "required"
		},
		messages: {
			<#if isAddAction>
				"user.username": {
					required: "请填写用户名",
					username: "用户名只允许包含中文、英文、数字和下划线",
					minlength: "用户名必须大于等于2",
					maxlength: 	 "用户名必须小于等于20",
					remote: "用户名已存在"
				},
			</#if>
			"user.password": {
				<#if isAddAction>
					required: "请填写密码",
				</#if>
				minlength: "密码必须大于等于4",
				maxlength: 	 "密码必须小于等于20"
			},
			"rePassword": {
				<#if isAddAction>
					required: "请填写重复密码",
				</#if>
				equalTo: "两次密码输入不一致"
			},
			"user.email": {
				required: "请填写E-mail",
				email: "E-mail格式不正确"
			},
			"roleIDs": "请选择管理角色"
		},
		submitHandler: function(form) {
			$(form).find(":submit").attr("disabled", true);
			form.submit();
		}
	});

});
</script>
</head>
<body class="input admin">
	<div class="bar">
		<#if isAddAction>添加管理员<#else>编辑管理员</#if>
	</div>
	<div id="validateErrorContainer" class="validateErrorContainer">
		<div class="validateErrorTitle">以下信息填写有误,请重新填写</div>
		<ul></ul>
	</div>
	<div class="body">
		<form id="validateForm" action="<#if isAddAction>save<#else>update</#if>" method="post">
		<#if isEditAction>
			<input type="hidden" name="id" value="${obj.id!}" />
		</#if>
			<ul id="tab" class="tab">
				<li>
					<input type="button" value="基本信息" hidefocus />
				</li>
				<li>
					<input type="button" value="个人资料" hidefocus />
				</li>
			</ul>
			<table class="inputTable tabContent">
				<tr>
					<th>
						用户名: 
					</th>
					<td>
						<#if isAddAction>
							<input type="text" name="user.username" class="formText" title="用户名只允许包含中文、英文、数字和下划线" value=""/>
							<label class="requireField">*</label>
						<#else>
							${(obj.username)!}
							<input type="hidden" name="user.username" class="formText" value="${(obj.username)!}" />
						</#if>
					</td>
				</tr>
				<tr>
					<th>
						密 码: 
					</th>
					<td>
						<input type="password" name="user.password" id="password" class="formText" title="密码长度只允许在4-20之间" value=""/>
						<#if isAddAction><label class="requireField">*</label></#if>
					</td>
				</tr>
				<tr>
					<th>
						重复密码: 
					</th>
					<td>
						<input type="password" name="rePassword" class="formText" value=" "/>
						<#if isAddAction><label class="requireField">*</label></#if>
					</td>
				</tr>
				<tr>
					<th>
						E-mail: 
					</th>
					<td>
					<#if isEditAction>
						<input type="text" name="user.email" class="formText" value="${(obj.email)!}" />
						<#else>
						<input type="text" name="user.email" class="formText" value="" />
						</#if>
						<label class="requireField">*</label>
					</td>
				</tr>
				<tr class="roleList">
					<th>
						管理角色: 
					</th>
					<td>
					<#if isEditAction>
						<#list allRoleList as role>
							<label>
								<input type="checkbox" name="roleIDs" value="${role.id}"
								<#list obj.roles as aRole>
								<#if aRole.id==role.id> checked <#break></#if>
								</#list>
								 />${role.name}
							</label>
						</#list>
						<#else>
						<#list allRoleList as role>
							<label>
								<input type="checkbox" name="roleIDs" value="${role.id}"/>${role.name}
							</label>
						</#list>
						</#if>
						<label class="requireField">*</label>
					</td>
				</tr>
				<tr>
					<th>
						设置: 
					</th>
					<td>
						<label>
							<label>
							<input type="checkbox" checked="checked" id="admin_isAccountEnabled" value="true" name="user.accountEnabled"><input type="hidden" value="true" name="__checkbox_user.accountEnabled" id="__checkbox_user_accountEnabled">启用
						</label>
						</label>
					</td>
				</tr>
				<#if isEditAction>
					<tr>
						<th>&nbsp;</th>
						<td>
							<span class="warnInfo"><span class="icon">&nbsp;</span>如果要修改密码,请填写密码,若留空,密码将保持不变!</span>
						</td>
					</tr>
				</#if>
			</table>
			<table class="inputTable tabContent">
				<tr>
					<th>
						部门: 
					</th>
					<td>
					<#if isEditAction>
						<input type="text" name="user.department" class="formText" value="${(obj.department)!}" />
						<#else>
						<input type="text" name="user.department" class="formText" value="" />
						</#if>
					</td>
				</tr>
				<tr>
					<th>
						姓名: 
					</th>
					<td><#if isEditAction>
						<input type="text" name="user.name" class="formText" value="${(obj.name)!}" />
						<#else>
						<input type="text" name="user.name" class="formText" value="" />
						</#if>
					</td>
				</tr>
			</table>
			<div class="buttonArea">
				<input type="submit" class="formButton" value="确  定" hidefocus />&nbsp;&nbsp;
				<input type="button" class="formButton" onclick="window.history.back(); return false;" value="返  回" hidefocus />
			</div>
		</form>
	</div>
</body>
</html>