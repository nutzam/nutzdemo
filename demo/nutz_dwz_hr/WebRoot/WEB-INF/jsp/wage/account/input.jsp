<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="pageContent">
	<form method="post" action="Account/<c:choose><c:when test="${obj==null}">add</c:when><c:otherwise>update</c:otherwise></c:choose>" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<input type="hidden" name="id" value="${obj.id}">
			<p>
				<label>名称：</label>
				<input name="name" type="text" size="30" value="${obj.name}" class="required" maxlength="150"/>
			</p>
			<p>
				<label>账套状态：</label>
				<input name="status" type="text" size="30" value="${obj.status}" class="required" maxlength="50"/>
			</p>
			<p>
				<label>描述：</label>
				<input name="description" type="text" size="30" value="${obj.description}"  maxlength="255"/>
			</p>
			<p>
				<label>组织机构：</label>
				<input name="organization" type="text" size="30" value="${obj.organization}" class="required" maxlength="36"/>
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
