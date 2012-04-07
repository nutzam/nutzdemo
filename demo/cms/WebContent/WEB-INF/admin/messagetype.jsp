<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
  	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>留言模板</title>
    <style type="text/css">
    table tr td{
    line-height: 25px;
    width:120px;
    }
    </style>
    <%@include file="/common/common.jsp"%>
	<script type="text/javascript">
	var strm="";
	var list=null;
	//设置选项
	    $(document).ready(function(){					
	 	$("#dataform").submit(function(){
			$(this).ajaxSubmit({
				beforeSubmit:function(){
				},
				success:function(data){
				var o = eval("("+eval("("+data+")")+")");
					if(o.success){
						alert("设置成功！");
					}else{
					alert("设置失败！");
					}
				},
				url:"${ctx}/admin/messaget/update",
				type:'post'
			});
			return false;
		})
	 });
	//选项改变时间
	function changecheck(){
		var m=document.getElementById('mttype4').selectedIndex;
		if(list[m-1].isdisptitle){
		document.getElementById("isdisptitle").checked=true;
		}else{
		document.getElementById("isdisptitle").checked=false;
		}
		if(list[m-1].isdispvistor){
		document.getElementById("isdispvistor").checked=true;
		}else{
		document.getElementById("isdispvistor").checked=false;
		}
		if(list[m-1].isdispinsertTime){
		document.getElementById("isdispinsertTime").checked=true;
		}else{
		document.getElementById("isdispinsertTime").checked=false;
		}
		if(list[m-1].isdisptel){
		document.getElementById("isdisptel").checked=true;
		}else{
		document.getElementById("isdisptel").checked=false;
		}
		if(list[m-1].isdispphone){
		document.getElementById("isdispphone").checked=true;
		}else{
		document.getElementById("isdispphone").checked=false;
		}
		if(list[m-1].isdispemail){
		document.getElementById("isdispemail").checked=true;
		}else{
		document.getElementById("isdispemail").checked=false;
		}
		if(list[m-1].isdispcontent){
		document.getElementById("isdispcontent").checked=true;
		}else{
		document.getElementById("isdispcontent").checked=false;
		}
		if(list[m-1].replay){
		document.getElementById("replay").checked=true;
		}else{
		document.getElementById("replay").checked=false;
		}
		if(list[m-1].isdispreplayTime){
		document.getElementById("isdispreplayTime").checked=true;
		}else{
		document.getElementById("isdispreplayTime").checked=false;
		}
	}
	
	//添加
		function addtype(){
			var mtname=document.getElementById("mtname").value;
			var navid=document.getElementById("navid").value;
			if(mtname==""){
				alert("添加失败！请填写名称");
				return;
			}
			var url="${ctx}/admin/message/addmessagetype";
			$.post(url,{'mt.name':mtname,"mt.navid":navid},function(data){
			if(data!='null'&&data!=""){
				var message=eval("("+data+")");
				alert("添加成功！");
				showtype();
			}
			},"json");
		}
		//排序
		function updateSort(){
			var newid=document.getElementById("mttype1").value;
			var b=document.getElementById("mtsort").value-1;
			var size=list.length;
			if(list[b]!=undefined&&list[b]!='null'){
				var url="${ctx}/admin/message/updatesort";
				$.post(url,{'newid':newid,'oldid':list[b].id},function(data){
					if(data!='null'&&data!=""){
						var o=eval("("+data+")");
						if(o.success){
							alert("排序成功");
							showtype();
						}else{
							alert("排序失败");
						}
					}
				},'json');
			}
		}
		//查询所有类型
		function showtype(){
		strm="";
			var url="${ctx}/admin/message/selecttype";
			$.post(url,null,function(data){
				if(data!=""&&data!='null'){
				list=eval("("+data+")");
				if(list!='null'&&list.length>0){
				for(var i=0;i<list.length;i++){
					strm+="<option value='"+list[i].id+"'>"+list[i].name+"</option>";
					}
					document.getElementById("mestname").value=list[0].name;
					makeselect(strm);
					}
				}
			},"json");
		}
		//将类型输出到页面
		function makeselect(str){
			var tb=$('#mttype1');
			var tb1=$('#mttype2');
			var tb2=$('#mttype3');
			var tb3=$('#mttype4');
			tb1.empty();
			tb.empty();
			tb2.empty();
			tb3.empty();
			tb.append(str);
			tb1.append(str);
			tb2.append(str);
			tb3.append("<option value=''>请选择</option>"+str);
		}
		//删除类型
		function dele(){
		if(!window.confirm("你确定要删除该项类型？删除将导致该项类型下的所有留言全部删除！")){
		return;
		}
			var id=document.getElementById("mttype3").value;
			var url="${ctx}/admin/message/deletype";
			$.post(url,{'id':id},function(data){
				if(data!='null'&&data!=""){
					var data=eval("("+data+")");
				
					if(data.success){
						alert("删除成功");
						showtype();
					}else{
						alert("删除失败");
					}
				}
			},'json');
		}
		//修改类型名称
		function update(){
			var name=document.getElementById("mestname").value;
			var id=document.getElementById("mttype2").value;
			var url="${ctx}/admin/message/update";
			$.post(url,{'mest.name':name,'mest.id':id},function(data){
				if(data){
					alert("修改成功");
					showtype();
				}else{
					alert("修改失败");
				}
			},'json');
		}
		//修改类型名称的onchange时间
		function changetype(){
			var name=document.getElementById('mttype2').options[document.getElementById('mttype2').selectedIndex].text;  
			document.getElementById("mestname").value=name;
			
		}
		
		function showall(){
			showtype();
			shownav();
		}
		
					function shownav(){
				var navurl = "${ctx}/admin/navmodel/json";
				$.post(navurl,null,function(data){
					var o = eval("("+data+")");
					var str = process(o[0],'');
					$("#navid").append(str);
				},'json');
			}
