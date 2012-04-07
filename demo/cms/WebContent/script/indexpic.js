/**
 * 添加模板信息
 * @param {Object} prefix
 */
function addTemplate(prefix){
	
	var name = $.trim($("#name").val());
	if(name==""){
		alert("请填写图片名称，图片名称不能为空！");
		$("#name").focus();
		return;
	}
	var href = $.trim($("#href").val());
	if(href==""){
		alert("请填写图片链接地址！");
		$("#href").focus();
		return;
	}
	
	var sortNumber = $.trim($("#sortNumber").val());
	if(sortNumber==""){
		alert("请填写排序号码，数字越大越前");
		$("#sortNumber").focus();
		return;
	}
	
	var target = $.trim($("#target").val());
	if(target==""){
		alert("请填写页面打开方式");
		$("#target").focus();
		return;
	}
	
	var id = $("#id").val();
	
	var pic = $.trim($("#pic").val());
	if(pic==""){
		alert("请先上传图片");
		return;
	}
	var url=prefix+"/admin/indexpic/add";
	
	$.post(url,{"pic.id":id,"pic.name":name,"pic.href":href,"pic.pic":pic,"pic.sortNumber":sortNumber,"pic.target":target},function(data){
		var o = eval("("+data+")");
		if(o[0].success){	
			if(id!=0){
				$("#r"+id).find("td").slice(2,3).html($('#name').val());
				$("#r"+id).find("td").slice(3,4).html($('#href').val());
				alert("修改成功");
			}else{
				var pic = o[1];
				var datalist = $("#datalist");
				var trs = $(datalist).find("tr");
			
				$(trs).each(function(){
					//获得第二个td
					var td = $(this).find("td").slice(1,2);
					var index = parseInt($(td).html())+1;
					$(td).html(index);
				});
				if(trs.length>=10){
					$(trs).last().remove();
				}
				var tr = "<tr id='r"+pic.id+"'>" +
						"<td><input type='checkbox' value='"+pic.id+"'></td>" +
						"<td>1</td>" +
						"<td>"+pic.name+"</td>" +
						"<td>"+pic.href+"</td>" +
						"<td>"+pic.pic+"</td>" +
						"<td>"+
							"<a href=\"javascript:delById('"+prefix+"',"+pic.id+");\" title='删除图片'><img src='"+prefix+"/images/icons/cross.png' alt='删除图片' /></a>"+
						"<a href=\"javascript:edit('"+prefix+"',"+pic.id+");\" title='修改图片信息'><img src='"+prefix+"/images/icons/hammer_screwdriver.png' alt='修改图片信息'/></a>"+
						"</td>"+
					"</tr>";
				$(datalist).prepend(tr);
			$("#id").val(0);
			$("#name").val('');
			$("#href").val('');
			$("#sortNumber").val('');
			$("#target").val(0);
			$("#pic").val('');
			alert("添加图片成功");
			}

		}else{
			alert("添加图片失败！");
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
   	
	var url=prefix+"/admin/indexpic/del";
	
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
	
	var url=prefix+"/admin/indexpic/delByIds";
	
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
				
				var pic = o[j];
				
				var tr = "<tr id='r"+pic.id+"'>" +
						"<td><input type='checkbox' value='"+pic.id+"'></td>" +
						"<td>1</td>" +
						"<td>"+pic.name+"</td>" +
						"<td>"+pic.href+"</td>" +
						"<td>"+pic.pic+"</td>" +
						"<td>"+
							"<a href=\"javascript:delById('"+prefix+"',"+pic.id+");\" title='删除图片'><img src='"+prefix+"/images/icons/cross.png' alt='删除图片' /></a>"+
						"</td>"+
					"</tr>";
			
				$("#datalist").append(tr);
				i++;
			}
			
		}
}