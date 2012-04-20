<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.Map,java.util.ArrayList,yhp.bean.Item"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
		<style type="text/css">
*{
padding:0;
margin:0;
}
		table th,table td {
			font-family:'华文新魏';
			font-size:12px;
			padding-top: 3px;
		}
		</style>
	</head>
	<body>

		<div align="left">

			<table border="0" cellpadding="0" cellspacing="0" width=250>
				<tr>
					<td colspan="4" style="text-align: center;font-family:'宋体';">
						<u>神华朔西办事处低值易耗品标签</u>
					</td>
				</tr>
				<tr>
					<td>资产编号:</td>
					<td><%=((Item)request.getAttribute("obj")).getId() %></td>
					<td>资产名称:</td>
					<td><%=((Item)request.getAttribute("obj")).getName() %></td>
				</tr>
				<tr>
					<td>使用科站:</td>
					<td><%=((Item)request.getAttribute("obj")).getDepartment() %></td>
					<td>规格型号:</td>
					<td><%=((Item)request.getAttribute("obj")).getVersion() %></td>
				</tr>
				<tr>
					<td>资产金额:</td>
					<td><%=((Item)request.getAttribute("obj")).getPrice() %></td>
					<td>存放地点:</td>
					<td><%=((Item)request.getAttribute("obj")).getPlace() %></td>
				</tr>
				<tr>
					<td>负  责  人:</td>
					<td><%=((Item)request.getAttribute("obj")).getPrincipal() %></td>
					<td>使  用  人:</td>
					<td><%=((Item)request.getAttribute("obj")).getUser() %></td>
				</tr>
			</table>

		</div>
	</body>
</html>