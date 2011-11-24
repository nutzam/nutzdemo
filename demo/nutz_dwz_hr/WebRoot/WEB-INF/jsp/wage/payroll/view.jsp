<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h2 class="contentTitle">薪酬总额查看页面</h2>
<div class="pageContent">
	
	<div class="viewInfo" layoutH="97">
		<dl>
			<dt>类型：</dt><dd>${obj.type}</dd>
		</dl>
		<dl>
			<dt>年份：</dt><dd>${obj.year}</dd>
		</dl>
		<dl>
			<dt>季度：</dt><dd>${obj.quarter}</dd>
		</dl>
		<dl>
			<dt>月份：</dt><dd>${obj.month}</dd>
		</dl>
		<dl>
			<dt>总额：</dt><dd>${obj.totalSum}</dd>
		</dl>
		<dl>
			<dt>组织机构：</dt><dd>${obj.organization}</dd>
		</dl>
		<dl>
			<dt>状态：</dt><dd>${obj.state}</dd>
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
