<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="pageContent">
	<form method="post" action="HourlyWages/<c:choose><c:when test="${obj==null}">add</c:when><c:otherwise>update</c:otherwise></c:choose>" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<input type="hidden" name="id" value="${obj.id}">
			<p>
				<label>工作时间：</label>
				<input name="workHour" type="text" size="30" value="${obj.workHour}" class="digits" />
			</p>
			<p>
				<label>生产单号：</label>
				<input name="productionOrder" type="text" size="30" value="${obj.productionOrder}"  maxlength="50"/>
			</p>
			<p>
				<label>员工：</label>
				<input name="employee" type="text" size="30" value="${obj.employee}"  maxlength="36"/>
			</p>
			<p>
				<label>工种：</label>
				<input name="typeOfWork" type="text" size="30" value="${obj.typeOfWork}"  maxlength="36"/>
			</p>
			<p>
				<label>备注：</label>
				<input name="remarks" type="text" size="30" value="${obj.remarks}"  maxlength="10"/>
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
