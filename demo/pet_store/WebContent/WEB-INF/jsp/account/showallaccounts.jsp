<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Show all accounts</title>
<link type="text/css" href="themes/base/ui.all.css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/json2.js"></script>
<script type="text/javascript" src="ui/ui.core.js"></script>
<script type="text/javascript" src="ui/ui.draggable.js"></script>
<script type="text/javascript" src="ui/ui.resizable.js"></script>
<script type="text/javascript" src="ui/ui.dialog.js"></script>
<script type="text/javascript" src="ui/effects.core.js"></script>
<script type="text/javascript" src="ui/effects.highlight.js"></script>
<script type="text/javascript" src="external/bgiframe/jquery.bgiframe.js"></script>
<style type="text/css">
	body { font-size: 62.5%; }
	label font{color:red;}
	label, input { display:block; }
	input.text { margin-bottom:12px; width:95%; padding: .4em; }
	fieldset { padding:0; border:0; margin-top:25px; }
	h1 { font-size: 1.2em; margin: .6em 0; }
	div#users-contain {  width: 100%; margin: 20px 0; }
	div#users-contain table { margin: 1em 0; border-collapse: collapse; width: 100%; }
	div#users-contain table td, div#users-contain table th { border: 1px solid #eee; padding: .6em 10px; text-align: left; }
	.ui-button { outline: 0; margin:0; padding: .4em 1em .5em; text-decoration:none;  !important; cursor:pointer; position: relative; text-align: center; }
	.ui-dialog .ui-state-highlight, .ui-dialog .ui-state-error { padding: .3em;  }
	.errordialog{ text-align: center; width:100%;}
	.errormessage{ color:red;}
</style>
<script type="text/javascript" src="js/account/showallaccounts.js"></script>
<script type="text/javascript">
//$(document).ready()
$(function() {
	showAllAccounts.onLoadEvent();
});
</script>
</head>
<body>
<div id="error_message" title="Error" class="errordialog">
	<p>
		<span class="errormessage"></span>
	</p>
</div>

<div id="dialog" title="Create new user">
	<p id="validateTips">All form fields are required.</p>

	<form>
	<fieldset>
		<label for="userid">User ID <font>*</font></label>
		<input type="text" name="userid" id="userid" class="text ui-widget-content ui-corner-all" />
		<label for="password">Password <font>*</font></label>
		<input type="password" name="password" id="password" value="" class="text ui-widget-content ui-corner-all" />
		<label for="firstname">First Name <font>*</font></label>
		<input type="text" name="firstname" id="firstname" value="" class="text ui-widget-content ui-corner-all" />
		<label for="lastname">Last Name <font>*</font></label>
		<input type="text" name="lastname" id="lastname" value="" class="text ui-widget-content ui-corner-all" />
		<label for="phone">Phone <font>*</font></label>
		<input type="text" name="phone" id="phone" value="" class="text ui-widget-content ui-corner-all" />
		<label for="email">Email <font>*</font></label>
		<input type="text" name="email" id="email" value="" class="text ui-widget-content ui-corner-all" />
		<label for="address1">Address 1 <font>*</font></label>
		<input type="text" name="address1" id="address1" value="" class="text ui-widget-content ui-corner-all" />
		<label for="address2">Address 2</label>
		<input type="text" name="address2" id="address2" value="" class="text ui-widget-content ui-corner-all" />
		<label for="city">City <font>*</font></label>
		<input type="text" name="city" id="city" value="" class="text ui-widget-content ui-corner-all" />
		<label for="state">State <font>*</font></label>
		<input type="text" name="state" id="state" value="" class="text ui-widget-content ui-corner-all" />
		<label for="zip">Zip <font>*</font></label>
		<input type="text" name="zip" id="zip" value="" class="text ui-widget-content ui-corner-all" />
		<label for="country">Country <font>*</font></label>
		<input type="text" name="country" id="country" value="" class="text ui-widget-content ui-corner-all" />
	</fieldset>
	</form>
</div>

<div id="users-contain" class="ui-widget user-div">

		<h1>Existing Users:</h1>

<table id="users" class="ui-widget ui-widget-content">
	<thead>
		<tr class="ui-widget-header ">
			<td><input type="checkbox" id="check_all" /></td>
			<td>User ID</td>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email Addreass</th>
			<th>Phone</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="account" items="${accounts}">
			<tr>
				<td><input type="checkbox" value="${account.userid}"/></td>
				<td><a href="javascript:void(0);" class="userid">${account.userid}</a></td>
				<td>${account.firstName}</td>
				<td>${account.lastName}</td>
				<td>${account.email}</td>
				<td>${account.phone}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</div>
<button id="create-user" class="ui-button ui-state-default ui-corner-all">Create new user</button>
<button id="delete-user" class="ui-button ui-state-default ui-corner-all">Delete user</button>
</body>
</html>