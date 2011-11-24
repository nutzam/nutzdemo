<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form id="pagerForm" method="post" action="PreinstallProcess/list">
	<input type="hidden" name="pageNum" value="${obj.pager.pageNumber}" /> 
	<input type="hidden" name="numPerPage" value="${obj.pager.pageSize}" />
	<input type="hidden" name="orderField" value="${param.orderField}" />
	<%-- 工序 --%>
	<input type="hidden" name="name" value="${obj.o.name}"/>
</form>
<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);" action="PreinstallProcess/list" method="post">
		<div class="searchBar">
			<table class="searchContent">
				<tr>
					<td>工序：<input type="text" name="name" value="${obj.o.name}"/></td>
				</tr>
			</table>
			<div class="subBar">
				<ul>
					<li><div class="buttonActive">
							<div class="buttonContent">
								<button type="submit">检索</button>
							</div>
						</div></li>
					<li><a class="button" href="PreinstallProcess/queryUi" target="dialog" mask="true" title="查询框"><span>高级检索</span></a></li>
				</ul>
			</div>
		</div>
	</form>
</div>
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="add" href="PreinstallProcess/addUi" target="navTab" rel="newPage" title="添加预设工序"><span>添加</span></a></li>
			<li><a title="确实要删除这些记录吗?" target="selectedTodo" rel="ids" postType="string" href="PreinstallProcess/delByIds" class="delete"><span>批量删除</span></a></li>
			<li><a class="edit" href="PreinstallProcess/editUi?id={sid_preinstallProcess}" target="navTab" rel="newPage" title="修改预设工序"><span>修改</span></a></li>
			<li class="line">line</li>
			<li><a class="icon" href="#" target="dwzExport" targetType="navTab" title="实要导出这些记录吗?"><span>导出EXCEL</span></a></li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th width="26"><input type="checkbox" group="ids" class="checkboxCtrl"></th>
				<th>工序</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${obj.list}" var="pre">
				<tr target="sid_preinstallProcess" rel="${pre.id }">
				<td><input name="ids" value="'${pre.id}'" type="checkbox"></td>
					<td>${pre.name}</td>
				<td>
				<a title="删除预设工序" target="ajaxTodo" href="PreinstallProcess/delete?id=${pre.id }" class="btnDel">删除预设工序</a>
				<a title="查看预设工序" target="navTab" href="PreinstallProcess/view?id=${pre.id }" class="btnView">查看预设工序</a>
				<a title="编辑预设工序" target="navTab" href="PreinstallProcess/editUi?id=${pre.id }" class="btnEdit">编辑预设工序</a>
				</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="panelBar">
		<div class="pages">
			<span>显示</span> 
			<select class="combox" name="numPerPage" onchange="navTabPageBreak({numPerPage:this.value})">
			<c:forEach begin="10" end="40" step="10" varStatus="s">
				<option value="${s.index}" ${obj.pager.pageSize eq s.index ? 'selected="selected"' : ''}>${s.index}</option>
			</c:forEach>
		</select>
			<span>条，共${obj.pager.recordCount}条</span>
		</div>

		<div class="pagination" targetType="navTab" totalCount="${obj.pager.recordCount}" numPerPage="${obj.pager.pageSize}" pageNumShown="10" currentPage="${obj.pager.pageNumber}"></div>

	</div>
</div>