/**
 * 设置导航数据显示的样式
 * @param {Object} o
 * @param str
 */
function process(o,str){
	var option="<option value='"+o.id+"'>"+str+o.text+"</option>";
	if(o.children){
		$(o.children).each(function(){
			option += process(this,str+"--");
		});
	}
	return option;
}
	</script>
  </head>
  
  <body onload="showall();" style="background-image: none;">
   	留言类型添加：类型名称:<input type="text" name="mt.name" id="mtname">&nbsp;&nbsp;&nbsp;所属导航<select id="navid" name="mt.navid"></select>&nbsp;&nbsp;&nbsp;<input style="margin-left:140px" type="button" value="添加" onclick="addtype()">
   	<br/><br/>
	类型显示排序：类型名称:<select name="mttype1" id="mttype1"></select>&nbsp;&nbsp;&nbsp;&nbsp; 排序编号<input type="text" name="mt.sort" id="mtsort">
	<input type="button" value="确定" onclick="updateSort()">&nbsp;&nbsp;&nbsp;&nbsp;(填写的数字在1和最大类型数之间)
  	<br/><br/>
 	修改类型:类型名称:<select name="mttype2" id="mttype2" onchange="changetype()"></select><input style="margin-left:60px;" type="text" id="mestname"><input type="button" value="确认修改" onclick="update()"/>
  	<br/><br/>
  	删除类型:类型名称:<select name="mttype3" id="mttype3"></select><input style="margin-left:60px;" type="button" value="删除" onclick="dele()"/>
 	
 <br/>
 <br/> <br/> <br/> <br/>
 <form id="dataform">
 <table border="3">
 	<tr><td style="width:200px;line-height:35px" colspan="3">管理员设置用户留言字段</td><td colspan="3">选择类型:<select name="mest.id" id="mttype4" onchange="changecheck()"></select></td></tr>
 	<tr><td>是否显示标题</td><td><input type="checkbox" id="isdisptitle" name="mest.isdisptitle" value="true"></td><td>是否显示留言人</td><td><input type="checkbox" id="isdispvistor" name="mest.isdispvistor" value="true"></td><td>是否显示留言时间</td><td><input type="checkbox" id="isdispinsertTime" name="mest.isdispinsertTime" value="true"></td></tr>
 	<tr><td>是否显示留言者手机 </td><td><input type="checkbox" id="isdisptel" name="mest.isdisptel" value="true"></td><td>是否显示座机号码</td><td><input type="checkbox" id="isdispphone" name="mest.isdispphone" value="true"></td><td>是否显示留言者email</td><td><input type="checkbox" name="mest.isdispemail" id="isdispemail" value="true"></td></tr>
 	<tr><td>是否显示留言内容</td><td><input type="checkbox" id="isdispcontent" name="mest.isdispcontent" value="true"></td><td>是否需要回复</td><td><input type="checkbox" id="replay" name="mest.replay" value="true"></td><td>是否显示回复时间</td><td><input type="checkbox" id="isdispreplayTime" name="mest.isdispreplayTime" value="true"></td></tr>
 	<tr style="text-align: right;"><td  colspan="6" ><input type="submit" value="提交"></td></tr>
 </table>
 </form>
  </body>
</html>
