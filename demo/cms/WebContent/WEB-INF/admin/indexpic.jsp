<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>模版管理</title>
		<%@include file="/common/common.jsp"%>
		<script type="text/javascript" src="${ctx}/script/ajaxfileupload.js"></script>
		<script type="text/javascript" src="${ctx}/script/indexpic.js"></script>
		<script type="text/javascript" src="${ctx}/script/page.js"></script>
		<script type="text/javascript">
			$(document).ready(function(){
				$('.content-box .content-box-content div.tab-content').hide();
				$('ul.content-box-tabs li a.default-tab').addClass('current');
				$('.content-box-content div.default-tab').show(); 
				$('.content-box ul.content-box-tabs li a').click( // When a tab is clicked...
					function() { 
						$(this).parent().siblings().find("a").removeClass('current'); // Remove "current" class from all tabs
						$(this).addClass('current'); // Add class "current" to clicked tab
						var currentTab = $(this).attr('href'); // Set variable "currentTab" to the value of href of clicked tab
						$(currentTab).siblings().hide(); // Hide all content divs
						$(currentTab).show(); // Show the content div with the id equal to the id of clicked tab
						$("#id").val(0);
						$("#name").val('');
						$("#href").val('');
						$("#target").val('');
						$("#pic").val('');
						$("#picup").show();
						$("#sortNumber").val('');
						$("#role").html("添加新图片");
						return false; 
					}
				);
				$('tbody tr:even').addClass("alt-row");
				$('.check-all').click(
					function(){
						$(this).parent().parent().parent().parent().find("input[type='checkbox']").attr('checked', $(this).is(':checked'));   
					}
				);
				$(".close").click(
					function () {
						$(this).parent().fadeTo(400, 0, function () { // Links with the class "close" will close parent
							$(this).slideUp(400);
						});
						return false;
					}
				);
			});
		//文件上传
		function upload(){
			$.ajaxFileUpload({
				url:'${ctx}/admin/indexpic/upload',
				secureuri:false,
				fileElementId:'template',
				dataType: 'json',				
				success: function (data, status)
				{
					switch(data[0].ret){
						case 0:$("#tipid").html("上传图片失败.");break;
						case 1:$("#tipid").html("图片已经存在.");break;
						case 2:{
								document.getElementById("tipid").innerHTML="上传图片成功.";
								document.getElementById("pic").value = data[1].file;
								document.getElementById("template").value = data[1].file;
								}
								break;
						default:
								break;
					}
				},
				error: function (data, status, e)
				{
					alert(e);
				}
			});
			return false;
		}	
		
		
			function edit(prefix,id){
	
	var url=prefix+"/admin/indexpic/find";
	
	$.post(url,{"id":id},function(data){
		
		var o = eval("("+data+")");
		
		if(o.id!=0){
			
			$("#id").val(o.id);
			$("#sortNumber").val(o.sortNumber);
			$("#href").val(o.href);
			$("#name").val(o.name);
			$("#target").val(o.target);
			$("#pic").val(o.pic);
			var a = $('.content-box ul.content-box-tabs li a');
			$(a).parent().siblings().find("a").removeClass('current');
			$(a).addClass('current');
			$("#role").html("修改文章信息");
			$(".default-tab").removeClass('current');
			$("#picup").hide();
			$("#tab1").hide(); 
			$("#tab2").show();
		}else{
			alert("文章信息不存在");
		}
		
	},'json');
	
}
		</script>
	</head>
	<body style="background-image: none;">
			<!-- Wrapper for the radial gradient background -->
			<div id="main-content" style="width: 100%;height: 100%;margin-left: 0px;">
				<div class="content-box">
					<!-- Start Content Box -->

					<div class="content-box-header">

						<h3>
							首页图片管理
						</h3>

						<ul class="content-box-tabs">
							<li>
								<a href="#tab1" class="default-tab">首页图片列表</a>
							</li>
							<li>
								<a href="#tab2" id="role">添加新图片</a>
							</li>
						</ul>

						<div class="clear"></div>

					</div>
					<!-- End .content-box-header -->

					<div class="content-box-content">

						<div class="tab-content default-tab" id="tab1">
							<!-- This is the target div. id must match the href of this div's tab -->

							<div class="notification attention png_bg">
								<a href="#" class="close"><img
										src="${ctx}/images/icons/cross_grey_small.png"
										title="Close this notification" alt="close" />
								</a>
								<div>
									你可以编辑以下图片信息
								</div>
							</div>

							<table>

								<thead>
									<tr>
										<th>
											<input class="check-all" type="checkbox" />
										</th>
										<th>
											序号
										</th>
										<th>
											图片名称
										</th>
										<th>
											链接地址
										</th>
										<th>
											图片路径
										</th>
										<th>
											操作
										</th>
									</tr>

								</thead>

								<tfoot>
									<tr>
										<td colspan="6">
											<div class="bulk-actions align-left">
												<a class="button" href="javascript:delByIds('${ctx}');">删除选定</a>
											</div>
											<!-- 分页信息 -->
											<div class="pagination"> 
												<c:if test="${pm.result ne null}">
												<script>
													var pg = new showPages('pg');
													pg.pageCount = ${pm.maxPage};
													pg.argName = 'currentPage';
													pg.printHtml();  
												</script>
												</c:if>
											</div>
											<!-- End .pagination -->
											<div class="clear"></div>
										</td>
									</tr>
								</tfoot>
								<!-- 数据展示 -->
								<tbody id="datalist">
									<c:choose>
										<c:when test="${pm.result eq null}">
											<tr>
												<td colspan="6">没有图片信息，请先添加</td>
											</tr>
										</c:when>
										<c:otherwise>
											<c:forEach var="pic" items="${pm.result}" varStatus="status">
												<tr id="r${pic.id}">
													<td><input type="checkbox" value="${pic.id}"/></td>
													<td>${status.index+1}</td>
													<td>${pic.name}</td>
													<td>${pic.href}</td>
													<td>${pic.pic}</td>
													<td>
														<!-- Icons -->
														<a href="javascript:delById('${ctx}',${pic.id});" title="删除图片"><img src="${ctx}/images/icons/cross.png" alt="删除图片" /></a>	
														<a href="javascript:edit('${ctx}',${pic.id})" title="修改小组信息"><img src="${ctx}/images/icons/hammer_screwdriver.png" alt="修改小组信息" /></a>
													</td>
												</tr>
											</c:forEach>
										</c:otherwise>
									</c:choose>
									
								</tbody>

							</table>

						</div>
						<!-- End #tab1 -->

						<div class="tab-content" id="tab2">

							<form method="post">
								<input type="hidden" name="pic.id" value="0" id="id"/>
								<input type="hidden" name="pic.pic" value="0" id="pic"/>
								<fieldset>
									<!-- Set class to "column-left" or "column-right" on fieldsets to divide the form into columns -->

									<p>
										<label>
											图片名称
										</label>
										<input class="text-input small-input" type="text"
											id="name" name="pic.name" />
										<span class="input-notification information png_bg">图片名称</span>
										<!-- Classes for input-notification: success, error, information, attention -->
										<br />
									</p>
									<p>
										<label>
											链接地址
										</label>
										<input class="text-input large-input" type="text"
											id="href" name="pic.href" value="#"/>
										<span class="input-notification information png_bg">用于点击图片后链接到页面</span>
										<!-- Classes for input-notification: success, error, information, attention -->
										<br />
									</p>
									<p>
										<label>
											排序号码
										</label>
										<input class="text-input large-input" type="text"
											id="sortNumber" name="pic.sortNumber" value="#"/>
										<span class="input-notification information png_bg">用于指定图片的先后顺序，数字越大越前</span>
										<!-- Classes for input-notification: success, error, information, attention -->
										<br />
									</p>
									<p>
										<label>
											打开方式
										</label>
										<input class="text-input large-input" type="text"
											id="target" name="pic.target" value="_blank"/>
										<span class="input-notification information png_bg">点击图片后页面的打开方式默认为_blank,即新窗口</span>
										<!-- Classes for input-notification: success, error, information, attention -->
										<br />
									</p>
									<p id="picup">
										<label>
											上传图片
										</label>
										<input class="text-input small-input" type="file" id="template" name="template" />
										<input type="button" value="上传" onclick="return upload();" id="buttonUpload"/>	
										<span class="input-notification attention png_bg" id='tipid'>选择图片后上传</span>
										<!-- Classes for input-notification: success, error, information, attention -->
										<br />
									</p>
									<p>
										<input class="button" type="button" value="保存" onclick="addTemplate('${ctx}');"/>
									</p>

								</fieldset>

								<div class="clear"></div>
								<!-- End .clear -->

							</form>

						</div>
						<!-- End #tab2 -->

					</div>
					<!-- End .content-box-content -->

				</div>
				<!-- End .content-box -->

				<div id="footer">
				<small> <!-- Remove this notice or replace it with whatever you want -->
						&#169; Copyright 2009  新西软科技| Powered by <a href="http://themeforest.net/item/simpla-admin-flexible-user-friendly-admin-skin/46073">Shine</a> | <a href="#">Top</a>
				</small>
				</div><!-- End #footer -->

			</div>
			<!-- End #main-content -->
	</body>
</html>
