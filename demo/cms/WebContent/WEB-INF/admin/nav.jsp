<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>    
    <title>网站导航设置</title>   
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<link href="${ctx}/css/tree.css"  type="text/css" rel="stylesheet"/>
	<script type="text/javascript" src="${ctx}/script/jquery.js"></script>
	<script type="text/javascript" src="${ctx}/script/jquery.simple.tree.self.js"></script>
	<script type="text/javascript" src="${ctx}/script/nav.js"></script>
	<style type="text/css">
		.container{
			width: 1000px;
			height: 100%;
		}
		.left{
			width: 600px;
			height: 600px;
			float: left;
		}
		.right{
			width: 400px;
			height: 600px;
			float: left;
		}
	</style>
	<script type="text/javascript">
var g_node = null;	
$(document).ready(function(){
	$('.simpleTree').simpleTree({
		url:'${ctx}/admin/navmodel/json',
		dataType:'json',
		autoclose: true,
		animate:true,
		drag:true,
		afterClick:function(node){
			$("#pid").val(node.id);
			$("#parentname").val(node.text);
			$("#url").val('');
			$("#templete").val(0);
			$("#sortNumber").val('');
			$("#id").val(0);
			$("#navname").val('');
			document.getElementById("indexNav").checked = false;
			document.getElementById("showNav").checked = false;
			g_node = node;
		},
		afterDblClick:function(node){
			//alert("text-"+$('span:first',node).text());
		},
		afterMove:function(destination, source, pos){
			var target = destination.attr('id');
			var source = source.attr('id');
			if(!window.confirm("你确定要修改，你拖动菜单的分类吗？")){
				return ;
			}
			$.post('${ctx}/admin/navmodel/update',{id:source,pid:target},function(data){
				var o = eval("("+data+")");
				if(!o.success){
					alert("修改失败");
				}
			},'json');
		},
		afterAjax:function()
		{
			//alert('Loaded');
		}
	});
	
	load('${ctx}');
});
	function reset(){
		$("#pid").val(0);
		$("#parentname").val("");
		document.getElementById("indexNav").checked = false;
		document.getElementById("showNav").checked = false;
	}
	function modify(){
		reset();
		$("#id").val(g_node.id);
		$("#navname").val(g_node.text);
		if(g_node.attributes){
			$("#sortNumber").val(g_node.attributes.sortNumber);
			document.getElementById("indexNav").checked= g_node.attributes.indexNav;
			document.getElementById("showNav").checked = g_node.attributes.showNav;
			if(g_node.attributes.url=='null'){
				$("#url").val('');
			}else{
				$("#url").val(g_node.attributes.url);
			}
			$("#templete").val(g_node.attributes.tid);
		}
	}
	</script>
  </head>  
  <body>
		<div class="container">
			<div class="left">
				<!-- 树显示区域 -->
				<ul id="tree" class="simpleTree">

				</ul>
			</div>
			<div class="right">
				<form action="">
					<input type="hidden" name="id" id="id" value="0"/>
					<input type="hidden" name="pid" id="pid" value="0"/>
					<label for="navName" title="网站父导航菜单的名称">父级导航</label>
					<input type="text" name="parentName" title="网站父导航菜单的名称" id="parentname" readonly="readonly"/>
					<input type="button" value="清空" onclick="reset();">
					<input type="button" value="删除" onclick="del('${ctx}');">
					<input type="button" value="修改" onclick="modify();">
					<br/>
					<label for="navName" title="网站导航菜单的名称">导航名称</label>
					<input type="text" name="navName" title="网站导航菜单的名称" id="navname"/>
					<br/>
					<label for="sortNumber" title="网站导航排列顺序，数字越大越靠前">排列顺序</label>
					<input type="text" name="sortNumber" title="网站导航排列顺序，数字越大越靠前" id="sortNumber">
					<br/>
					<label for="sortNumber" title="网站导航链接地址，父导航可以不填写">链接地址</label>
					<input type="text" name="url" title="网站导航链接地址，父导航可以不填写" id="url"/>
					<br/>
					<label for="sortNumber">是否为首页</label>
					<input type="checkbox" name="indexNav" title="网站首页有且只有一个" id="indexNav" value="true"/>是
					<br/>
					<label for="sortNumber">是否显示导航</label>
					<input type="checkbox" name="showNav" title="网站首页有且只有一个" id="showNav" value="true"/>不显示
					<br/>
					<label for="templete" title="导航显示的文章的模版样式">导航模版</label>
					<select name="templete" title="导航显示的文章的模版样式" id="templete">
						<option value="0">----请选择----</option>
					</select>
					<br/>
					<input type="button" value="保存" onclick="addNav('${ctx}')"/>
				</form>
				<div>
					<select name="templete2" id="templete2" title="导航显示的文章的模版样式" id="templete">
						<option value="0">----请选择----</option>
					</select>
					<select name="position" id="position" title="选择生成页面的名称">
						<option value="0">-----请选择------</option>
						<option value="top">头部导航</option>
						<option value="left">所有导航</option>
						<option value="right">右边数据</option>
					</select>
					<input type="button" value="生成导航" onclick="nav('${ctx}');">
				</div>
			</div>
		</div>
  </body>
</html>
