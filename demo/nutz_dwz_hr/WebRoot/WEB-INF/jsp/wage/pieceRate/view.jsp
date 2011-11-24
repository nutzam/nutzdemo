<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h2 class="contentTitle">计件工资查看页面</h2>
<div class="pageContent">
	
	<div class="viewInfo" layoutH="97">
		<dl>
			<dt>产品：</dt><dd>${obj.product}</dd>
		</dl>
		<dl>
			<dt>工序：</dt><dd>${obj.process}</dd>
		</dl>
		<dl>
			<dt>工票日期：</dt><dd>${obj.wtDate}</dd>
		</dl>
		<dl>
			<dt>人员编号：</dt><dd>${obj.employee}</dd>
		</dl>
		<dl>
			<dt>合格数量：</dt><dd>${obj.qualifiedNumber}</dd>
		</dl>
		<dl>
			<dt>金额：</dt><dd>${obj.money}</dd>
		</dl>
		<dl>
			<dt>废品数量：</dt><dd>${obj.quantityScrapped}</dd>
		</dl>
		<dl>
			<dt>废品扣款：</dt><dd>${obj.wasteDeductions}</dd>
		</dl>
		<dl>
			<dt>计件金额：</dt><dd>${obj.amount}</dd>
		</dl>
		<dl>
			<dt>流水号：</dt><dd>${obj.serialNumber}</dd>
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
