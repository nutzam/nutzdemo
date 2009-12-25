<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="/WEB-INF/tld/c.tld" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="${base}/css/ext-all.css" />
<link type="text/css" rel="stylesheet" href="${base}/css/hello.css" />
<script type="text/javascript" src="${base}/amchart/swfobject.js"></script>
<script type="text/javascript" src="${base }/js/ext-all.js"></script>
<script type="text/javascript">
	var paid = function(id){
		Ext.Ajax.request({
			url:'${base}/good/paid/'+id+'.nut',
			success:function(){
				Ext.MessageBox.alert('提示','购买成功！');
			}
		});
	}
	var back = function(id){
		Ext.Ajax.request({
			url:'${base}/good/back/'+id+'.nut',
			success:function(){
				Ext.MessageBox.alert('提示','返回成功！');
			}
		});
	}
	var viewed = function(id){
		Ext.Ajax.request({
			url:'${base}/good/viewed/'+id+'.nut',
			success:function(){
				Ext.MessageBox.alert('提示','查看成功！');
			}
		});
	}
	var amchart = function(title,command,url){
		var win = new Ext.Window({
			title:title,
			width:700,
			height:500,
			buttonAlign:'center',
			buttons:[{text:'关闭',handler:function(){win.close();}}],
			autoLoad:{url:url,params:{command:command},scripts:true}
		});
		win.show();
	}
	var analyse = function(name,id){
		amchart(name+'-情况分析',id,'${base}/jsp/good/ampie.jsp');
	}
	
	var top10 = function(){
		amchart('前10对比','top10','${base}/jsp/good/amchart.jsp');
	}
	var bottom10 = function(){
		amchart('后10对比','bottom10','${base}/jsp/good/amchart.jsp');
	}
	
</script>
<title>商品列表</title>
</head>
<body>
	<table>
		<tr>
		<c:forEach var="good" items="${obj}" varStatus="status">
				<td>
					<table  height="260" width="260" border="0" cellpadding="0" cellspacing="1">
					  <tr>
					    <td><img src="${base }${good.imgUrl }"/></td>
					  </tr>
					  <tr>
					    <td height="20">${good.name}</td>
					  </tr>
					  <tr>
					  <!-- 
					    <td height="20">已购：${good.paidCount}　查看：${good.viewedCount}　返回：${good.backCount}</td>
					   -->
					    <td height="20"><a href="#" onclick="analyse('${good.name}','${good.id}')">情况分析</a></td>
					  </tr>
					  <tr>
					    <td height="50" valign="top">${good.detailed }</td>
					  </tr>
					  <tr>
					     <td height="40">
					     	<button onclick="paid(${good.id})">模拟购买</button>
					     	<button onclick="viewed(${good.id})">模拟查看</button>
					     	<button onclick="back(${good.id})">模拟返回</button>
					     </td>
					  </tr>
					</table>
				</td>
			<c:if test="${(status.index+1)%3==0}">
				</tr><tr>
			</c:if>
		</c:forEach>
		</tr>
	</table>
	<div style="right: 20px; width: 200px; position: absolute; top: 17px;">
     	<button onclick="top10()">购买前10对比</button>
     	<button onclick="bottom10()">购买后10对比</button>
	</div>
</body>
</html>