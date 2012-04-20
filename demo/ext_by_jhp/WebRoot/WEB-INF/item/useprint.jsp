<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.Map,java.util.ArrayList,yhp.bean.SummationItem"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
		<style type="text/css">
		*{
			padding:0;
			marging:0;
			font-size:14pt;
		}
		
		body{
			padding-top:100px;
		}
		table {
			border-collapse:collapse; 
		}
		table th,table td {
			border: solid #000;
			border-width: 1px;
			padding: 2px;
		}
		</style>
	</head>
	<body>

		<div align="center">

			<table border="0" cellpadding="0" cellspacing="0" width="900px">
				<tr>
						<td colspan="9" style="text-align:center;border:none;">
							<span style= "border-bottom:1pt solid #000000;font-size:20pt;">神华销售集团有限公司华北能源贸易分公司朔西办事处</span>
							<br /><br />
							<span style= "border-bottom:3pt double #000000;font-size:24.0pt;">低值易耗品出库单</span>
							<br /><br />
							<span style= "font-size:18.0pt;"><%=((Map) request.getAttribute("obj")).get("date")%></span>
						</td>
				</tr>
				<tr>
					<td height="32" colspan="8" style="border:none;text-align:left;">
						使用部门：<%=((Map) request.getAttribute("obj")).get("department")%>
					</td>
				</tr>
				<tr  style="text-align:center;">
					<td height="32" width="44">
						序号
					</td>
					<td>
						名称
					</td>
					<td>
						规格型号
					</td>
					<td>
						单位
					</td>
					<td>
						数量
					</td>
					<td>
						单价
					</td>
					<td>
						金额
					</td>
					<td>
						备注
					</td>
				</tr>
				<%
					int index = 0;
					ArrayList<SummationItem> items = (ArrayList<SummationItem>) (((Map) request.getAttribute("obj")).get("useItems"));
					
					for (SummationItem item : items) {
					if(index >= 10){//最多打印10项
						continue;
					}
				%>
				<tr height="32" style="text-align:center;">
					<td height="32"><%=++ index%></td>
					<td><%=item.getName()%></td>
					<td><%=item.getVersion()%></td>
					<td>
					</td>
					<td><%=item.getCount()%></td>
					<td><%=item.getPrice()%></td>
					<td><%=item.getSummation()%></td>
					<td><%=item.getComment()%></td>
				</tr>
				<%
					}
					while(index < 10){
				%>
					<tr style="text-align:center;">
						<td height="52"><%=++ index%></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
				<%
					}
				%>
				<tr style="text-align:center;">
					<td colspan="2" height="52">
						合计
					</td>
					<td>
					</td>
					<td>
					</td>
					<td><%=((Map) request.getAttribute("obj")).get("total")%>
					</td>
					<td>
					</td>
					<td><%=((Map) request.getAttribute("obj")).get("sum")%>
					</td>
					<td>
					</td>
				</tr>
				<tr>
					<td colspan="2" height="52" style="border:none;">
						单位领导:
					</td>
					<td style="border:none;">
						保管人:
					</td>
					<td colspan="3" style="border:none;">
						部门负责人:
					</td>
					<td colspan="2" style="border:none;">
						领用人:
					</td>
				</tr>
			</table>

		</div>
	</body>
</html>