<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="page">
	<div class="pageContent">
		<form method="post" action="RevenueInfoSet/list" class="pageForm" onsubmit="return navTabSearch(this, 'revenueInfoSet');">
			<div class="pageFormContent" layoutH="58">
<!-- 				<div> -->
<!-- 					<label>请输入检索条件：</label> -->
<!-- 					<input type="text" size="50" minlength="3" maxlength="10"/> -->
<!-- 				</div> -->
				<div class="divider">divider</div>
		        <div>
				<label>级别号：</label>
				<input type="text" name="rank" value="${obj.o.rank}" size="25" />
				<span class="inputInfo">级别号</span>
				</div>
		        <div>
				<label>起始额：</label>
				<input type="text" name="startingForehead" value="${obj.o.startingForehead}" size="25" />
				<span class="inputInfo">起始额</span>
				</div>
		        <div>
				<label>结束额：</label>
				<input type="text" name="endForehead" value="${obj.o.endForehead}" size="25" />
				<span class="inputInfo">结束额</span>
				</div>
		        <div>
				<label>税率：</label>
				<input type="text" name="taxRate" value="${obj.o.taxRate}" size="25" />
				<span class="inputInfo">税率</span>
				</div>
<%-- 			    <div>
					<label>修改时间：</label>
					<input type="text" name="modifyDate" value="${obj.o.modifyDate}" size="25" />
					<span class="inputInfo">修改时间</span>
					</div> --%>
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
		        <div>
				<label>速算扣除数：</label>
				<input type="text" name="qcd" value="${obj.o.qcd}" size="25" />
				<span class="inputInfo">速算扣除数</span>
				</div>
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