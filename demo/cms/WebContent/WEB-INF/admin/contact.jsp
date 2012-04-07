<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>网站信息管理</title>
		<%@include file="/common/common.jsp"%>
		<script type="text/javascript" src="${ctx}/script/simpla.jquery.configuration.js"></script>
		<script type="text/javascript" src="${ctx}/script/jquery.MultiFile.pack.js"></script>
		<script type="text/javascript">
//提交		
	$(document).ready(function(){					
	 	$("#dataform").submit(function(){
			$(this).ajaxSubmit({
				beforeSubmit:function(){
				},
				success:function(data){
				var o = eval("("+eval("("+data+")")+")");
					if(o.success){
						alert("设置成功！");
					}else{
					alert("设置失败！");
					}
				},
				url:"${ctx}/admin/contact/contact",
				type:'post'
			});
			return false;
		});
		
		$("#contactfile").MultiFile();
				
				var options = {
						beforeSubmit:function(){
						var files = $("#contactfile").val();
						if(files==undefined||files==''){
						return false;
						}
						},
						success:function(responseText, statusText, xhr, $form){
							var o = eval("("+responseText+")");
							$("#contactfile").val(o.file);
							$("#imgurl").val(o.file);
							$('input:file').MultiFile('reset')
							$('#tip').html("文件上传成功");
						},
						url:'${ctx}/admin/contact/upload',
						datatype:'json',
						type:'POST'
				};
				$("#fileupload").submit(function(){
					$(this).ajaxSubmit(options);
					return false;
				});
				 shownav();
	 });
	 //获取导航
			function shownav(){
				var navurl = "${ctx}/admin/navmodel/json";
				$.post(navurl,null,function(data){
					var o = eval("("+data+")");
					var str = process(o[0],'');
					$("#navid").append(str);
				},'json');
			}
/**
 * 设置导航数据显示的样式
 * @param {Object} o
 * @param str
 */
function process(o,str){
if(o.id==${contact.navid}){
	var option="<option value='"+o.id+"' selected='true'>"+str+o.text+"</option>";
	}else{
	var option="<option value='"+o.id+"'>"+str+o.text+"</option>";
	}
	if(o.children){
		$(o.children).each(function(){
			option += process(this,str+"--");
		});
	}
	return option;
}
		</script>
	</head>

	<body style="background-image: none;">
		<div id="main-content">

				<fieldset>
					<!-- Set class to "column-left" or "column-right" on fieldsets to divide the form into columns -->
				<form method="post" action="${ctx}/admin/contact/upload" enctype="multipart/form-data" id="fileupload">
					<p>
										<label>
											学校地图：
										</label>
										<input class="multi" maxlength="5"  type="file" id="contactfile" name="contact.imgfile"/>
										<span class="input-notification information png_bg" id="tip">可以上传一张学校地图</span>
										<input  class="button" type="submit" value="上传"/>
										<!-- Classes for input-notification: success, error, information, attention -->
										<br />
									</p>
									</form>
			<form id="dataform" method="post">
				<input type="hidden" name="con.id" value="${contact.id}" />
				<input type="hidden" name="con.imgurl" id="imgurl"/>
					<p>
			
						<label>
							所属导航
						</label>
						<select id="navid" name="con.navid"></select>
						
						<!-- Classes for input-notification: success, error, information, attention -->
						<br />
					</p>
					<p>
						<label>
							
						</label>
						<input class="text-input" style="width:100px;vertical-align:top;" type="text" id="small-input" name="con.type1" value="${contact.type1}"/>
						<input class="text-input medium-input" type="text" id="small-input" name="con.name1" value="${contact.name1}"/>
						
						<!-- Classes for input-notification: success, error, information, attention -->
						<br />
					</p>
					<p>
						<label>
							
						</label>
						<input class="text-input" style="width:100px;vertical-align:top;" type="text" id="small-input" name="con.type2" value="${contact.type2}"/>
						<input class="text-input medium-input" type="text" id="small-input" name="con.name2" value="${contact.name2}"/>		
					</p>
					<p>
						<label>
							
						</label>
						<input class="text-input" style="width:100px;vertical-align:top;" type="text" id="small-input" name="con.type3" value="${contact.type3}"/>
						<input class="text-input medium-input" type="text" id="small-input" name="con.name3" value="${contact.name3}"/>
					</p>
					<p>
						<label>
							
						</label>
						<input class="text-input" style="width:100px;vertical-align:top;" type="text" id="small-input" name="con.type4" value="${contact.type4}"/>
						<input class="text-input medium-input" type="text" id="small-input" name="con.name4" value="${contact.name4}"/>
					</p>
					<p>
						<label>
							
						</label>
						<input class="text-input" style="width:100px;vertical-align:top;" type="text" id="small-input" name="con.type5" value="${contact.type5}"/>
						<input class="text-input medium-input" type="text" id="small-input" name="con.name5" value="${contact.name5}"/>
					</p>
					<p>
						<label>
							
						</label>
						<input class="text-input" style="width:100px;vertical-align:top;" type="text" id="small-input" name="con.type6" value="${contact.type6}"/>
						<input class="text-input medium-input" type="text" id="small-input" name="con.name6" value="${contact.name6}"/>					</p>
										<p>
						<label>
							
						</label>
						<input class="text-input" style="width:100px;vertical-align:top;" type="text" id="small-input" name="con.type7" value="${contact.type7}"/>
						<input class="text-input medium-input" type="text" id="small-input" name="con.name7" value="${contact.name7}"/>					</p>
										<p>
						<label>
							
						</label>
						<input class="text-input" style="width:100px;vertical-align:top;" type="text" id="small-input" name="con.type8" value="${contact.type8}"/>
						<input class="text-input medium-input" type="text" id="small-input" name="con.name8" value="${contact.name8}"/>					</p>
								
					<p>
						<input class="button" type="submit" value="保存" />
					</p>
</form>
				</fieldset>

				<div class="clear"></div>
				<!-- End .clear -->

			

		</div>
		<!-- End #tab2 -->

		<!-- End .content-box -->
		<div class="clear"></div>
		<div id="footer">
				<small> <!-- Remove this notice or replace it with whatever you want -->
						&#169; Copyright 2009  新西软科技| Powered by <a href="http://themeforest.net/item/simpla-admin-flexible-user-friendly-admin-skin/46073">Shine</a> | <a href="#">Top</a>
				</small>
			</div><!-- End #footer -->
		<!-- End #main-content -->
	</body>
</html>

