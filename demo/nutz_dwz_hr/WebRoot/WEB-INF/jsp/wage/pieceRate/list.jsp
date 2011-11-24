<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form id="pagerForm" method="post" action="PieceRate/list">
	<input type="hidden" name="pageNum" value="${obj.pager.pageNumber}" /> 
	<input type="hidden" name="numPerPage" value="${obj.pager.pageSize}" />
	<input type="hidden" name="orderField" value="${param.orderField}" />
	<%-- 产品 --%>
	<input type="hidden" name="product" value="${obj.o.product}"/>
	<%-- 工序 --%>
	<input type="hidden" name="process" value="${obj.o.process}"/>
	<%-- 工票日期 --%>
	<input type="hidden" name="wtDate" value="${obj.o.wtDate}"/>
	<%-- 人员编号 --%>
	<input type="hidden" name="employee" value="${obj.o.employee}"/>
	<%-- 合格数量 --%>
    <input type="hidden" name="qualifiedNumber" value="${obj.o.qualifiedNumber}"/>
	<%-- 金额 --%>
    <input type="hidden" name="money" value="${obj.o.money}"/>
	<%-- 废品数量 --%>
    <input type="hidden" name="quantityScrapped" value="${obj.o.quantityScrapped}"/>
	<%-- 废品扣款 --%>
    <input type="hidden" name="wasteDeductions" value="${obj.o.wasteDeductions}"/>
	<%-- 计件金额 --%>
    <input type="hidden" name="amount" value="${obj.o.amount}"/>
	<%-- 流水号 --%>
    <input type="hidden" name="serialNumber" value="${obj.o.serialNumber}"/>
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
	<form onsubmit="return navTabSearch(this);" action="PieceRate/list" method="post">
		<div class="searchBar">
			<table class="searchContent">
				<tr>
					<td>产品：<input type="text" name="product" value="${obj.o.product}"/></td>
					<td>工序：<input type="text" name="process" value="${obj.o.process}"/></td>
					<td>工票日期：<input type="text" name="wtDate" value="${obj.o.wtDate}"/></td>
<%-- 			    	<td>人员编号：<input type="text" name="employee" value="${obj.o.employee}/></td> --%>			        
<%-- 			    	<td>合格数量：<input type="text" name="qualifiedNumber" value="${obj.o.qualifiedNumber}/></td> --%>			        
<%-- 			    	<td>金额：<input type="text" name="money" value="${obj.o.money}/></td> --%>			        
<%-- 			    	<td>废品数量：<input type="text" name="quantityScrapped" value="${obj.o.quantityScrapped}/></td> --%>			        
<%-- 			    	<td>废品扣款：<input type="text" name="wasteDeductions" value="${obj.o.wasteDeductions}/></td> --%>			        
<%-- 			    	<td>计件金额：<input type="text" name="amount" value="${obj.o.amount}/></td> --%>			        
<%-- 			    	<td>流水号：<input type="text" name="serialNumber" value="${obj.o.serialNumber}/></td> --%>			        
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
					<li><a class="button" href="PieceRate/queryUi" target="dialog" mask="true" title="查询框"><span>高级检索</span></a></li>
				</ul>
			</div>
		</div>
	</form>
</div>
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="add" href="PieceRate/addUi" target="navTab" rel="newPage" title="添加计件工资"><span>添加</span></a></li>
			<li><a title="确实要删除这些记录吗?" target="selectedTodo" rel="ids" postType="string" href="PieceRate/delByIds" class="delete"><span>批量删除</span></a></li>
			<li><a class="edit" href="PieceRate/editUi?id={sid_pieceRate}" target="navTab" rel="newPage" title="修改计件工资"><span>修改</span></a></li>
			<li class="line">line</li>
			<li><a class="icon" href="#" target="dwzExport" targetType="navTab" title="实要导出这些记录吗?"><span>导出EXCEL</span></a></li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th width="26"><input type="checkbox" group="ids" class="checkboxCtrl"></th>
				<th>产品</th>
				<th>工序</th>
				<th>工票日期</th>
				<th>人员编号</th>
				<th>合格数量</th>
				<th>金额</th>
				<th>废品数量</th>
				<th>废品扣款</th>
				<th>计件金额</th>
				<th>流水号</th>
				<th>创建人</th>
				<th>创建时间</th>
				<th>修改人</th>
				<th>修改时间</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${obj.list}" var="pie">
				<tr target="sid_pieceRate" rel="${pie.id }">
				<td><input name="ids" value="'${pie.id}'" type="checkbox"></td>
					<td>${pie.product}</td>
					<td>${pie.process}</td>
					<td>${pie.wtDate}</td>
					<td>${pie.employee}</td>
					<td>${pie.qualifiedNumber}</td>
					<td>${pie.money}</td>
					<td>${pie.quantityScrapped}</td>
					<td>${pie.wasteDeductions}</td>
					<td>${pie.amount}</td>
					<td>${pie.serialNumber}</td>
					<td>${pie.createUser}</td>
					<td>${pie.createDate}</td>
					<td>${pie.modifyUser}</td>
					<td>${pie.modifyDate}</td>
				<td>
				<a title="删除计件工资" target="ajaxTodo" href="PieceRate/delete?id=${pie.id }" class="btnDel">删除计件工资</a>
				<a title="查看计件工资" target="navTab" href="PieceRate/view?id=${pie.id }" class="btnView">查看计件工资</a>
				<a title="编辑计件工资" target="navTab" href="PieceRate/editUi?id=${pie.id }" class="btnEdit">编辑计件工资</a>
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