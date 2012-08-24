<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>文章列表 - Powered By SHOP++</title>
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
		文章列表&nbsp;总记录数: ${obj.pager.totalCount} (共${obj.pager.pageCount}页)
	</div>
	<div class="body">
		<form id="listForm" action="article!list.action" method="post">
			<div class="listBar">
				<input type="button" class="formButton" onclick="location.href='p_add'" value="添加文章" hidefocus />
				&nbsp;&nbsp;
				<label>查找: </label>
				<select name="pager.searchBy">
					<option value="title" selected>
						标题
					</option>
				</select>
				<input type="text" name="pager.keyword" value="admin" />
				<input type="button" id="searchButton" class="formButton" value="搜 索" hidefocus />
				&nbsp;&nbsp;
				<label>每页显示: </label>
				<select name="pager.pageSize" id="pageSize">
					<option value="10" >
						10
					</option>
					<option value="20" selected >
						20
					</option>
					<option value="50" >
						50
					</option>
					<option value="100" >
						100
					</option>
				</select>
			</div>
			<table id="listTable" class="listTable">
				<tr>
					<th class="check">
						<input type="checkbox" class="allCheck" />
					</th>
					<th>标题</th>
					<th>分类</th>
					<th>是否发布</th>
					<th>是否推荐</th>
					<th>添加时间</th>
					<th><span>操作</span></th>
				</tr>
				<#list obj.list as article>
					<tr>
						<td>
							<input type="checkbox" name="ids" value="${article.id}" />
						</td>
						<td>
							<span title="${article.title}">
								${article.title}
							</span>
						</td>
						<td>
							${article.articleCategory.name}
						</td>
						<td>
							<span class="${article.publication?string('true','false')}Icon">&nbsp;</span>
						</td>
						<td>
							<span class="${article.recommend?string('true','false')}Icon">&nbsp;</span>
						</td>
						<td>
							<span title="${article.createDate?string("yyyy-MM-dd HH:mm:ss")}">${article.createDate?string("yyyy-MM-dd HH:mm:ss")}</span>
						</td>
						<td>
							<a href="edit?id=${article.id}" title="编辑">[编辑]</a>
							<#if article.publication>
								<a href="${base}{article.htmlPath}" target="_blank" title="浏览">[浏览]</a>
							<#else>
								<span title="未发布">[未发布]</span>
							</#if>
						</td>
					</tr>
				</#list>
			</table>
			<#if (obj.list?size > 0)>
				<div class="pagerBar">
					<div class="delete">
						<input type="button" id="deleteButton" class="formButton" url="article!delete.action" value="删 除" disabled hidefocus />
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