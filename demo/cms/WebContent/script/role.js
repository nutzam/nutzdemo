/*
 * 添加角色信息
 * @param {Object} prefix  网站前缀
 * @return {TypeName} 
 */
function addRole(prefix){
	var rolename = $.trim($("#rolename").val());
	if(rolename==""){
		alert("请填写角色名称，角色名称不能为空！");
		$("#rolename").focus();
		return;
	}

	var rule = $.trim($("#rolerule").val());
	var reg = /^\d{1,2}$/;
	if(!reg.test(rule)){
		alert("角色优先级填写错误，请填写0-99之间的整数！");
		$("#rolerule").focus();
		return;
	}
	
	if(rule<0||rule>99){
		alert("角色优先级填写错误，请填写0-99之间的整数！");
		$("#rolerule").focus();
		return;
	}
	
	var id = $("#roleid").val();
	
	var url=prefix+"/admin/role/add";
	
	$.post(url,{"role.name":rolename,"role.rule":rule,"role.id":id},function(data){
		var o = eval("("+data+")");
		if(o[0].success){	
			if(id!=0){
				$("#r"+id).find("td").slice(2,3).html(rolename);
				$("#r"+id).find("td").slice(3,4).html(rule);
			}else{
				var role = o[1];
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
				var tr = "<tr id='r"+role.id+"'>" +
						"<td><input type='checkbox' value='"+role.id+"'></td>" +
						"<td>1</td>" +
						"<td>"+role.name+"</td>" +
						"<td>"+role.rule+"</td>" +
						"<td>"+
							"<a href='"+prefix+"/admin/role/permission?id="+role.id+"' title='编辑角色权限'><img src='"+prefix+"/images/icons/pencil.png' alt='编辑角色权限' /></a>"+
							"<a href=\"javascript:delById('"+prefix+"',"+role.id+");\" title='删除角色'><img src='"+prefix+"/images/icons/cross.png' alt='删除角色' /></a>"+
							"<a href=\"javascript:editRole('"+prefix+"',"+role.id+");\" title='修改角色'><img src='"+prefix+"/images/icons/hammer_screwdriver.png' alt='修改角色' /></a>"+
						"</td>"+
					"</tr>";
				$(datalist).prepend(tr);
			}
			$("#rolename").val("");
			$("#rolerule").val("");
			$("#roleid").val(0);
			
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
   	
	var url=prefix+"/admin/role/del";
	
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
	
	var url=prefix+"/admin/role/delByIds";
	
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
				var role = o[j];
				var tr = "<tr>" +
							"<td><input type='checkbox' value='"+role.id+"'></td>" +
							"<td>"+i+"</td>" +
							"<td>"+role.name+"</td>" +
							"<td>"+role.rule+"</td>" +
							"<td>"+
								"<a href='"+prefix+"/admin/role/permission?id="+role.id+"' title='编辑角色权限'><img src='"+prefix+"/images/icons/pencil.png' alt='编辑角色权限' /></a>"+
								"<a href=\"javascript:delById('"+prefix+"',"+role.id+");\" title='删除角色'><img src='"+prefix+"/images/icons/cross.png' alt='删除角色' /></a>"+
								"<a href=\"javascript:editRole('"+prefix+"',"+role.id+");\" title='修改角色'><img src='"+prefix+"/images/icons/hammer_screwdriver.png' alt='修改角色' /></a>"+
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
function editRole(prefix,id){
	
	var url=prefix+"/admin/role/find";
	
	$.post(url,{"id":id},function(data){
		var o = eval("("+data+")");
		if(o.id!=0){
			$("#roleid").val(o.id);
			$("#rolename").val(o.name);
			$("#rolerule").val(o.rule);
			var a = $('.content-box ul.content-box-tabs li a');
			$(a).parent().siblings().find("a").removeClass('current');
			$(a).addClass('current');
			$("#role").html("修改角色");
			$(".default-tab").removeClass('current');
			$("#tab1").hide(); 
			$("#tab2").show();
		}else{
			alert("角色信息不存在");
		}
		
	},'json');
	
}

