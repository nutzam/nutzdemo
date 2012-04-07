<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form id="pagerForm" method="post" action="SalaryItem/list">
	<input type="hidden" name="pageNum" value="${obj.pager.pageNumber}" /> 
	<input type="hidden" name="numPerPage" value="${obj.pager.pageSize}" />
	<input type="hidden" name="orderField" value="${param.orderField}" />
	<%-- 在薪资表中对应的列 --%>
	<input type="hidden" name="salaryColumn" value="${obj.o.salaryColumn}"/>
	<%-- 工资账套 --%>
	<input type="hidden" name="accountId" value="${obj.o.accountId}"/>
	<%-- 工资项目 --%>
	<input type="hidden" name="itemName" value="${obj.o.itemName}"/>
	<%-- 项目类型 --%>
	<input type="hidden" name="itemType" value="${obj.o.itemType}"/>
	<%-- 小数位数 --%>
    <input type="hidden" name="decimals" value="${obj.o.decimals}"/>
	<%-- 舍位方式 --%>
	<input type="hidden" name="round" value="${obj.o.round}"/>
	<%-- 初始值 --%>
    <input type="hidden" name="initialValue" value="${obj.o.initialValue}"/>
	<%-- 显示公式 --%>
	<input type="hidden" name="displayFormular" value="${obj.o.displayFormular}"/>
	<%-- 数据公式 --%>
	<input type="hidden" name="dbFormular" value="${obj.o.dbFormular}"/>
	<%-- 描述 --%>
	<input type="hidden" name="description" value="${obj.o.description}"/>
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
	<form onsubmit="return navTabSearch(this);" action="SalaryItem/list" method="post">
		<div class="searchBar">
			<table class="searchContent">
				<tr>
					<td>在薪资表中对应的列：<input type="text" name="salaryColumn" value="${obj.o.salaryColumn}"/></td>
					<td>工资账套：<input type="text" name="accountId" value="${obj.o.accountId}"/></td>
					<td>工资项目：<input type="text" name="itemName" value="${obj.o.itemName}"/></td>
<%-- 			    	<td>项目类型：<input type="text" name="itemType" value="${obj.o.itemType}/></td> --%>			        
<%-- 			    	<td>小数位数：<input type="text" name="decimals" value="${obj.o.decimals}/></td> --%>			        
<%-- 			    	<td>舍位方式：<input type="text" name="round" value="${obj.o.round}/></td> --%>			        
<%-- 			    	<td>初始值：<input type="text" name="initialValue" value="${obj.o.initialValue}/></td> --%>			        
<%-- 			    	<td>显示公式：<input type="text" name="displayFormular" value="${obj.o.displayFormular}/></td> --%>			        
<%-- 			    	<td>数据公式：<input type="text" name="dbFormular" value="${obj.o.dbFormular}/></td> --%>			        
<%-- 			    	<td>描述：<input type="text" name="description" value="${obj.o.description}/></td> --%>			        
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
					<li><a class="button" href="SalaryItem/queryUi" target="dialog" mask="true" title="查询框"><span>高级检索</span></a></li>
				</ul>
			</div>
		</div>
	</form>
</div>
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="add" href="SalaryItem/addUi" target="navTab" rel="newPage" title="添加工资项目"><span>添加</span></a></li>
			<li><a title="确实要删除这些记录吗?" target="selectedTodo" rel="ids" postType="string" href="SalaryItem/delByIds" class="delete"><span>批量删除</span></a></li>
			<li><a class="edit" href="SalaryItem/editUi?id={sid_salaryItem}" target="navTab" rel="newPage" title="修改工资项目"><span>修改</span></a></li>
			<li class="line">line</li>
			<li><a class="icon" href="#" target="dwzExport" targetType="navTab" title="实要导出这些记录吗?"><span>导出EXCEL</span></a></li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th width="26"><input type="checkbox" group="ids" class="checkboxCtrl"></th>
				<th>在薪资表中对应的列</th>
				<th>工资账套</th>
				<th>工资项目</th>
				<th>项目类型</th>
				<th>小数位数</th>
				<th>舍位方式</th>
				<th>初始值</th>
				<th>显示公式</th>
				<th>数据公式</th>
				<th>描述</th>
				<th>创建人</th>
				<th>创建时间</th>
				<th>修改人</th>
				<th>修改时间</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${obj.list}" var="sal">
				<tr target="sid_salaryItem" rel="${sal.id }">
				<td><input name="ids" value="'${sal.id}'" type="checkbox"></td>
					<td>${sal.salaryColumn}</td>
					<td>${sal.accountId}</td>
					<td>${sal.itemName}</td>
					<td>${sal.itemType}</td>
					<td>${sal.decimals}</td>
					<td>${sal.round}</td>
					<td>${sal.initialValue}</td>
					<td>${sal.displayFormular}</td>
					<td>${sal.dbFormular}</td>
					<td>${sal.description}</td>
					<td>${sal.createUser}</td>
					<td>${sal.createDate}</td>
					<td>${sal.modifyUser}</td>
					<td>${sal.modifyDate}</td>
				<td>
				<a title="删除工资项目" target="ajaxTodo" href="SalaryItem/delete?id=${sal.id }" class="btnDel">删除工资项目</a>
				<a title="查看工资项目" target="navTab" href="SalaryItem/view?id=${sal.id }" class="btnView">查看工资项目</a>
				<a title="编辑工资项目" target="navTab" href="SalaryItem/editUi?id=${sal.id }" class="btnEdit">编辑工资项目</a>
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