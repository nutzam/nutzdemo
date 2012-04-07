/**
 * 添加模板信息
 * @param {Object} prefix
 */
function addTemplate(prefix){
	
	var templeteName = $.trim($("#templeteName").val());
	if(templeteName==""){
		alert("请填写模板名称，模板名称不能为空！");
		$("#templeteName").focus();
		return;
	}
	var description = $.trim($("#description").val());
	if(description==""){
		alert("请填写模板简介信息，模板简介不能为空！");
		$("#description").focus();
		return;
	}
	
	var type = $.trim($("#type").val());
	if(type==0){
		alert("请选择模板分类！");
		return;
	}
	
	var id = $("#id").val();
	
	var filepath = $.trim($("#filepath").val());
	if(filepath==""){
		alert("请先上传模版文件");
		return;
	}
	var url=prefix+"/admin/templete/add";
	
	$.post(url,{"t.id":id,"t.templeteName":templeteName,"t.description":description,"t.filePath":filepath,"type":type},function(data){
		var o = eval("("+data+")");
		if(o[0].success){	
			if(id!=0){
				$("#r"+id).find("td").slice(2,3).html(templeteName);
				$("#r"+id).find("td").slice(3,4).html(description);
			}else{
				var template = o[1];
				var datalist = $("#datalist");
				var trs = $(datalist).find("tr");
			
				$(trs).each(function(){
					//获得第二个td
					var td = $(this).find("td").slice(1,2);
					var index = parseInt($(td).html())+1;
					$(td).html(index);
				});
				if(trs.length>=10){
					$(trs[9]).remove();
				}
				var tr = "<tr id='r"+template.id+"'>" +
						"<td><input type='checkbox' value='"+template.id+"'></td>" +
						"<td>1</td>" +
						"<td>"+template.templeteName+"</td>" +
						"<td>"+template.description+"</td>" +
						"<td>"+template.createDate+"</td>" +
						"<td>"+template.filePath+"</td>" +
						"<td>"+
							"<a href=\"javascript:delById('"+prefix+"',"+template.id+");\" title='删除模板文件'><img src='"+prefix+"/images/icons/cross.png' alt='删除模板文件' /></a>"+
							"<a href=\"javascript:editTemplate('"+prefix+"',"+template.id+");\" title='修改模板文件'><img src='"+prefix+"/images/icons/hammer_screwdriver.png' alt='修改模板文件' /></a>"+
						"</td>"+
					"</tr>";
				$(datalist).prepend(tr);
			}
			$("#id").val(0);
			$("#templeteName").val('');
			$("#description").val('');
			$("#file").val('');
			$("#type").val(0);
			$("#filepath").val('');
			alert("添加模板成功");
		}else{
			alert("添加失败！");
		}
	},'json');
}

/*
 * 根据id删除数据
 * @param {Object} id
 */
function delById(prefix,id){
	
	if(!window.confirm("你确定要删除这条数据吗？删除过后不可恢复")){
		return ;
	}
	
	var args = location.search;   
    var reg = new RegExp('[\?&]?currentPage=([^&]*)[&$]?', 'gi');   
    var chk = args.match(reg);   
   	var currentPage = RegExp.$1; 
   	
   	var arr = new Array();
   	arr[0] = $("#r"+id);
   	
	var url=prefix+"/admin/templete/del";
	
	$.post(url,{"id":id,"currentPage":currentPage},function(data){
		
		var o = eval("("+data+")");
		
		processRemove(arr,o,prefix);
		
	},'json');
	
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
			if($(this).val()!="on"){
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
	
	var url=prefix+"/admin/templete/delByIds";
	
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
function processRemove(arr,o,prefix){
	
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
				
				var template = o[j];
				
				var tr = "<tr id='r"+template.id+"'>" +
						"<td><input type='checkbox' value='"+template.id+"'></td>" +
						"<td>1</td>" +
						"<td>"+template.templeteName+"</td>" +
						"<td>"+template.description+"</td>" +
						"<td>"+template.createDate+"</td>" +
						"<td>"+template.filepath+"</td>" +
						"<td>"+
							"<a href=\"javascript:delById('"+prefix+"',"+template.id+");\" title='删除模板文件'><img src='"+prefix+"/images/icons/cross.png' alt='删除模板文件' /></a>"+
							"<a href=\"javascript:editTemplate('"+prefix+"',"+template.id+");\" title='修改模板文件'><img src='"+prefix+"/images/icons/hammer_screwdriver.png' alt='修改模板文件' /></a>"+
						"</td>"+
					"</tr>";
			
				$("#datalist").append(tr);
				i++;
			}
			
		}
}

/*
 * 修改角色信息
 * @param {Object} prefix
 * @param {Object} id
 */
function editTemplate(prefix,id){
	
	var url=prefix+"/admin/templete/find";
	
	$.post(url,{"id":id},function(data){
		var o = eval("("+data+")");
		if(o.id!=0){
			$("#id").val(o.id);
			$("#templeteName").val(o.templeteName);
			$("#description").val(o.description);
			$("#type").val(o.type);
			$("#filepath").val(o.filePath);
			
			var a = $('.content-box ul.content-box-tabs li a');
			$(a).parent().siblings().find("a").removeClass('current');
			$(a).addClass('current');
			$("#role").html("修改模板文件");
			$(".default-tab").removeClass('current');
			$("#tab1").hide(); 
			$("#tab2").show();
		}else{
			alert("角色信息不存在");
		}
		
	},'json');
	
}