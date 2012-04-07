<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form id="pagerForm" method="post" action="Payroll/list">
	<input type="hidden" name="pageNum" value="${obj.pager.pageNumber}" /> 
	<input type="hidden" name="numPerPage" value="${obj.pager.pageSize}" />
	<input type="hidden" name="orderField" value="${param.orderField}" />
	<%-- 类型 --%>
	<input type="hidden" name="type" value="${obj.o.type}"/>
	<%-- 年份 --%>
	<input type="hidden" name="year" value="${obj.o.year}"/>
	<%-- 季度 --%>
    <input type="hidden" name="quarter" value="${obj.o.quarter}"/>
	<%-- 月份 --%>
    <input type="hidden" name="month" value="${obj.o.month}"/>
	<%-- 总额 --%>
    <input type="hidden" name="totalSum" value="${obj.o.totalSum}"/>
	<%-- 组织机构 --%>
	<input type="hidden" name="organization" value="${obj.o.organization}"/>
	<%-- 状态 --%>
	<input type="hidden" name="state" value="${obj.o.state}"/>
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
	<form onsubmit="return navTabSearch(this);" action="Payroll/list" method="post">
		<div class="searchBar">
			<table class="searchContent">
				<tr>
					<td>类型：<input type="text" name="type" value="${obj.o.type}"/></td>
					<td>年份：<input type="text" name="year" value="${obj.o.year}"/></td>
			        <td>季度：<input type="text" name="quarter" value="${obj.o.quarter}"/></td>
<%-- 			    	<td>月份：<input type="text" name="month" value="${obj.o.month}/></td> --%>			        
<%-- 			    	<td>总额：<input type="text" name="totalSum" value="${obj.o.totalSum}/></td> --%>			        
<%-- 			    	<td>组织机构：<input type="text" name="organization" value="${obj.o.organization}/></td> --%>			        
<%-- 			    	<td>状态：<input type="text" name="state" value="${obj.o.state}/></td> --%>			        
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
					<li><a class="button" href="Payroll/queryUi" target="dialog" mask="true" title="查询框"><span>高级检索</span></a></li>
				</ul>
			</div>
		</div>
	</form>
</div>
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="add" href="Payroll/addUi" target="navTab" rel="newPage" title="添加薪酬总额"><span>添加</span></a></li>
			<li><a title="确实要删除这些记录吗?" target="selectedTodo" rel="ids" postType="string" href="Payroll/delByIds" class="delete"><span>批量删除</span></a></li>
			<li><a class="edit" href="Payroll/editUi?id={sid_payroll}" target="navTab" rel="newPage" title="修改薪酬总额"><span>修改</span></a></li>
			<li class="line">line</li>
			<li><a class="icon" href="#" target="dwzExport" targetType="navTab" title="实要导出这些记录吗?"><span>导出EXCEL</span></a></li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th width="26"><input type="checkbox" group="ids" class="checkboxCtrl"></th>
				<th>类型</th>
				<th>年份</th>
				<th>季度</th>
				<th>月份</th>
				<th>总额</th>
				<th>组织机构</th>
				<th>状态</th>
				<th>创建人</th>
				<th>创建时间</th>
				<th>修改人</th>
				<th>修改时间</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${obj.list}" var="pay">
				<tr target="sid_payroll" rel="${pay.id }">
				<td><input name="ids" value="'${pay.id}'" type="checkbox"></td>
					<td>${pay.type}</td>
					<td>${pay.year}</td>
					<td>${pay.quarter}</td>
					<td>${pay.month}</td>
					<td>${pay.totalSum}</td>
					<td>${pay.organization}</td>
					<td>${pay.state}</td>
					<td>${pay.createUser}</td>
					<td>${pay.createDate}</td>
					<td>${pay.modifyUser}</td>
					<td>${pay.modifyDate}</td>
				<td>
				<a title="删除薪酬总额" target="ajaxTodo" href="Payroll/delete?id=${pay.id }" class="btnDel">删除薪酬总额</a>
				<a title="查看薪酬总额" target="navTab" href="Payroll/view?id=${pay.id }" class="btnView">查看薪酬总额</a>
				<a title="编辑薪酬总额" target="navTab" href="Payroll/editUi?id=${pay.id }" class="btnEdit">编辑薪酬总额</a>
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