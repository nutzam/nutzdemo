<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="page">
	<div class="pageContent">
		<form method="post" action="SalaryItem/list" class="pageForm" onsubmit="return navTabSearch(this, 'salaryItem');">
			<div class="pageFormContent" layoutH="58">
<!-- 				<div> -->
<!-- 					<label>请输入检索条件：</label> -->
<!-- 					<input type="text" size="50" minlength="3" maxlength="10"/> -->
<!-- 				</div> -->
				<div class="divider">divider</div>
		        <div>
				<label>在薪资表中对应的列：</label>
				<input type="text" name="salaryColumn" value="${obj.o.salaryColumn}" size="25" />
				<span class="inputInfo">在薪资表中对应的列</span>
				</div>
		        <div>
				<label>工资账套：</label>
				<input type="text" name="accountId" value="${obj.o.accountId}" size="25" />
				<span class="inputInfo">工资账套</span>
				</div>
		        <div>
				<label>工资项目：</label>
				<input type="text" name="itemName" value="${obj.o.itemName}" size="25" />
				<span class="inputInfo">工资项目</span>
				</div>
		        <div>
				<label>项目类型：</label>
				<input type="text" name="itemType" value="${obj.o.itemType}" size="25" />
				<span class="inputInfo">项目类型</span>
				</div>
		        <div>
				<label>小数位数：</label>
				<input type="text" name="decimals" value="${obj.o.decimals}" size="25" />
				<span class="inputInfo">小数位数</span>
				</div>
		        <div>
				<label>舍位方式：</label>
				<input type="text" name="round" value="${obj.o.round}" size="25" />
				<span class="inputInfo">舍位方式</span>
				</div>
		        <div>
				<label>初始值：</label>
				<input type="text" name="initialValue" value="${obj.o.initialValue}" size="25" />
				<span class="inputInfo">初始值</span>
				</div>
		        <div>
				<label>显示公式：</label>
				<input type="text" name="displayFormular" value="${obj.o.displayFormular}" size="25" />
				<span class="inputInfo">显示公式</span>
				</div>
		        <div>
				<label>数据公式：</label>
				<input type="text" name="dbFormular" value="${obj.o.dbFormular}" size="25" />
				<span class="inputInfo">数据公式</span>
				</div>
		        <div>
				<label>描述：</label>
				<input type="text" name="description" value="${obj.o.description}" size="25" />
				<span class="inputInfo">描述</span>
				</div>
<%-- 			    <div>
					<label>创建人：</label>
					<input type="text" name="createUser" value="${obj.o.createUser}" size="25" />
					<span class="inputInfo">创建人</span>
					</div> --%>
<%-- 			    <div>
					<label>创建时间：</label>
					<input type="text" name="createDate" value="${obj.o.createDate}" size="25" />
					<span class="inputInfo">创建时间</span>
					</div> --%>
<%-- 			    <div>
					<label>修改人：</label>
					<input type="text" name="modifyUser" value="${obj.o.modifyUser}" size="25" />
					<span class="inputInfo">修改人</span>
					</div> --%>
<%-- 			    <div>
					<label>修改时间：</label>
					<input type="text" name="modifyDate" value="${obj.o.modifyDate}" size="25" />
					<span class="inputInfo">修改时间</span>
					</div> --%>
<!-- 				<div class="divider">divider</div> -->
<!-- 				<div> -->
<!-- 					<label>排序条件：</label> -->
<!-- 					<select> -->
<!-- 						<option>按客户号倒排</option> -->
<!-- 						<option>按建档日期倒排</option> -->
<!-- 						<option>按信用等级顺排</option> -->
<!-- 						<option>按客户号顺排</option> -->
<!-- 						<option>按建档日期顺排</option> -->
<!-- 						<option>按所属行业顺排</option> -->
<!-- 					</select> -->
<!-- 				</div> -->
			</div>
			<div class="formBar">
				<ul>
					<li><div class="buttonActive"><div class="buttonContent"><button type="submit">开始检索</button></div></div></li>
					<li><div class="button"><div class="buttonContent"><button type="reset">清空重输</button></div></div></li>
				</ul>
			</div>
		</form>
	</div>
</div>