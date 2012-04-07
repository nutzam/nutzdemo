
//查询导航信息
function findmodel(dizhi){
	
	//var url = dizhi+"/admin/onearticle/findnav";
	var navurl = dizhi+"/admin/navmodel/json";
	$.post(navurl,null,function(data){
		var o = eval("("+data+")");
		var str = process(o[0],'');
		$("#modelid").append(str);
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
//添加
function add(dizhi){
	var title = $.trim($("#title").val());
	var filepath = $("#filepath").val();
	
	if(title == ""){
		alert("对不起，请填入资源名称！");
		document.getElementById("title").focus();
		return ;
		
	}
	if(filepath ==""){
		alert("对不起，资源不能为空！");
		return;
		
	}
	var filepath = $("#filepath").val();
	var modelid = $("#modelid").val();
	var id = $("#downloadid").val();
	var filepathimage = $("#filepathimage").val();
	var url = dizhi+"/admin/download/add";
	$.post(url,{"download.title":title,"download.id":id,"download.url":filepath,"download.modelid":modelid,"download.imageurl":filepathimage},function(data){
		
		var o = eval("("+data+")");
		if(o[0].success){
			
		alert("添加成功！");
			$("#filepath").val()=="";
			$("#filepathimage").val()=="";
			
		}else{
			alert("添加失败！");
		}
		
	},'json');
	
}
//删除一条数据
function del(dizhi,id){
		if(confirm("您确定要删除这条数据吗？")){
		
		var args = location.search;   
    	var reg = new RegExp('[\?&]?currentPage=([^&]*)[&$]?', 'gi');   
    	var chk = args.match(reg);   
   		var currentPage = RegExp.$1; 
   	
   		var arr = new Array();
   		arr[0] = $("#r"+id);
   	
		var url=dizhi+"/admin/download/del";
		
		$.post(url,{"id":id,"currentPage":currentPage},function(data){
		
		var o = eval("("+data+")");
		
		processRemove(arr,o,dizhi);
		
	},'json');
		
	}
}
/*
 * 根据多个id删除数据
 * @param {Object} prefix
 */
function delByIds(prefix){
	
	var args = location.search;   
    var reg = new RegExp('[\?&]?currentPage=([^&]*)[&$]?', 'gi');   
    var chk = args.match(reg);   
   	var currentPage = RegExp.$1; 
   	
	var str="";
	
	var i=0;
	
	var arr = new Array();
	
	$("input[type='checkbox']").each(function(){
		if($(this).attr("checked")){
			if($(this).val()!="on" && this.name=='luo'){
				str += $(this).val()+",";
				arr[i] = $(this).parent().parent();
				i++;
			}
		}
	});
	
	if(!window.confirm("你确定要删除"+i+"条数据吗？删除后不可恢复！")){
		return;
	}
	
	var dot = str.lastIndexOf(",");
	if(dot==-1){
		alert("请先选择要删除的选项");
		return;
	}else{
		str = str.substring(0,dot);
	}
	
	var url=prefix+"/admin/download/delByIds";
	
	$.post(url,{"ids":str,"currentPage":currentPage,"size":i},function(data){
		
		var o = eval("("+data+")");
		
		processRemove(arr,o,prefix);
		
	},'json');
	
}
/**
 * 处理删除数据的界面显示
 * @param {Object} arr
 * @param {Object} o
 * @memberOf {TypeName} 
 */
function processRemove(arr,o,dizhi){
	
	//在界面上删除那些选中的内容
			$(arr).each(function(){
				$(this).remove();
			});
			//获取剩下的所有tr
			var i=1;
			$("#datalist").find("tr").each(function(){
				//获取所有的td 并重新 给第二个td赋值
				var td = $(this).find("td").slice(1,2);
				$(td).html(i);
				i++;
			});
		
		if(o.length>0){
			for(var j=0;j<o.length;j++){		
				var onearticle = o[j];
				var tr = "<tr>" +
							"<td><input type='checkbox' value='"+onearticle.id+"'></td>" +
							"<td>"+i+"</td>" +
							"<td>"+onearticle.title+"</td>" +
							"<td>"+
								"<a href=\"javascript:del('"+dizhi+"',"+onearticle.id+");\" title='删除资源信息'><img src='"+dizhi+"/images/icons/cross.png' alt='删除资源信息' /></a>"+
								//"<a href=\"javascript:editType('"+dizhi+"',"+onearticle.id+");\" title='修改资源信息'><img src='"+dizhi+"/images/icons/hammer_screwdriver.png' alt='修改资源信息' /></a>"+
							"</td>"+
						 "</tr>";
			
				$("#datalist").append(tr);
				i++;
			}
			
		}
}