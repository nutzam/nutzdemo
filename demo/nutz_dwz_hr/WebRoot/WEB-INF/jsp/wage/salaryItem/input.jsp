<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="pageContent">
	<form method="post" action="SalaryItem/<c:choose><c:when test="${obj==null}">add</c:when><c:otherwise>update</c:otherwise></c:choose>" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<input type="hidden" name="id" value="${obj.id}">
			<p>
				<label>在薪资表中对应的列：</label>
				<input name="salaryColumn" type="text" size="30" value="${obj.salaryColumn}" class="required" maxlength="36"/>
			</p>
			<p>
				<label>工资账套：</label>
				<input name="accountId" type="text" size="30" value="${obj.accountId}" class="required" maxlength="36"/>
			</p>
			<p>
				<label>工资项目：</label>
				<input name="itemName" type="text" size="30" value="${obj.itemName}" class="required" maxlength="150"/>
			</p>
			<p>
				<label>项目类型：</label>
				<input name="itemType" type="text" size="30" value="${obj.itemType}" class="required" maxlength="50"/>
			</p>
			<p>
				<label>小数位数：</label>
				<input name="decimals" type="text" size="30" value="${obj.decimals}" class="digits" class="required"/>
			</p>
			<p>
				<label>舍位方式：</label>
				<input name="round" type="text" size="30" value="${obj.round}" class="required" maxlength="50"/>
			</p>
			<p>
				<label>初始值：</label>
				<input name="initialValue" type="text" size="30" value="${obj.initialValue}" class="number" />
			</p>
			<p>
				<label>显示公式：</label>
				<input name="displayFormular" type="text" size="30" value="${obj.displayFormular}"  maxlength="1500"/>
			</p>
			<p>
				<label>数据公式：</label>
				<input name="dbFormular" type="text" size="30" value="${obj.dbFormular}"  maxlength="1500"/>
			</p>
			<p>
				<label>描述：</label>
				<input name="description" type="text" size="30" value="${obj.description}"  maxlength="255"/>
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
