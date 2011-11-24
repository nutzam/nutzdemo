<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="page">
	<div class="pageContent">
		<form method="post" action="PieceRate/list" class="pageForm" onsubmit="return navTabSearch(this, 'pieceRate');">
			<div class="pageFormContent" layoutH="58">
<!-- 				<div> -->
<!-- 					<label>请输入检索条件：</label> -->
<!-- 					<input type="text" size="50" minlength="3" maxlength="10"/> -->
<!-- 				</div> -->
				<div class="divider">divider</div>
		        <div>
				<label>产品：</label>
				<input type="text" name="product" value="${obj.o.product}" size="25" />
				<span class="inputInfo">产品</span>
				</div>
		        <div>
				<label>工序：</label>
				<input type="text" name="process" value="${obj.o.process}" size="25" />
				<span class="inputInfo">工序</span>
				</div>
		        <div>
				<label>工票日期：</label>
				<input type="text" name="wtDate" value="${obj.o.wtDate}" size="25" />
				<span class="inputInfo">工票日期</span>
				</div>
		        <div>
				<label>人员编号：</label>
				<input type="text" name="employee" value="${obj.o.employee}" size="25" />
				<span class="inputInfo">人员编号</span>
				</div>
		        <div>
				<label>合格数量：</label>
				<input type="text" name="qualifiedNumber" value="${obj.o.qualifiedNumber}" size="25" />
				<span class="inputInfo">合格数量</span>
				</div>
		        <div>
				<label>金额：</label>
				<input type="text" name="money" value="${obj.o.money}" size="25" />
				<span class="inputInfo">金额</span>
				</div>
		        <div>
				<label>废品数量：</label>
				<input type="text" name="quantityScrapped" value="${obj.o.quantityScrapped}" size="25" />
				<span class="inputInfo">废品数量</span>
				</div>
		        <div>
				<label>废品扣款：</label>
				<input type="text" name="wasteDeductions" value="${obj.o.wasteDeductions}" size="25" />
				<span class="inputInfo">废品扣款</span>
				</div>
		        <div>
				<label>计件金额：</label>
				<input type="text" name="amount" value="${obj.o.amount}" size="25" />
				<span class="inputInfo">计件金额</span>
				</div>
		        <div>
				<label>流水号：</label>
				<input type="text" name="serialNumber" value="${obj.o.serialNumber}" size="25" />
				<span class="inputInfo">流水号</span>
				</div>
<%-- 			    <div>
					<label>创建人：</label>
					<input type="text" name="createUser" value="${obj.o.createUser}" size="25" />
					<span class="inputInfo">创建人</span>
					</div> --%>
<%-- 			    <div>
					<label>创建时间：</label>
					<input type="text" name="createDate" value="${obj.o.createDate}" size="25" />
					<span class="inputInfo">创建时间</span>
					</div> --%>
<%-- 			    <div>
					<label>修改人：</label>
					<input type="text" name="modifyUser" value="${obj.o.modifyUser}" size="25" />
					<span class="inputInfo">修改人</span>
					</div> --%>
<%-- 			    <div>
					<label>修改时间：</label>
					<input type="text" name="modifyDate" value="${obj.o.modifyDate}" size="25" />
					<span class="inputInfo">修改时间</span>
					</div> --%>
<!-- 				<div class="divider">divider</div> -->
<!-- 				<div> -->
<!-- 					<label>排序条件：</label> -->
<!-- 					<select> -->
<!-- 						<option>按客户号倒排</option> -->
<!-- 						<option>按建档日期倒排</option> -->
<!-- 						<option>按信用等级顺排</option> -->
<!-- 						<option>按客户号顺排</option> -->
<!-- 						<option>按建档日期顺排</option> -->
<!-- 						<option>按所属行业顺排</option> -->
<!-- 					</select> -->
<!-- 				</div> -->
			</div>
			<div class="formBar">
				<ul>
					<li><div class="buttonActive"><div class="buttonContent"><button type="submit">开始检索</button></div></div></li>
					<li><div class="button"><div class="buttonContent"><button type="reset">清空重输</button></div></div></li>
				</ul>
			</div>
		</form>
	</div>
</div>