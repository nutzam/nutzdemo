<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form id="pagerForm" method="post" action="TypeOfWork/list">
	<input type="hidden" name="pageNum" value="${obj.pager.pageNumber}" /> 
	<input type="hidden" name="numPerPage" value="${obj.pager.pageSize}" />
	<input type="hidden" name="orderField" value="${param.orderField}" />
	<%-- 工种 --%>
	<input type="hidden" name="name" value="${obj.o.name}"/>
	<%-- 计时单位 --%>
	<input type="hidden" name="timingUnit" value="${obj.o.timingUnit}"/>
	<%-- 计时单价 --%>
    <input type="hidden" name="price" value="${obj.o.price}"/>
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
	<form onsubmit="return navTabSearch(this);" action="TypeOfWork/list" method="post">
		<div class="searchBar">
			<table class="searchContent">
				<tr>
					<td>工种：<input type="text" name="name" value="${obj.o.name}"/></td>
					<td>计时单位：<input type="text" name="timingUnit" value="${obj.o.timingUnit}"/></td>
			        <td>计时单价：<input type="text" name="price" value="${obj.o.price}"/></td>
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
					<li><a class="button" href="TypeOfWork/queryUi" target="dialog" mask="true" title="查询框"><span>高级检索</span></a></li>
				</ul>
			</div>
		</div>
	</form>
</div>
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="add" href="TypeOfWork/addUi" target="navTab" rel="newPage" title="添加工种设置"><span>添加</span></a></li>
			<li><a title="确实要删除这些记录吗?" target="selectedTodo" rel="ids" postType="string" href="TypeOfWork/delByIds" class="delete"><span>批量删除</span></a></li>
			<li><a class="edit" href="TypeOfWork/editUi?id={sid_typeOfWork}" target="navTab" rel="newPage" title="修改工种设置"><span>修改</span></a></li>
			<li class="line">line</li>
			<li><a class="icon" href="#" target="dwzExport" targetType="navTab" title="实要导出这些记录吗?"><span>导出EXCEL</span></a></li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th width="26"><input type="checkbox" group="ids" class="checkboxCtrl"></th>
				<th>工种</th>
				<th>计时单位</th>
				<th>计时单价</th>
				<th>创建人</th>
				<th>创建时间</th>
				<th>修改人</th>
				<th>修改时间</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${obj.list}" var="typ">
				<tr target="sid_typeOfWork" rel="${typ.id }">
				<td><input name="ids" value="'${typ.id}'" type="checkbox"></td>
					<td>${typ.name}</td>
					<td>${typ.timingUnit}</td>
					<td>${typ.price}</td>
					<td>${typ.createUser}</td>
					<td>${typ.createDate}</td>
					<td>${typ.modifyUser}</td>
					<td>${typ.modifyDate}</td>
				<td>
				<a title="删除工种设置" target="ajaxTodo" href="TypeOfWork/delete?id=${typ.id }" class="btnDel">删除工种设置</a>
				<a title="查看工种设置" target="navTab" href="TypeOfWork/view?id=${typ.id }" class="btnView">查看工种设置</a>
				<a title="编辑工种设置" target="navTab" href="TypeOfWork/editUi?id=${typ.id }" class="btnEdit">编辑工种设置</a>
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