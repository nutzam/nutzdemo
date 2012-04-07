//添加一篇文章分类信息
function add(dizhi){
	var name = $.trim($("#name").val());
	
	if(name == ""){
		alert("对不起，请填入分类名称！");
		document.getElementById("name").focus();
		return ;
		
	}
	var id = $("#onearticletypeid").val();
	var url = dizhi+"/admin/onearticletype/add";
	$.post(url,{"onearticletype.name":name,"onearticletype.id":id},function(data){
		
		var o = eval("("+data+")");
		if(o[0].success){
			
			if(id!=0){
				var td = $("#r"+id).find("td").slice(2,3);
				td.html(name);
			}else{
				var onetype = o[1];
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
				var tr = "<tr id='r"+onetype.id+"'>" +
						"<td><input type='checkbox' value='"+onetype.id+"'></td>" +
						"<td>1</td>" +
						"<td>"+onetype.name+"</td>" +
						"<td>"+
							"<a href=\"javascript:del('"+dizhi+"',"+onetype.id+");\" title='删除文章分类信息'><img src='"+dizhi+"/images/icons/cross.png' alt='删除文章分类信息' /></a>"+
							"<a href=\"javascript:editType('"+dizhi+"',"+onetype.id+");\" title='修改文章分类信息'><img src='"+dizhi+"/images/icons/hammer_screwdriver.png' alt='修改文章分类信息' /></a>"+
						"</td>"+
					"</tr>";	
				$(datalist).prepend(tr);
			}
			
			$("#name").val("");
			$("#articletypeid").val(0);
			
		}else{
			alert("添加失败！");
		}
		
	},'json');
	
}
//修改
function editType(dizhi,id){
	
	var url=dizhi+"/admin/articletype/update";
	
	$.post(url,{"id":id},function(data){
		var o = eval("("+data+")");
		if(o.id!=0){
			$("#onearticletypeid").val(o.id);
			$("#name").val(o.name);
			var a = $('.content-box ul.content-box-tabs li a');
			$(a).parent().siblings().find("a").removeClass('current');
			$(a).addClass('current');
			$("#role").html("修改文章分类");
			$(".default-tab").removeClass('current');
			$("#tab1").hide(); 
			$("#tab2").show();
		}else{
			alert("文章分类信息不存在");
		}
		
	},'json');
}
//单个删除
function del(dizhi,id){
	if(confirm("您确定要删除这条数据吗？")){
		
		var args = location.search;   
    	var reg = new RegExp('[\?&]?currentPage=([^&]*)[&$]?', 'gi');   
    	var chk = args.match(reg);   
   		var currentPage = RegExp.$1; 
   	
   		var arr = new Array();
   		arr[0] = $("#r"+id);
   	
		var url=dizhi+"/admin/onearticletype/del";
		
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
	
	var url=prefix+"/admin/onearticletype/delByIds";
	
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
				var onetype = o[j];
				var tr = "<tr>" +
							"<td><input type='checkbox' value='"+onetype.id+"'></td>" +
							"<td>"+i+"</td>" +
							"<td>"+onetype.name+"</td>" +
							"<td>"+
								"<a href=\"javascript:del('"+dizhi+"',"+onetype.id+");\" title='删除文章分类信息'><img src='"+dizhi+"/images/icons/cross.png' alt='删除文章分类信息' /></a>"+
								"<a href=\"javascript:editType('"+dizhi+"',"+onetype.id+");\" title='修改文章分类信息'><img src='"+dizhi+"/images/icons/hammer_screwdriver.png' alt='修改文章分类信息' /></a>"+
							"</td>"+
						 "</tr>";
			
				$("#datalist").append(tr);
				i++;
			}
			
		}
}