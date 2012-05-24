<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="/WEB-INF/tld/c.tld"%>
<c:set var="dataSources" value="${obj}"></c:set>
<html>
<head>
	<title>帐号管理</title>
	<script>
		$(document).ready(function() {
			//聚焦第一个输入框
			$("#druid-tab").addClass("active");
		});
	</script>
</head>

<body>
	
	<h4>数据源列表</h4>
	<c:if test="${not empty message}">
		<div id="message" class="alert alert-success"><button data-dismiss="alert" class="close">×</button>${message}</div>
	</c:if>
	
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead><tr><th>URL</th><th>DbType</th><th>正在打开连接数</th><th>逻辑打开</th><th>逻辑关闭<th>物理打开</th><th>物理关闭</th></tr></thead>
		<tbody>
		<c:forEach items="${dataSources}" var="dataSource">
			<tr>
				<td>${dataSource.url}</td>
				<td>${dataSource.dbType}</td>
				<td>${dataSource.activeCount}</td>
				<td>${dataSource.connectCount}</td>
				<td>${dataSource.closeCount}</td>
				<td>${dataSource.createCount}</td>
				<td>${dataSource.destroyCount}</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	
	<h4>SQL列表</h4>
	<c:if test="${not empty message}">
		<div id="message" class="alert alert-success"><button data-dismiss="alert" class="close">×</button>${message}</div>
	</c:if>

<c:forEach items="${dataSources}" var="dataSource">	
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead><tr>
			<th>SQL</th>
			<th>ExecuteCount</th>
			<th>FetchRowCount</th>
			<th>ExecuteMillisTotal</th>
			<th>ResultSetHoldTime</th>
		</tr></thead>
		<tbody>
			<c:forEach items="${dataSource.dataSourceStat.sqlStatMap}" var="entry">
			<tr>
				<td>${entry.key}</td>
				<td>${entry.value.executeCount}</td>
				<td>${entry.value.fetchRowCount}</td>
				<td>${entry.value.executeMillisTotal}</td>
				<td>${entry.value.resultSetHoldTimeMilis}</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</c:forEach>
</body>
</html>