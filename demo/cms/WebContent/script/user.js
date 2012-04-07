/*
 * 添加角色信息
 * @param {Object} prefix  网站前缀
 * @return {TypeName} 
 */
function addUser(prefix){
	var username = $.trim($("#userusername").val());
	if(username==""){
		alert("请填写用户名，用户名不能为空！");
		$("#userusername").focus();
		return;
	}
	var reg = /^[0-9a-z_]+$/;
	if(!reg.test(username)&&username.length>=6&&username.length<=12){
		alert("用户名为数字、字母、下划线组合，长度在6到12个字符！");
		$("#userusername").focus();
		return;
	}

	var password = $.trim($("#userpassword").val());
	if(password==""){
		alert("请填写密码，密码不能为空！");
		$("#userpassword").focus();
		return;
	}
	reg = /^[0-9a-z]$/;
	if(reg.test(password)&&password.length>=6&&password.length<=12){
		alert("密码为数字或者字母，长度在6到12个字符！");
		$("#userpassword").focus();
		return;
	}
	
	var state = document.getElementById("userstate").checked;
	
	var id = $("#userid").val();
	
	var url=prefix+"/admin/user/add";
	
	$.post(url,{"user.username":username,"user.password":password,"user.state":state,"user.id":id},function(data){
		var o = eval("("+data+")");
		if(o[0].success){
			var user = o[1];
			if(id!=0){
				$("#r"+id).find("td").slice(2,3).html(username);
				$("#r"+id).find("td").slice(3,4).html(password);
				var ustate = "启用";
				if(!user.state){
					ustate = "禁用";
				}
				$("#r"+id).find("td").slice(6,7).html(ustate);
			}else{		
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
				var state = "禁用";
				if(user.state){
					state = "启用";
				}
				var tr = "<tr id='r"+user.id+"'>" +
						"<td><input type='checkbox' value='"+user.id+"'></td>" +
						"<td>1</td>" +
						"<td>"+user.username+"</td>" +
						"<td>"+user.password+"</td>" +
						"<td>"+user.loginTime+"</td>" +
						"<td>"+user.logintimes+"</td>" +
						"<td>"+state+"</td>" +
						"<td>"+
							"<a href='"+prefix+"/admin/role/set?uid="+user.id+"' title='设置管理员角色'><img src='"+prefix+"/images/icons/pencil.png' alt='设置管理员角色' /></a>"+
							"<a href=\"javascript:delById('"+prefix+"',"+user.id+");\" title='删除管理员'><img src='"+prefix+"/images/icons/cross.png' alt='删除管理员' /></a>"+
							"<a href=\"javascript:editUser('"+prefix+"',"+user.id+");\" title='修改管理员信息'><img src='"+prefix+"/images/icons/hammer_screwdriver.png' alt='修改管理员信息' /></a>"+
						"</td>"+
					"</tr>";
				$(datalist).prepend(tr);
			}
			$("#userusername").val("");
			$("#userpassword").val("");
			document.getElementById("userstate").checked = true;
			$("#userid").val(0);
			
		}else{
			alert("添加管理员失败！");
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
   	
	var url=prefix+"/admin/user/del";
	
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
	
	var url=prefix+"/admin/user/delByIds";
	
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
				var user = o[j];
				var state = "禁用";
				if(user.state){
					state = "启用";
				}
				var tr = "<tr id='r"+user.id+"'>" +
						"<td><input type='checkbox' value='"+user.id+"'></td>" +
						"<td>1</td>" +
						"<td>"+user.username+"</td>" +
						"<td>"+user.password+"</td>" +
						"<td>"+user.loginTime+"</td>" +
						"<td>"+user.logintimes+"</td>" +
						"<td>"+state+"</td>" +
						"<td>"+
							"<a href='"+prefix+"/admin/role/set?uid="+user.id+"' title='设置管理员角色'><img src='"+prefix+"/images/icons/pencil.png' alt='设置管理员角色' /></a>"+
							"<a href=\"javascript:delById('"+prefix+"',"+user.id+");\" title='删除管理员'><img src='"+prefix+"/images/icons/cross.png' alt='删除管理员' /></a>"+
							"<a href=\"javascript:editUser('"+prefix+"',"+user.id+");\" title='修改管理员信息'><img src='"+prefix+"/images/icons/hammer_screwdriver.png' alt='修改管理员信息' /></a>"+
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
function editUser(prefix,id){
	
	var url=prefix+"/admin/user/find";
	
	$.post(url,{"id":id},function(data){
		var o = eval("("+data+")");
		if(o.id!=0){
			$("#userid").val(o.id);
			$("#userusername").val(o.username);
			$("#userpassword").val(o.password);
			document.getElementById("userstate").checked = o.state;
			
			var a = $('.content-box ul.content-box-tabs li a');
			$(a).parent().siblings().find("a").removeClass('current');
			$(a).addClass('current');
			$("#role").html("修改管理员");
			$(".default-tab").removeClass('current');
			$("#tab1").hide(); 
			$("#tab2").show();
		}else{
			alert("管理员信息不存在");
		}
		
	},'json');
	
}

