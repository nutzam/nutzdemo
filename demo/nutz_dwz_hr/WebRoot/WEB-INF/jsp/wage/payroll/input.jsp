<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="pageContent">
	<form method="post" action="Payroll/<c:choose><c:when test="${obj==null}">add</c:when><c:otherwise>update</c:otherwise></c:choose>" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<input type="hidden" name="id" value="${obj.id}">
			<p>
				<label>类型：</label>
				<input name="type" type="text" size="30" value="${obj.type}" class="required" maxlength="20"/>
			</p>
			<p>
				<label>年份：</label>
				<input name="year" type="text" size="30" value="${obj.year}" class="required" maxlength="10"/>
			</p>
			<p>
				<label>季度：</label>
				<input name="quarter" type="text" size="30" value="${obj.quarter}" class="digits" />
			</p>
			<p>
				<label>月份：</label>
				<input name="month" type="text" size="30" value="${obj.month}" class="digits" />
			</p>
			<p>
				<label>总额：</label>
				<input name="totalSum" type="text" size="30" value="${obj.totalSum}" class="number" class="required"/>
			</p>
			<p>
				<label>组织机构：</label>
				<input name="organization" type="text" size="30" value="${obj.organization}" class="required" maxlength="36"/>
			</p>
			<p>
				<label>状态：</label>
				<input name="state" type="text" size="30" value="${obj.state}" class="required" maxlength="1"/>
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
