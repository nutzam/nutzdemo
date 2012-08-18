<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>管理员列表 - Powered By NUTZ</title>
<meta name="Author" content="NUTZ Team" />
<meta name="Copyright" content="NUTZ" />
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
		管理员列表&nbsp;总记录数: ${obj.pager.recordCount} (共${obj.pager.pageCount}页)
	</div>
	<div class="body">
		<form id="listForm" action="list" method="post">
			<div class="listBar">
				<input type="button" class="formButton" onclick="location.href='p_add'" value="添加管理员" hidefocus />
				&nbsp;&nbsp;
				<select name="pager.searchBy">
					<option value="username">用户名</option>
					<option value="name" selected>姓名</option> 
				</select>
				<input type="text" name="pager.keyword" value="admin" />
				<input type="button" id="searchButton" class="formButton" value="搜 索" hidefocus />
				&nbsp;&nbsp;
				<label>每页显示: </label>
				<select name="pager.pageSize" id="pageSize">
					<option value="10" selected>10</option>
					<option value="20">20</option>
					<option value="50">50</option>
					<option value="100">100</option>
				</select>
			</div>
			<table id="listTable" class="listTable">
				<tr>
					<th class="check"><input type="checkbox" class="allCheck" /></th>
					<th>用户名</th>
					<th>E-mail</th>
					<th>姓名</th>
					<th>所属部门</th>
					<th>最后登录时间</th>
					<th>最后登录IP</th>
					<th><span>状态</span></th>
					<th>创建日期</th>
					<th><span>操作</span></th>
				</tr>
				<#list obj.list as admin>
					<tr>
						<td>
							<input type="checkbox" name="ids" value="${admin.id}" />
						</td>
						<td>
							${admin.username}
						</td>
						<td>
							${admin.email}
						</td>
						<td>
							${(admin.name)!}
						</td>
						<td>
							${(admin.department)!}
						</td>
						<td>
							<#if admin.loginDate??>
								<span title="${admin.loginDate?string("yyyy-MM-dd HH:mm:ss")}">${admin.loginDate?string("yyyy-MM-dd HH:mm:ss")}</span>
							<#else>
								&nbsp;
							</#if>
						</td>
						<td>
							${(admin.loginIP)!}
						</td>
						<td>
							<#if admin.accountEnabled && !admin.accountLocked && !admin.accountExpired && !admin.credentialsExpired>
								<span class="green">正常</span>
							<#elseif !admin.accountEnabled>
								<span class="red"> 未启用 </span>
							<#elseif admin.accountLocked>
								<span class="red"> 已锁定 </span>
							<#elseif admin.accountExpired>
								<span class="red"> 已过期 </span>
							<#elseif admin.credentialsExpired>
								<span class="red"> 凭证过期 </span>
							</#if>
						</td>
						<td>
							<span title="${admin.createDate?string("yyyy-MM-dd HH:mm:ss")}">${admin.createDate?string("yyyy-MM-dd")}</span>
						</td>
						<td>
							<a href="p_edit?id=${admin.id}" title="编辑">[编辑]</a>
						</td>
					</tr>
				</#list>
			</table>
			<#if (obj.list?size > 0)>
				<div class="pagerBar">
					<div class="delete">
						<input type="button" id="deleteButton" class="formButton" url="admin/delete" value="删 除" disabled hidefocus />
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