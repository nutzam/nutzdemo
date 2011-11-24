<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h2 class="contentTitle">工资项目查看页面</h2>
<div class="pageContent">
	
	<div class="viewInfo" layoutH="97">
		<dl>
			<dt>在薪资表中对应的列：</dt><dd>${obj.salaryColumn}</dd>
		</dl>
		<dl>
			<dt>工资账套：</dt><dd>${obj.accountId}</dd>
		</dl>
		<dl>
			<dt>工资项目：</dt><dd>${obj.itemName}</dd>
		</dl>
		<dl>
			<dt>项目类型：</dt><dd>${obj.itemType}</dd>
		</dl>
		<dl>
			<dt>小数位数：</dt><dd>${obj.decimals}</dd>
		</dl>
		<dl>
			<dt>舍位方式：</dt><dd>${obj.round}</dd>
		</dl>
		<dl>
			<dt>初始值：</dt><dd>${obj.initialValue}</dd>
		</dl>
		<dl>
			<dt>显示公式：</dt><dd>${obj.displayFormular}</dd>
		</dl>
		<dl>
			<dt>数据公式：</dt><dd>${obj.dbFormular}</dd>
		</dl>
		<dl>
			<dt>描述：</dt><dd>${obj.description}</dd>
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
