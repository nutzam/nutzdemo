<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>模版管理</title>
		<%@include file="/common/common.jsp"%>
		<script type="text/javascript" src="${ctx}/script/ajaxfileupload.js"></script>
		<script type="text/javascript" src="${ctx}/script/template.js"></script>
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
						$("#templeteName").val('');
						$("#description").val('');
						$("#file").val('');
						$("#type").val(0);
						$("#filepath").val('');
						$("#role").html("添加新模板");
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
				url:'${ctx}/admin/templete/upload',
				secureuri:false,
				fileElementId:'template',
				dataType: 'json',				
				success: function (data, status)
				{
					switch(data[0].ret){
						case 0:$("#tipid").html("上传模板文件失败.");break;
						case 1:$("#tipid").html("模板文件已经存在.");break;
						case 2:{
								document.getElementById("tipid").innerHTML="上传模板文件成功.";
								document.getElementById("filepath").value = data[1].file;
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
		</script>
	</head>
	<body style="background-image: none;">
			<!-- Wrapper for the radial gradient background -->
			<div id="main-content" style="width: 100%;height: 100%;margin-left: 0px;">
				<div class="content-box">
					<!-- Start Content Box -->

					<div class="content-box-header">

						<h3>
							模板管理
						</h3>

						<ul class="content-box-tabs">
							<li>
								<a href="#tab1" class="default-tab">模板信息列表</a>
							</li>
							<li>
								<a href="#tab2" id="role">添加新模板</a>
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
									你可以编辑以下模板信息
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
											模板名称
										</th>
										<th>
											模版简介
										</th>
										<th>
											创建时间
										</th>
										<th>
											模版路径
										</th>
										<th>
											操作
										</th>
									</tr>

								</thead>

								<tfoot>
									<tr>
										<td colspan="5">
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
												<td colspan="5">没有模板信息，请先添加</td>
											</tr>
										</c:when>
										<c:otherwise>
											<c:forEach var="template" items="${pm.result}" varStatus="status">
												<tr id="r${template.id}">
													<td><input type="checkbox" value="${template.id}"/></td>
													<td>${status.index+1}</td>
													<td>${template.templeteName}</td>
													<td>${template.description}</td>
													<td>
														<fmt:formatDate value="${template.createDate}" pattern="yyyy/MM/dd HH:mm"/>
													</td>
													<td>${template.filePath}</td>
													<td>
														<!-- Icons -->
														<a href="javascript:delById('${ctx}',${template.id});" title="删除模板文件"><img src="${ctx}/images/icons/cross.png" alt="删除模板文件" /></a>
														<a href="javascript:editTemplate('${ctx}',${template.id})" title="修改模板文件"><img src="${ctx}/images/icons/hammer_screwdriver.png" alt="修改模板文件" /></a>
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
								<input type="hidden" name="t.id" value="0" id="id"/>
								<input type="hidden" name="t.filepath" value="0" id="filepath"/>
								<fieldset>
									<!-- Set class to "column-left" or "column-right" on fieldsets to divide the form into columns -->

									<p>
										<label>
											模板名称
										</label>
										<input class="text-input small-input" type="text"
											id="templeteName" name="t.templeteName" />
										<span class="input-notification information png_bg">模板名称</span>
										<!-- Classes for input-notification: success, error, information, attention -->
										<br />
									</p>
									<p>
										<label>
											模板简介
										</label>
										<input class="text-input large-input" type="text"
											id="description" name="t.description" />
										<span class="input-notification information png_bg">用于描述模板的作用</span>
										<!-- Classes for input-notification: success, error, information, attention -->
										<br />
									</p>
									<p>
										<label>
											模板文件
										</label>
										<input class="text-input small-input" type="file" id="template" name="template" />
										<input type="button" value="上传" onclick="return upload();" id="buttonUpload"/>	
										<span class="input-notification attention png_bg" id='tipid'>样式模板</span>
										<!-- Classes for input-notification: success, error, information, attention -->
										<br />
									</p>
									<p>
										<label>
											模板分类
										</label>
										<select id="type">
											<option value="0">----请选择分类----</option>
											<option value="about">关于我们模板</option>
											<option value="CACAT">联系我们模板</option>
											<option value="list">文章列表模板</option>
											<option value="message">消息留言模板</option>
											<option value="download">下载资源模板</option>
											<option value="group">学术小组模板</option>
										</select>
										<span class="input-notification attention png_bg">模板分类</span>
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
