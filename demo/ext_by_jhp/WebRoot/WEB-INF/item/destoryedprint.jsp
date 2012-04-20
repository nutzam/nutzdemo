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
		<div>

			<table border="0" cellpadding="0" cellspacing="0" width="900px">
				<tbody>
					<tr>
						<td colspan="9" style="text-align:center;border:none;">
							<span style= "border-bottom:1pt solid #000000;font-size:20px;">神华销售集团有限公司华北能源贸易分公司朔西办事处</span>
							<br /><br />
							<span style= "border-bottom:3pt double #000000;font-size:24px;"> 低值易耗品核销审批单</span>
							<br /><br />
							<span style= "font-size:18px;"><%=((Map) request.getAttribute("obj")).get("date")%></span>
						</td>
					</tr>
					<tr>
						<td height="28" colspan="9" style="border:none;">
							使用部门：<%=((Map) request.getAttribute("obj")).get("department")%></td>
					</tr>
					<tr style="text-align:center;">
						<td height="28" width="44">
							序号
						</td>
						<td width="116">
							名称
						</td>
						<td width="116">
							规格型号
						</td>
						<td width="70">
							单位
						</td>
						<td width="70">
							数量
						</td>
						<td width="70">
							单价
						</td>
						<td width="70">
							金额
						</td>
						<td width="120">
							核销原因
						</td>
						<td>
							现场查看情况
						</td>
					</tr>
					<%
						int index = 0;
						ArrayList<SummationItem> items = (ArrayList<SummationItem>) (((Map) request.getAttribute("obj")).get("destoryedItems"));
					
						for (SummationItem item : items) {
							if(index >= 8){//最多打印10项
								continue;
							}
					%>
					<tr style="text-align:center;">
						<td height="28"><%=++index%></td>
						<td><%=item.getName()%></td>
						<td><%=item.getVersion()%></td>
						<td>
							个
						</td>
						<td><%=item.getCount()%></td>
						<td><%=item.getPrice()%></td>
						<td><%=item.getSummation()%></td>
						<td><%=item.getDestroyreason()%></td>
						<td><%=item.getConditions()%></td>
					</tr>
					<%
						}
						while(index < 8){
					%>
						<tr style="text-align:center;">
							<td height="28"><%=++ index%></td>
							<td></td>
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
					<tr>
						<td colspan="2" height="108" style="text-align:center;">
							财务部门意见
						</td>
						<td colspan="4" width="322" style="text-align:center;">
						</td>
						<td width="81">
							资产使用部门意见
						</td>
						<td colspan="2">
						</td>
					</tr>
					<tr>
						<td colspan="2" height="108" width="169" style="text-align:center;">
							领导意见
						</td>
						<td colspan="4">
						</td>
						<td width="81" style="text-align:center;">
							资产管理部门意见
						</td>
						<td colspan="2">
						</td>
					</tr>
				</tbody>
			</table>

		</div>
	</body>
</html>