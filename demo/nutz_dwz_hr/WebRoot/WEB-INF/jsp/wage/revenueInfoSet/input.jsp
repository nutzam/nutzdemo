<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="pageContent">
	<form method="post" action="RevenueInfoSet/<c:choose><c:when test="${obj==null}">add</c:when><c:otherwise>update</c:otherwise></c:choose>" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<input type="hidden" name="id" value="${obj.id}">
			<p>
				<label>级别号：</label>
				<input name="rank" type="text" size="30" value="${obj.rank}" class="digits" class="required"/>
			</p>
			<p>
				<label>起始额：</label>
				<input name="startingForehead" type="text" size="30" value="${obj.startingForehead}" class="number" class="required"/>
			</p>
			<p>
				<label>结束额：</label>
				<input name="endForehead" type="text" size="30" value="${obj.endForehead}" class="number" class="required"/>
			</p>
			<p>
				<label>税率：</label>
				<input name="taxRate" type="text" size="30" value="${obj.taxRate}" class="number" class="required"/>
			</p>
			<p>
				<label>速算扣除数：</label>
				<input name="qcd" type="text" size="30" value="${obj.qcd}" class="number" class="required"/>
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
