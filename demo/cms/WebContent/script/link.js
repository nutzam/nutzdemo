//添加
function add(dizhi){
	var name = $.trim($("#name").val());
	var filepath = $("#filepath").val();
	
	if(name == ""){
		alert("对不起，请填入友情链接名称！");
		document.getElementById("name").focus();
		return ;
		
	}
	if(!isValidateUrl(filepath)){
		//alert("对不起，友情列举地址不能为空！");
		return;
		
	}
	var filepath = $("#filepath").val();
	var type = $("#type").val();
	var id = $("#linkid").val();
	var filepath = $("#filepath").val();
	var url = dizhi+"/admin/link/add";
	$.post(url,{"link.name":name,"link.url":filepath,"link.type":type,"link.id":id},function(data){
		
		var o = eval("("+data+")");
		if(o[0].success){

			alert("操作成功！");
			document.getElementById("filepath").value="";
			document.getElementById("name").value="";
			
		}else{
			alert("操作失败！");
		}
		
	},'json');
	
}
//匹配网址URL的正则表达式
function isValidateUrl(str) {
	var zp = new RegExp("[a-zA-z]+://[^\s]*");
	if (!zp.test(str)) {
		alert("对不起，你的输入有误,请输入正确的Url!");
		return false;
	} else {
		return true;
	}
}
//修改
function editType(dizhi,id){
	
	var url=dizhi+"/admin/link/upate";
	
	$.post(url,{"id":id},function(data){
		var o = eval("("+data+")");
		if(o.id!=0){
			$("#linkid").val(o.id);
			$("#name").val(o.name);
			$("#type").val(o.type);
			$("#filepath").val(o.url);
			var a = $('.content-box ul.content-box-tabs li a');
			$(a).parent().siblings().find("a").removeClass('current');
			$(a).addClass('current');
			$("#role").html("修改友情链接信息");
			$(".default-tab").removeClass('current');
			$("#tab1").hide(); 
			$("#tab2").show();
		}else{
			alert("友情链接信息不存在");
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
   	
		var url=dizhi+"/admin/link/del";
		
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
	
	var url=prefix+"/admin/link/delByIds";
	
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
				var link = o[j];
				var tr = "<tr>" +
							"<td><input type='checkbox' value='"+link.id+"'></td>" +
							"<td>"+i+"</td>" +
							"<td>"+link.type+"</td>" +
							"<td>"+link.name+"</td>" +
							"<td>"+link.url+"</td>" +
							"<td>"+
								"<a href=\"javascript:del('"+dizhi+"',"+link.id+");\" title='删除友情链接信息'><img src='"+dizhi+"/images/icons/cross.png' alt='删除友情链接信息' /></a>"+
								"<a href=\"javascript:editType('"+dizhi+"',"+link.id+");\" title='修改友情链接信息'><img src='"+dizhi+"/images/icons/hammer_screwdriver.png' alt='修改友情链接信息' /></a>"+
							"</td>"+
						 "</tr>";
			
				$("#datalist").append(tr);
				i++;
			}
			
		}
}