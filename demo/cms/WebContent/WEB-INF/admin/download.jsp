<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>资源下载管理</title>
		<%@include file="/common/common.jsp"%>
		<script type="text/javascript" src="${ctx}/script/page.js"></script>
		<script type="text/javascript" src="${ctx}/script/ajaxfileupload.js"></script>
		<script type="text/javascript" src="${ctx}/script/download.js"></script>
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
						$("#articletypeid").val(0);
						$("#name").val('');
						$("#role").html("添加资源");
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
				url:'${ctx}/admin/download/upload',
				secureuri:false,
				fileElementId:'downurl',
				dataType: 'json',				
				success: function (data, status)
				{
					switch(data[0].ret){
						case 0:$("#tipid").html("上传资源文件失败.");break;
						case 1:$("#tipid").html("资源文件已经存在.");break;
						case 2:{
								document.getElementById("tipid").innerHTML="上传资源文件成功.";
								document.getElementById("filepath").value = data[1].file;
								document.getElementById("downurl").value = data[1].file;
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
		
			//图片上传
		function uploadimage(){
			$.ajaxFileUpload({
				url:'${ctx}/admin/download/uploadimage',
				secureuri:false,
				fileElementId:'downimage',
				dataType: 'json',				
				success: function (data, status)
				{
					switch(data[0].ret){
						case 0:$("#tipid").html("上传资源文件失败.");break;
						case 1:$("#tipid").html("资源文件已经存在.");break;
						case 2:{
								document.getElementById("tipidimage").innerHTML="上传资源文件成功.";
								document.getElementById("filepathimage").value = data[1].file;
								document.getElementById("downimage").value = data[1].file;
								document.getElementById("pimg").src='${ctx}/'+data[1].file;
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
			
		</script>
	</head>
	<body style="background-image: none;" onload="findmodel('${ctx}')">
			<!-- Wrapper for the radial gradient background -->
			<div id="main-content" style="width: 100%;height: 100%;margin-left: 0px;">
				<div class="content-box">
					<!-- Start Content Box -->

					<div class="content-box-header">

						<h3>
							资源信息
						</h3>

						<ul class="content-box-tabs">
							<li>
								<a href="#tab1" class="default-tab">资源列表</a>
							</li>
							<li>
								<a href="#tab2" id="role">添加资源</a>
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
									你可以编辑以下资源信息
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
											资源名称
										</th>
										<th>
											操作
										</th>
									</tr>

								</thead>

								<tfoot>
									<tr>
										<td colspan="4">
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
												<td colspan="5">没有资源信息，请先添加</td>
											</tr>
										</c:when>
										<c:otherwise>
											<c:forEach var="type" items="${pm.result}" varStatus="status">
												<tr id="r${type.id}">
													<td><input type="checkbox" value="${type.id}" name="luo"/></td>
													<td>${status.index+1}</td>
													<td>${type.title}</td>												
													<td>
														<!-- Icons -->
														<a href="javascript:del('${ctx}',${type.id});" title="删除资源信息"><img src="${ctx}/images/icons/cross.png" alt="删除资源信息" /></a>
														<!-- 
														<a href="javascript:editType('${ctx}',${type.id})" title="修改资源信息"><img src="${ctx}/images/icons/hammer_screwdriver.png" alt="修改资源信息" /></a>
													 -->
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

							<form method="post" id="datafrom" action="">
								<input type="hidden" name="download.id" value="0" id="downloadid"/>
								<input type="hidden" name="download.url" id="filepath"/>
								<input type="hidden" id="filepathimage"/>
								<fieldset>
									<!-- Set class to "column-left" or "column-right" on fieldsets to divide the form into columns -->
									<p>
										<label>
											资源类型
										</label>
										<select id="modelid" name="download.modelid"></select>
										<span class="input-notification information png_bg">资源类型，用于设置添加资源文件的类型</span>
										<!-- Classes for input-notification: success, error, information, attention -->
										<br />
									</p>
									<p>
										<label>
											资源名称
										</label>
										<input class="text-input small-input" type="text" id="title" name="download.title" />
										<span class="input-notification information png_bg">资源名称，用于设置添加资源文件的名称</span>
										<!-- Classes for input-notification: success, error, information, attention -->
										<br />
									</p>
									<p>
										<label>
											资源文件
										</label>
										<input class="text-input small-input" type="file" id="downurl" name="downurl" />
										<input type="button" value="上传" onclick="return upload();" id="buttonUpload"/>	
										<span class="input-notification attention png_bg" id='tipid'>资源文件</span>
										<!-- Classes for input-notification: success, error, information, attention -->
										
										<br />
									</p>
										<p>
										
										<label>
											图片预览<img src="${ctx}/downloadImages/" alt="预览图片" width="100" id="pimg"/>
										</label>
										<input class="text-input small-input" type="file" id="downimage" name="downimage" />
										<input type="button" value="上传" onclick="return uploadimage();" id="buttonUpload"/>	
										<span class="input-notification attention png_bg" id='tipidimage'>图片预览</span>
										<!-- Classes for input-notification: success, error, information, attention -->
										<br />
									</p>
									<p>
										<input class="button" type="button" value="保存" onclick="add('${ctx}');"/>
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
