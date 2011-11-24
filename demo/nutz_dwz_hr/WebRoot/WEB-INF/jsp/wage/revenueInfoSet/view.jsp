<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h2 class="contentTitle">税收信息设置查看页面</h2>
<div class="pageContent">
	
	<div class="viewInfo" layoutH="97">
		<dl>
			<dt>级别号：</dt><dd>${obj.rank}</dd>
		</dl>
		<dl>
			<dt>起始额：</dt><dd>${obj.startingForehead}</dd>
		</dl>
		<dl>
			<dt>结束额：</dt><dd>${obj.endForehead}</dd>
		</dl>
		<dl>
			<dt>税率：</dt><dd>${obj.taxRate}</dd>
		</dl>
		<dl>
			<dt>修改时间：</dt><dd>${obj.modifyDate}</dd>
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
			<dt>速算扣除数：</dt><dd>${obj.qcd}</dd>
		</dl>

		<div class="divider"></div>
			</div>

	<div class="formBar">
		<ul>
			<li><div class="button"><div class="buttonContent"><button class="close" type="button"><hi:text key="关闭"/></button></div></div></li>
		</ul>
	</div>
</div>
