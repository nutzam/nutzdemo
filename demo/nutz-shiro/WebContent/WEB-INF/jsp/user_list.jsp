<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme() + "://"
      + request.getServerName() + ":" + request.getServerPort()
      + path + "/";
%>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户管理</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<style>
body {
	padding-top: 60px;
	/* 60px to make the container go all the way to the bottom of the topbar */
}
</style>
<link href="css/bootstrap-responsive.min.css" rel="stylesheet">
<link rel="shortcut icon" href="ico/favicon.ico">
<link rel="apple-touch-icon-precomposed" sizes="114x114" href="ico/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72" href="ico/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed" href="ico/apple-touch-icon-57-precomposed.png">
</head>
<body>
  <div class="navbar navbar-fixed-top">
    <div class="navbar-inner">
      <div class="container">
        <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
        </a>
      </div>
    </div>
  </div>
  <div class="container">
  <ul class="breadcrumb">
    <li class="active">用户管理</li>
  </ul>
  <shiro:hasPermission name="user:create">
    <a href="${base}/admin/usr/p_add" class="btn btn-primary">添加新用户</a><br/>
  </shiro:hasPermission>
  <table class="table table-striped">
    <thead>
    <tr>
        <th>账户</th>
        <th>性别</th>
        <th>备注</th>
        <th>编辑</th>
        <th>删除</th>
      </tr>
    </thead>
    <c:forEach var="user" items="${obj}">
      <tr>
        <td><a href="${base}/admin/usr/view?id=${user.id}">${user.name}</a></td>
        <td>${user.username}</td>
        <td>${user.department}</td>
        <td><a href="${base}/admin/usr/view?id=${user.id}"><i class="icon-edit"></i>&nbsp;${msg.edit}</a></td>
        <td><a href="${base}/admin/usr/delete?id=${user.id}"><i class="icon-remove"></i>&nbsp;${msg.delete}</a></td>
      </tr>
    </c:forEach>
  </table>
  </div>
  <script src="${base}/js/jquery-1.7.2.js"></script>
  <script src="${base}/js/bootstrap.min.js"></script>
</body>
</html>