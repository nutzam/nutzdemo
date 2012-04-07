/**
 * 生成头部文件
 */
function nav(prefix){
	if(!window.confirm("你确定要生成静态页面吗？如果操作错误，可能导致网站无法访问！")){
		return;
	}
	var template = $("#templete2").val();
	if(template==0){
		alert("请先选择模板");
		$("#templete2").focus();
		return;
	}
	var position = $("#position").val();
	
	if(position==0){
		alert("请选择生成页面的名称");
		$("#position").focus();
		return;
	}
	
	var url = prefix+"/admin/nav/top";
	$.post(url,{template:template,position:position},function(data){
		
		data = eval("("+data+")");
		
		if(data.success){
			alert("生成文件成功");
		}else{
			alert("生成文件失败");
		}
	},'json')
}
function load(prefix){
	//文章详细模版信息
	var templateurl = prefix+"/admin/templete/bytype";
	$.post(templateurl,{type:9},function(data){
		var o = eval("("+data+")");
		$(o).each(function(){
			$("#templete").append("<option value='"+this.id+"'>"+this.templeteName+"</option>");
		});
		$(o).each(function(){
			$("#templete2").append("<option value='"+this.id+"'>"+this.templeteName+"</option>");
		});
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
/**
 * 添加导航菜单数据
 */
function addNav(prefix){
	
	var id = $.trim($("#id").val());
	
	var pid = $.trim($("#pid").val());
	
	var navname = $.trim($("#navname").val());
	
	var sortNumber = $.trim($("#sortNumber").val());
	
	if(sortNumber<=0||sortNumber>1000||!(/^\d{1,3}$/.test(sortNumber))){
		alert("排序号输入错误，请输入1-999的数字");
		return;
	}
	
	var navurl = $.trim($("#url").val());
	
	var templete = $.trim($("#templete").val());
	
	var indexNav = document.getElementById("indexNav").checked;
	
	var showNav =  document.getElementById("showNav").checked;
	
	var url = prefix+"/admin/navmodel/add";
	
	$.post(url,{"nav.id":id,"nav.navName":navname,"nav.pid":pid,"nav.sortNumber":sortNumber,"nav.url":navurl,"nav.tid":templete,"nav.indexNav":indexNav,"nav.showNav":showNav},function(data){
		var o = eval("("+data+")");
		if(o.id!="undefined"){
			
			$("#id").val(0);
			//$("#pid").val(0);
			$("#navname").val("");
			$("#sortNumber").val("");
			$("#url").val("");
			$("#templete").val(0);
			alert("添加成功，刷新导航后可以看到新添加的导航");
		}else{
			alert("数据添加失败！");
		}
		
	},'json');
	
}
/**
 * 删除数据
 * @param {Object} prefix
 */
function del(prefix){
	
	var id = $.trim($("#pid").val());
	
	if(id==0){
		alert("请先选择一个分类信息");
		return;
	}
	
	if(!window.confirm("你确定要删除选中的这条信息吗？")){
		return;
	}
	
	var url = prefix+"/admin/navmodel/del";
	
	$.post(url,{id:id},function(data){
		var o = eval("("+data+")");
		if(o.success){
			$("#"+id).remove();
			alert("删除导航成功");
		}else{
			alert("操作导航失败");
		}
	},'json');
	
	
}