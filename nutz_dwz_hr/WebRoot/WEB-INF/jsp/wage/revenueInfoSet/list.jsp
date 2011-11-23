<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form id="pagerForm" method="post" action="RevenueInfoSet/list">
	<input type="hidden" name="pageNum" value="${obj.pager.pageNumber}" /> 
	<input type="hidden" name="numPerPage" value="${obj.pager.pageSize}" />
	<input type="hidden" name="orderField" value="${param.orderField}" />
	<%-- 级别号 --%>
    <input type="hidden" name="rank" value="${obj.o.rank}"/>
	<%-- 起始额 --%>
    <input type="hidden" name="startingForehead" value="${obj.o.startingForehead}"/>
	<%-- 结束额 --%>
    <input type="hidden" name="endForehead" value="${obj.o.endForehead}"/>
	<%-- 税率 --%>
    <input type="hidden" name="taxRate" value="${obj.o.taxRate}"/>
	<%-- 修改时间 --%>
<%--<input type="hidden" name="modifyDate" value="${obj.o.modifyDate}/> --%>
	<%-- 创建人 --%>
<%--<input type="hidden" name="createUser" value="${obj.o.createUser}/> --%>
	<%-- 创建时间 --%>
<%--<input type="hidden" name="createDate" value="${obj.o.createDate}/> --%>
	<%-- 修改人 --%>
<%--<input type="hidden" name="modifyUser" value="${obj.o.modifyUser}/> --%>
	<%-- 速算扣除数 --%>
    <input type="hidden" name="qcd" value="${obj.o.qcd}"/>
</form>
<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);" action="RevenueInfoSet/list" method="post">
		<div class="searchBar">
			<table class="searchContent">
				<tr>
			        <td>级别号：<input type="text" name="rank" value="${obj.o.rank}"/></td>
			        <td>起始额：<input type="text" name="startingForehead" value="${obj.o.startingForehead}"/></td>
			        <td>结束额：<input type="text" name="endForehead" value="${obj.o.endForehead}"/></td>
<%-- 			    	<td>税率：<input type="text" name="taxRate" value="${obj.o.taxRate}/></td> --%>			        
<%-- 			    	<td>修改时间：<input type="text" name="modifyDate" value="${obj.o.modifyDate}/></td> --%>			        
<%-- 			    	<td>创建人：<input type="text" name="createUser" value="${obj.o.createUser}/></td> --%>			        
<%-- 			    	<td>创建时间：<input type="text" name="createDate" value="${obj.o.createDate}/></td> --%>			        
<%-- 			    	<td>修改人：<input type="text" name="modifyUser" value="${obj.o.modifyUser}/></td> --%>			        
<%-- 			    	<td>速算扣除数：<input type="text" name="qcd" value="${obj.o.qcd}/></td> --%>			        
				</tr>
			</table>
			<div class="subBar">
				<ul>
					<li><div class="buttonActive">
							<div class="buttonContent">
								<button type="submit">检索</button>
							</div>
						</div></li>
					<li><a class="button" href="RevenueInfoSet/queryUi" target="dialog" mask="true" title="查询框"><span>高级检索</span></a></li>
				</ul>
			</div>
		</div>
	</form>
</div>
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="add" href="RevenueInfoSet/addUi" target="navTab" rel="newPage" title="添加税收信息设置"><span>添加</span></a></li>
			<li><a title="确实要删除这些记录吗?" target="selectedTodo" rel="ids" postType="string" href="RevenueInfoSet/delByIds" class="delete"><span>批量删除</span></a></li>
			<li><a class="edit" href="RevenueInfoSet/editUi?id={sid_revenueInfoSet}" target="navTab" rel="newPage" title="修改税收信息设置"><span>修改</span></a></li>
			<li class="line">line</li>
			<li><a class="icon" href="#" target="dwzExport" targetType="navTab" title="实要导出这些记录吗?"><span>导出EXCEL</span></a></li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th width="26"><input type="checkbox" group="ids" class="checkboxCtrl"></th>
				<th>级别号</th>
				<th>起始额</th>
				<th>结束额</th>
				<th>税率</th>
				<th>修改时间</th>
				<th>创建人</th>
				<th>创建时间</th>
				<th>修改人</th>
				<th>速算扣除数</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${obj.list}" var="rev">
				<tr target="sid_revenueInfoSet" rel="${rev.id }">
				<td><input name="ids" value="'${rev.id}'" type="checkbox"></td>
					<td>${rev.rank}</td>
					<td>${rev.startingForehead}</td>
					<td>${rev.endForehead}</td>
					<td>${rev.taxRate}</td>
					<td>${rev.modifyDate}</td>
					<td>${rev.createUser}</td>
					<td>${rev.createDate}</td>
					<td>${rev.modifyUser}</td>
					<td>${rev.qcd}</td>
				<td>
				<a title="删除税收信息设置" target="ajaxTodo" href="RevenueInfoSet/delete?id=${rev.id }" class="btnDel">删除税收信息设置</a>
				<a title="查看税收信息设置" target="navTab" href="RevenueInfoSet/view?id=${rev.id }" class="btnView">查看税收信息设置</a>
				<a title="编辑税收信息设置" target="navTab" href="RevenueInfoSet/editUi?id=${rev.id }" class="btnEdit">编辑税收信息设置</a>
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