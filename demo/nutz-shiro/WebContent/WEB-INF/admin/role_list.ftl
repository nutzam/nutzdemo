<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>角色列表 - Powered By SHOP++</title>
<meta name="Author" content="SHOP++ Team" />
<meta name="Copyright" content="SHOP++" />
<link rel="icon" href="favicon.ico" type="image/x-icon" />
<link href="${base}/template/admin/css/base.css" rel="stylesheet" type="text/css" />
<link href="${base}/template/admin/css/admin.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${base}/js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="${base}/template/common/js/jquery.pager.js"></script>
<script type="text/javascript" src="${base}/template/admin/js/base.js"></script>
<script type="text/javascript" src="${base}/template/admin/js/admin.js"></script>
</head>
<body class="list">
	<div class="bar">
		角色管理&nbsp;总记录数: ${obj.pager.totalCount} (共${obj.pager.pageCount}页)
	</div>
	<div class="body">
		<form id="listForm" action="/list" method="post">
			<div class="listBar">
				<input type="button" class="formButton" onclick="location.href='p_add'" value="添加角色" hidefocus />
				&nbsp;&nbsp;
				<label>查找: </label>
				<select name="pager.searchBy">
					<option value="name" selected>
						角色名称
					</option>
				</select>
				<input type="text" name="pager.keyword" value="admin" />
				<input type="button" id="searchButton" class="formButton" value="搜 索" hidefocus />
				&nbsp;&nbsp;
				<label>每页显示: </label>
				<select name="pager.pageSize" id="pageSize">
					<option value="10" selected>10</option>
					<option>20</option>
					<option value="50">50</option>
					<option value="100">100</option>
				</select>
			</div>
			<table id="listTable" class="listTable">
				<tr>
					<th class="check"><input type="checkbox" class="allCheck" /></th>
					<th>角色名称</th>
					<th>系统内置</th>
					<th>描述</th>
					<th><span>操作</span></th>
				</tr>
				<#list obj.list as role>
					<tr>
						<td><input type="checkbox"<#if role.system> disabled title="系统内置权限不允许删除!"<#else> name="ids" value="${role.id}"</#if> /></td>
						<td>${role.name}</td>
						<td><span class="${role.system?string('true','false')}Icon">&nbsp;</span></td>
						<td>${role.description}</td>
						<td><a href="view?id=${role.id}" title="编辑">[编辑]</a></td>
					</tr>
				</#list>
			</table>
			<#if (obj.list?size > 0)>
				<div class="pagerBar">
					<div class="delete">
						<input type="button" id="deleteButton" class="formButton" url="delete" value="删 除" disabled hidefocus />
					</div>
					<div class="pager">
						<#include "admin/pager.ftl" />
					</div>
				<div>
			<#else>
				<div class="noRecord">没有找到任何记录!</div>
			</#if>
		</form>
	</div>
</body>
</html>