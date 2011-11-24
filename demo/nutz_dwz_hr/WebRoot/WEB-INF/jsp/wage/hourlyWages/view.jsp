<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h2 class="contentTitle">计时工资查看页面</h2>
<div class="pageContent">
	
	<div class="viewInfo" layoutH="97">
		<dl>
			<dt>日期：</dt><dd>${obj.date}</dd>
		</dl>
		<dl>
			<dt>工作时间：</dt><dd>${obj.workHour}</dd>
		</dl>
		<dl>
			<dt>生产单号：</dt><dd>${obj.productionOrder}</dd>
		</dl>
		<dl>
			<dt>员工：</dt><dd>${obj.employee}</dd>
		</dl>
		<dl>
			<dt>工种：</dt><dd>${obj.typeOfWork}</dd>
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
		<dl>
			<dt>备注：</dt><dd>${obj.remarks}</dd>
		</dl>

		<div class="divider"></div>
			</div>

	<div class="formBar">
		<ul>
			<li><div class="button"><div class="buttonContent"><button class="close" type="button"><hi:text key="关闭"/></button></div></div></li>
		</ul>
	</div>
</div>
