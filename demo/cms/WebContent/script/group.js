/**
 * 添加模板信息
 * @param {Object} prefix
 */
function addTemplate(prefix){
	
	var name = $.trim($("#name").val());
	if(name==""){
		alert("请填写小组名称！");
		$("#name").focus();
		return;
	}
	var href = $.trim($("#href").val());
	if(href==""){
		alert("请填写小组负责人名字！");
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
		alert("请填写小组成员信息");
		$("#target").focus();
		return;
	}
	
	var id = $("#id").val();
	
	var url=prefix+"/admin/group/add";
	
	$.post(url,{"group.id":id,"group.groupname":name,"group.groupleader":href,"group.sortNumber":sortNumber,"group.groupitems":target},function(data){
		var o = eval("("+data+")");
		if(o[0].success){	
			if(id!=0){
			
				$("#r"+id).find("td").slice(2,3).html($("#name").val());
				$("#r"+id).find("td").slice(3,4).html($("#href").val());
					alert("修改小组成功");
			}else{
				var group = o[1];
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
				var tr = "<tr id='r"+group.id+"'>" +
						"<td><input type='checkbox' value='"+group.id+"'></td>" +
						"<td>1</td>" +
						"<td>"+group.groupname+"</td>" +
						"<td>"+group.groupleader+"</td>" +
						"<td>"+group.createDate+"</td>" +
						"<td>"+
							"<a href=\"javascript:delById('"+prefix+"',"+group.id+");\" title='删除小组信息'><img src='"+prefix+"/images/icons/cross.png' alt='删除小组信息' /></a>"+
							"<a href=\"javascript:edit('"+prefix+"',"+group.id+");\" title='修改小组信息'><img src='"+prefix+"/images/icons/hammer_screwdriver.png' alt='修改小组信息'/></a>"+
						"</td>"+
					"</tr>";
				$(datalist).prepend(tr);
			$("#id").val(0);
			$("#name").val('');
			$("#href").val('');
			$("#sortNumber").val('');
			$("#target").val('');
				alert("添加小组成功");
			}

		
		}else{
		if(id!=0){
			alert("修改失败!")
		}else{
			alert("添加失败！");
			}
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
   	
	var url=prefix+"/admin/group/del";
	
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
	
	var url=prefix+"/admin/group/delByIds";
	
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
				
				var group = o[j];
				
				var tr = "<tr id='r"+group.id+"'>" +
						"<td><input type='checkbox' value='"+group.id+"'></td>" +
						"<td>1</td>" +
						"<td>"+group.groupname+"</td>" +
						"<td>"+group.groupleader+"</td>" +
						"<td>"+group.createDate+"</td>" +
						"<td>"+
							"<a href=\"javascript:delById('"+prefix+"',"+group.id+");\" title='删除小组信息'><img src='"+prefix+"/images/icons/cross.png' alt='删除小组信息' /></a>"+
						"</td>"+
					"</tr>";
			
				$("#datalist").append(tr);
				i++;
			}
			
		}
}