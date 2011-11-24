<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form id="pagerForm" method="post" action="Product/list">
	<input type="hidden" name="pageNum" value="${obj.pager.pageNumber}" /> 
	<input type="hidden" name="numPerPage" value="${obj.pager.pageSize}" />
	<input type="hidden" name="orderField" value="${param.orderField}" />
	<%-- 编号 --%>
	<input type="hidden" name="code" value="${obj.o.code}"/>
	<%-- 名称 --%>
	<input type="hidden" name="name" value="${obj.o.name}"/>
	<%-- 规格 --%>
	<input type="hidden" name="specification" value="${obj.o.specification}"/>
	<%-- 单位 --%>
	<input type="hidden" name="unit" value="${obj.o.unit}"/>
	<%-- 组织机构 --%>
	<input type="hidden" name="organization" value="${obj.o.organization}"/>
	<%-- 创建人 --%>
<%--<input type="hidden" name="createUser" value="${obj.o.createUser}/> --%>
	<%-- 创建时间 --%>
<%--<input type="hidden" name="createDate" value="${obj.o.createDate}/> --%>
	<%-- 修改人 --%>
<%--<input type="hidden" name="modifyUser" value="${obj.o.modifyUser}/> --%>
	<%-- 修改时间 --%>
<%--<input type="hidden" name="modifyDate" value="${obj.o.modifyDate}/> --%>
</form>
<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);" action="Product/list" method="post">
		<div class="searchBar">
			<table class="searchContent">
				<tr>
					<td>编号：<input type="text" name="code" value="${obj.o.code}"/></td>
					<td>名称：<input type="text" name="name" value="${obj.o.name}"/></td>
					<td>规格：<input type="text" name="specification" value="${obj.o.specification}"/></td>
<%-- 			    	<td>单位：<input type="text" name="unit" value="${obj.o.unit}/></td> --%>			        
<%-- 			    	<td>组织机构：<input type="text" name="organization" value="${obj.o.organization}/></td> --%>			        
<%-- 			    	<td>创建人：<input type="text" name="createUser" value="${obj.o.createUser}/></td> --%>			        
<%-- 			    	<td>创建时间：<input type="text" name="createDate" value="${obj.o.createDate}/></td> --%>			        
<%-- 			    	<td>修改人：<input type="text" name="modifyUser" value="${obj.o.modifyUser}/></td> --%>			        
<%-- 			    	<td>修改时间：<input type="text" name="modifyDate" value="${obj.o.modifyDate}/></td> --%>			        
				</tr>
			</table>
			<div class="subBar">
				<ul>
					<li><div class="buttonActive">
							<div class="buttonContent">
								<button type="submit">检索</button>
							</div>
						</div></li>
					<li><a class="button" href="Product/queryUi" target="dialog" mask="true" title="查询框"><span>高级检索</span></a></li>
				</ul>
			</div>
		</div>
	</form>
</div>
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="add" href="Product/addUi" target="navTab" rel="newPage" title="添加产品设置"><span>添加</span></a></li>
			<li><a title="确实要删除这些记录吗?" target="selectedTodo" rel="ids" postType="string" href="Product/delByIds" class="delete"><span>批量删除</span></a></li>
			<li><a class="edit" href="Product/editUi?id={sid_product}" target="navTab" rel="newPage" title="修改产品设置"><span>修改</span></a></li>
			<li class="line">line</li>
			<li><a class="icon" href="#" target="dwzExport" targetType="navTab" title="实要导出这些记录吗?"><span>导出EXCEL</span></a></li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th width="26"><input type="checkbox" group="ids" class="checkboxCtrl"></th>
				<th>编号</th>
				<th>名称</th>
				<th>规格</th>
				<th>单位</th>
				<th>组织机构</th>
				<th>创建人</th>
				<th>创建时间</th>
				<th>修改人</th>
				<th>修改时间</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${obj.list}" var="pro">
				<tr target="sid_product" rel="${pro.id }">
				<td><input name="ids" value="'${pro.id}'" type="checkbox"></td>
					<td>${pro.code}</td>
					<td>${pro.name}</td>
					<td>${pro.specification}</td>
					<td>${pro.unit}</td>
					<td>${pro.organization}</td>
					<td>${pro.createUser}</td>
					<td>${pro.createDate}</td>
					<td>${pro.modifyUser}</td>
					<td>${pro.modifyDate}</td>
				<td>
				<a title="删除产品设置" target="ajaxTodo" href="Product/delete?id=${pro.id }" class="btnDel">删除产品设置</a>
				<a title="查看产品设置" target="navTab" href="Product/view?id=${pro.id }" class="btnView">查看产品设置</a>
				<a title="编辑产品设置" target="navTab" href="Product/editUi?id=${pro.id }" class="btnEdit">编辑产品设置</a>
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