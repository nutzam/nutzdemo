<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h2 class="contentTitle">工种设置查看页面</h2>
<div class="pageContent">
	
	<div class="viewInfo" layoutH="97">
		<dl>
			<dt>工种：</dt><dd>${obj.name}</dd>
		</dl>
		<dl>
			<dt>计时单位：</dt><dd>${obj.timingUnit}</dd>
		</dl>
		<dl>
			<dt>计时单价：</dt><dd>${obj.price}</dd>
		</dl>
		<dl>
			<dt>创建人：</dt><dd>${obj.createUser}</dd>
		</dl>
		<dl>
			<dt>创建时间：</dt><dd>${obj.createDate}</dd>
		</dl>
		<dl>
			<dt>修改人：</dt><dd>${obj.modifyUser}</dd>
		</dl>
		<dl>
			<dt>修改时间：</dt><dd>${obj.modifyDate}</dd>
		</dl>

		<div class="divider"></div>
			</div>

	<div class="formBar">
		<ul>
			<li><div class="button"><div class="buttonContent"><button class="close" type="button"><hi:text key="关闭"/></button></div></div></li>
		</ul>
	</div>
</div>
