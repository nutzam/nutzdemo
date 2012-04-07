
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
   	
	var url=prefix+"/admin/message/delByIds";
	
	$.post(url,{"ids":id,"currentPage":currentPage},function(data){
		
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
	
	var url=prefix+"/admin/message/delByIds";
	
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
				
				var tr = "<tr id='r"+user.id+"'>" +
						"<td><input type='checkbox' value='"+user.id+"'></td>" +
						"<td>1</td>" +
						"<td>"+user.email+"</td>" +
						"<td>"+user.insertTime+"</td>" +
						
						"<td>"+user.content.substring(0,20)+"</td>" +
						"<td>"+
							
							"<a href=\"javascript:delById('"+prefix+"',"+user.id+");\" title='删除文章信息'><img src='"+prefix+"/images/icons/cross.png' alt='删除文章信息' /></a>"+
							"<a href=\"javascript:editUser('"+prefix+"',"+user.id+");\" title='查看文章信息'><img src='"+prefix+"/images/icons/hammer_screwdriver.png' alt='查看文章信息' /></a>"+
						"</td>"+
					"</tr>";
			
				$("#datalist").append(tr);
				i++;
			}
			
		}
}
//展示留言详细
function editMessage(prefix,id){Infinity
document.form1.reset();
	document.getElementById("isdispphone").style.display="none";
	
	document.getElementById("isdispreplayTime").style.display="none";
	document.getElementById("isdisptel").style.display="none";
	document.getElementById("isreply").style.display="none";
	var url=prefix+"/admin/message/find";
	$.post(url,{"id":id},function(data){
		
		var o = eval("("+data+")");
		if(o!=null&&o.id!=0){
			$("#type").val(o.type.name);
			
			$("#pkid").val(id);
			$("#vistor").val(o.vistor);
			$("#insertTime").val(o.insertTime);
			$("#content").val(o.content);
			$("#tel").val(o.tel);
			$("#phone").val(o.phone);
			$("#email").val(o.email);
			$("#replayTime").val(o.replayTime);
			$("#replayContent").val(o.replayContent);
			if(o.type.isdisptel){
				document.getElementById("isdisptel").style.display="block";
			}
			if(o.type.replay){
				document.getElementById("replay").style.display="block";
				document.getElementById("isreply").style.display="block";
			}if(o.type.isdispreplayTime){
			getTime();
				document.getElementById("isdispreplayTime").style.display="block";
			}if(o.type.isdispemail){
				document.getElementById("isdispemail").style.display="block";
			}if(o.type.isdispphone){
				document.getElementById("isdispphone").style.display="block";
			}
			$(".default-tab").removeClass('current');
			$("#tab1").hide(); 
			$("#tab2").show();
		}else{
			alert("留言不存在");
		}
		
	},'json');
	}
	//获取时间
	   function getTime(){
		var s="";
		var d = new Date();  
		s += (d.getYear())+"-"                      
 	    s +=(d.getMonth() + 1) + "-";            
  	    s += d.getDate();   
  	    s+=" "+d.getHours()+":"+d.getMinutes()+":"+d.getSeconds();           
 	    document.getElementById('replayTime').value=s;
	}
	//回复
	function update(m){
	var reply=document.getElementById("replayContent").value;
	var pkid=document.getElementById("pkid").value;
	if(reply==""||reply.length==0){
		return false;
	}
	var url=m+"/admin/message/update";
	$.post(url,{"mess.id":pkid,"mess.replayContent":reply},function(data){
	var o=eval("("+data+")");
		if(o.success){
			alert("回复已记录");
		}else{
			alert("回复未被记录");
		}
	},"json");
	}