<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="pageContent">
	<form method="post" action="PieceRate/<c:choose><c:when test="${obj==null}">add</c:when><c:otherwise>update</c:otherwise></c:choose>" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<input type="hidden" name="id" value="${obj.id}">
			<p>
				<label>产品：</label>
				<input name="product" type="text" size="30" value="${obj.product}"  maxlength="36"/>
			</p>
			<p>
				<label>工序：</label>
				<input name="process" type="text" size="30" value="${obj.process}"  maxlength="36"/>
			</p>
			<p>
				<label>人员编号：</label>
				<input name="employee" type="text" size="30" value="${obj.employee}"  maxlength="36"/>
			</p>
			<p>
				<label>合格数量：</label>
				<input name="qualifiedNumber" type="text" size="30" value="${obj.qualifiedNumber}" class="digits" />
			</p>
			<p>
				<label>金额：</label>
				<input name="money" type="text" size="30" value="${obj.money}" class="number" />
			</p>
			<p>
				<label>废品数量：</label>
				<input name="quantityScrapped" type="text" size="30" value="${obj.quantityScrapped}" class="digits" />
			</p>
			<p>
				<label>废品扣款：</label>
				<input name="wasteDeductions" type="text" size="30" value="${obj.wasteDeductions}" class="number" />
			</p>
			<p>
				<label>计件金额：</label>
				<input name="amount" type="text" size="30" value="${obj.amount}" class="number" />
			</p>
			<p>
				<label>流水号：</label>
				<input name="serialNumber" type="text" size="30" value="${obj.serialNumber}" class="digits" />
			</p>
		
		</div>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
				<li>
					<div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div>
				</li>
			</ul>
		</div>
	</form>
</div>
