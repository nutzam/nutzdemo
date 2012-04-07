<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form id="pagerForm" method="post" action="HourlyWages/list">
	<input type="hidden" name="pageNum" value="${obj.pager.pageNumber}" /> 
	<input type="hidden" name="numPerPage" value="${obj.pager.pageSize}" />
	<input type="hidden" name="orderField" value="${param.orderField}" />
	<%-- 日期 --%>
	<input type="hidden" name="date" value="${obj.o.date}"/>
	<%-- 工作时间 --%>
    <input type="hidden" name="workHour" value="${obj.o.workHour}"/>
	<%-- 生产单号 --%>
	<input type="hidden" name="productionOrder" value="${obj.o.productionOrder}"/>
	<%-- 员工 --%>
	<input type="hidden" name="employee" value="${obj.o.employee}"/>
	<%-- 工种 --%>
	<input type="hidden" name="typeOfWork" value="${obj.o.typeOfWork}"/>
	<%-- 创建人 --%>
<%--<input type="hidden" name="createUser" value="${obj.o.createUser}/> --%>
	<%-- 创建时间 --%>
<%--<input type="hidden" name="createDate" value="${obj.o.createDate}/> --%>
	<%-- 修改人 --%>
<%--<input type="hidden" name="modifyUser" value="${obj.o.modifyUser}/> --%>
	<%-- 修改时间 --%>
<%--<input type="hidden" name="modifyDate" value="${obj.o.modifyDate}/> --%>
	<%-- 备注 --%>
	<input type="hidden" name="remarks" value="${obj.o.remarks}"/>
</form>
<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);" action="HourlyWages/list" method="post">
		<div class="searchBar">
			<table class="searchContent">
				<tr>
					<td>日期：<input type="text" name="date" value="${obj.o.date}"/></td>
			        <td>工作时间：<input type="text" name="workHour" value="${obj.o.workHour}"/></td>
					<td>生产单号：<input type="text" name="productionOrder" value="${obj.o.productionOrder}"/></td>
<%-- 			    	<td>员工：<input type="text" name="employee" value="${obj.o.employee}/></td> --%>			        
<%-- 			    	<td>工种：<input type="text" name="typeOfWork" value="${obj.o.typeOfWork}/></td> --%>			        
<%-- 			    	<td>创建人：<input type="text" name="createUser" value="${obj.o.createUser}/></td> --%>			        
<%-- 			    	<td>创建时间：<input type="text" name="createDate" value="${obj.o.createDate}/></td> --%>			        
<%-- 			    	<td>修改人：<input type="text" name="modifyUser" value="${obj.o.modifyUser}/></td> --%>			        
<%-- 			    	<td>修改时间：<input type="text" name="modifyDate" value="${obj.o.modifyDate}/></td> --%>			        
<%-- 			    	<td>备注：<input type="text" name="remarks" value="${obj.o.remarks}/></td> --%>			        
				</tr>
			</table>
			<div class="subBar">
				<ul>
					<li><div class="buttonActive">
							<div class="buttonContent">
								<button type="submit">检索</button>
							</div>
						</div></li>
					<li><a class="button" href="HourlyWages/queryUi" target="dialog" mask="true" title="查询框"><span>高级检索</span></a></li>
				</ul>
			</div>
		</div>
	</form>
</div>
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="add" href="HourlyWages/addUi" target="navTab" rel="newPage" title="添加计时工资"><span>添加</span></a></li>
			<li><a title="确实要删除这些记录吗?" target="selectedTodo" rel="ids" postType="string" href="HourlyWages/delByIds" class="delete"><span>批量删除</span></a></li>
			<li><a class="edit" href="HourlyWages/editUi?id={sid_hourlyWages}" target="navTab" rel="newPage" title="修改计时工资"><span>修改</span></a></li>
			<li class="line">line</li>
			<li><a class="icon" href="#" target="dwzExport" targetType="navTab" title="实要导出这些记录吗?"><span>导出EXCEL</span></a></li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th width="26"><input type="checkbox" group="ids" class="checkboxCtrl"></th>
				<th>日期</th>
				<th>工作时间</th>
				<th>生产单号</th>
				<th>员工</th>
				<th>工种</th>
				<th>创建人</th>
				<th>创建时间</th>
				<th>修改人</th>
				<th>修改时间</th>
				<th>备注</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${obj.list}" var="hou">
				<tr target="sid_hourlyWages" rel="${hou.id }">
				<td><input name="ids" value="'${hou.id}'" type="checkbox"></td>
					<td>${hou.date}</td>
					<td>${hou.workHour}</td>
					<td>${hou.productionOrder}</td>
					<td>${hou.employee}</td>
					<td>${hou.typeOfWork}</td>
					<td>${hou.createUser}</td>
					<td>${hou.createDate}</td>
					<td>${hou.modifyUser}</td>
					<td>${hou.modifyDate}</td>
					<td>${hou.remarks}</td>
				<td>
				<a title="删除计时工资" target="ajaxTodo" href="HourlyWages/delete?id=${hou.id }" class="btnDel">删除计时工资</a>
				<a title="查看计时工资" target="navTab" href="HourlyWages/view?id=${hou.id }" class="btnView">查看计时工资</a>
				<a title="编辑计时工资" target="navTab" href="HourlyWages/editUi?id=${hou.id }" class="btnEdit">编辑计时工资</a>
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