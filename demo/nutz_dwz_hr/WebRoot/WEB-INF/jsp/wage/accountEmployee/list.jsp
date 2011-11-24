<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form id="pagerForm" method="post" action="AccountEmployee/list">
	<input type="hidden" name="pageNum" value="${obj.pager.pageNumber}" /> 
	<input type="hidden" name="numPerPage" value="${obj.pager.pageSize}" />
	<input type="hidden" name="orderField" value="${param.orderField}" />
	<%-- 工资账套 --%>
	<input type="hidden" name="account" value="${obj.o.account}"/>
	<%-- 员工 --%>
	<input type="hidden" name="employee" value="${obj.o.employee}"/>
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
	<form onsubmit="return navTabSearch(this);" action="AccountEmployee/list" method="post">
		<div class="searchBar">
			<table class="searchContent">
				<tr>
					<td>工资账套：<input type="text" name="account" value="${obj.o.account}"/></td>
					<td>员工：<input type="text" name="employee" value="${obj.o.employee}"/></td>
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
					<li><a class="button" href="AccountEmployee/queryUi" target="dialog" mask="true" title="查询框"><span>高级检索</span></a></li>
				</ul>
			</div>
		</div>
	</form>
</div>
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="add" href="AccountEmployee/addUi" target="navTab" rel="newPage" title="添加人员套帐设置"><span>添加</span></a></li>
			<li><a title="确实要删除这些记录吗?" target="selectedTodo" rel="ids" postType="string" href="AccountEmployee/delByIds" class="delete"><span>批量删除</span></a></li>
			<li><a class="edit" href="AccountEmployee/editUi?id={sid_accountEmployee}" target="navTab" rel="newPage" title="修改人员套帐设置"><span>修改</span></a></li>
			<li class="line">line</li>
			<li><a class="icon" href="#" target="dwzExport" targetType="navTab" title="实要导出这些记录吗?"><span>导出EXCEL</span></a></li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th width="26"><input type="checkbox" group="ids" class="checkboxCtrl"></th>
				<th>工资账套</th>
				<th>员工</th>
				<th>创建人</th>
				<th>创建时间</th>
				<th>修改人</th>
				<th>修改时间</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${obj.list}" var="acc">
				<tr target="sid_accountEmployee" rel="${acc.id }">
				<td><input name="ids" value="'${acc.id}'" type="checkbox"></td>
					<td>${acc.account}</td>
					<td>${acc.employee}</td>
					<td>${acc.createUser}</td>
					<td>${acc.createDate}</td>
					<td>${acc.modifyUser}</td>
					<td>${acc.modifyDate}</td>
				<td>
				<a title="删除人员套帐设置" target="ajaxTodo" href="AccountEmployee/delete?id=${acc.id }" class="btnDel">删除人员套帐设置</a>
				<a title="查看人员套帐设置" target="navTab" href="AccountEmployee/view?id=${acc.id }" class="btnView">查看人员套帐设置</a>
				<a title="编辑人员套帐设置" target="navTab" href="AccountEmployee/editUi?id=${acc.id }" class="btnEdit">编辑人员套帐设置</a>
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