<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>一篇文章管理</title>
		<style type="text/css">
			body{
			display: none;
			}
		</style>
		<%@include file="/common/common.jsp"%>
		<script type="text/javascript" src="${ctx}/script/onearticle.js"></script>
		<script type="text/javascript" src="${ctx}/script/page.js"></script>
		<script type="text/javascript" src="${ctx}/script/jquery.MetaData.js"></script>
		<script type="text/javascript" src="${ctx}/script/jquery.MultiFile.pack.js"></script>
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
						$("#role").html("添加文章");
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
			
			document.body.style.display="block";
				
			$("#datafrom").submit(function(){
				$(this).ajaxSubmit({
					beforeSubmit:function(){
							var nav = 0;
								$("#navid").find("option").each(function(){
									if(this.selected&&this.value!=0){
										nav = this.value;
									}
								});
								if(nav==0){
									alert("请选择文章模块");
									$("#navid").focus();
									return false;
								}
						var date = $.trim($("#createDate").val());
								if(date==""){
									alert("请填写文章发布日期");
									$("#createDate").focus();
									return false;
								}
				
        	
					},
					success:function(data){
						var o = eval("("+data+")");
						
						o = eval("("+o+")");
							if(o[0].success=true){
								alert("添加成功");
								
			
							}else{
										alert("添加失败！");
										}
					},
					url:"${ctx}/admin/onearticle/add",
					type:'post'
					});
				return false;
			});
			$("#onearticlefile").MultiFile();
			var options = {
						beforeSubmit:function(){
								var files = $("#onearticlefile").val();
								
								if(files!=""){
									alert("已经上传过文件，请勿重复上传");
									return false;
								}
						},
						success:function(responseText, statusText, xhr, $form){
							var o = eval("("+responseText+")");
							$("#onearticlefile").val(o.file);
							$('input:file').MultiFile('reset')
							$('#tip').html("文件上传成功，请勿重复上传");
						},
						url:'${ctx}/admin/onearticle/upload',
						datatype:'json',
						type:'POST'
				};
				$("#fileupload").submit(function(){
					$(this).ajaxSubmit(options);
					return false;
				});
				
			Date.format = 'yyyy-mm-dd';
			$('#createDate').datePicker({clickInput:true});
		});
		</script>
		
	</head>
	<body style="background-image: none;" onload="findnav('${ctx}')">
			<!-- Wrapper for the radial gradient background -->
			<div id="main-content" style="width: 100%;height: 100%;margin-left: 0px;">
				<div class="content-box">
					<!-- Start Content Box -->

					<div class="content-box-header">

						<h3>
							一篇文章信息
						</h3>

						<ul class="content-box-tabs">
							<li>
								<a href="#tab1" class="default-tab">文章列表</a>
							</li>
							<li>
								<a href="#tab2" id="role">添加文章</a>
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
									你可以编辑以下文章信息
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
											文章标题
										</th>
										<th>
											关键字
										</th>
										<th>
											创建时间
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
												<td colspan="5">没有文章信息，请先添加</td>
											</tr>
										</c:when>
										<c:otherwise>
											<c:forEach var="type" items="${pm.result}" varStatus="status">
												<tr id="r${type.id}">
													<td><input type="checkbox" name="luo" value="${type.id}"/></td>
													<td>${status.index+1}</td>
													<td>${type.title}</td>
													<td>${type.keywords}</td>
													<td>
													<fmt:formatDate value="${type.createDate}" pattern="yyyy-MM-dd "/>
													</td>												
													<td>
														<!-- Icons -->
														<a href="javascript:del('${ctx}',${type.id});" title="删除文章信息"><img src="${ctx}/images/icons/cross.png" alt="删除文章信息" /></a>
														<a href="javascript:editType('${ctx}',${type.id})" title="修改文章信息"><img src="${ctx}/images/icons/hammer_screwdriver.png" alt="修改文章信息" /></a>
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
						<fieldset>

							<form method="post" id="datafrom" name="datafrom">
								<input type="hidden" name="onearticle.id" value="0" id="onearticletypeid"/>
								<input type="hidden" name="onearticlefile" value="0" id="onearticlefile"/>
								
									<!-- Set class to "column-left" or "column-right" on fieldsets to divide the form into columns -->
									<!--  
									<p >
										<label>
											文章类型
										</label>
										<select id="onetypeid" name="onearticle.typeid">
											<option>--请选择--</option>
										</select>
										<span class="input-notification information png_bg">文章类型,用于设置添加文章类型信息</span>
										
										<br />
									</p>
									 -->
									<p >
										<label>
											所属模块
										</label>
										<select id="navid" name="onearticle.navid">
											<option>--请选择--</option>
										</select>
										<span class="input-notification information png_bg">文章所属模块,用于设置文章属于哪个模块的信息</span>
										<!-- Classes for input-notification: success, error, information, attention -->
										<br />
									</p>
									<!-- 
									<p>
										<label>
											显示风格：
										</label>
										<select name="onearticle.styleid" id="styleid">
											<option value="0">---请选择---</option>
										</select>
										<span class="input-notification information png_bg"> 文章内容在网站上展示的风格</span>
										<br/>
									</p>
									<p>
										<label >
											首页显示：
										</label>
										<input type="checkbox" name="onearticle.top" id="top" value="true"/>显示
										<span class="input-notification attention png_bg">设置这篇文章是否在首页显示</span>
										
										<br />
									</p>
										<p>
										<label >
											前台显示：
										</label>
										<input type="checkbox" name="onearticle.show" id="show" value="true"/>显示
										<span class="input-notification attention png_bg">设置这篇文章是否在前台显示</span>
										
										<br />
									</p>
									<p>
										<label >
											审核状态：
										</label>
										<input type="checkbox" name="onearticle.shenhe" value="true" id="shenhe"/>已审核
										<span class="input-notification attention png_bg">管理员是否同意这篇文章的申请</span>
										<br/>
									</p>
								 -->
									<p >
										<label>
											文章标题
										</label>
										<input class="text-input small-input" type="text" id="title" name="onearticle.title" />
										
										<span class="input-notification information png_bg">文章名称,用于设置添加文章标题信息</span>
										<!-- Classes for input-notification: success, error, information, attention -->
										<br />
									</p>
									<p>
										<label>
											文章关键字
										</label>
										<input class="text-input small-input" type="text" id="keywords" name="onearticle.keywords" />
										<span class="input-notification information png_bg">文章关键字，用于设置添加文章关键字信息</span>
										<!-- Classes for input-notification: success, error, information, attention -->
										<br />
									</p>
									<!--
									<p >
										<label>
											文章来源
										</label>
										<input class="text-input small-input" type="text" id="source" name="onearticle.source" />
										<span class="input-notification information png_bg">文章来源，用于设置添加文章来源信息</span>
										
										<br />
									</p>
									<p >
										<label>
											文章作者
										</label>
										<input class="text-input small-input" type="text" id="author" name="onearticle.author" />
										<span class="input-notification information png_bg">文章作者，用于设置添加文章作者信息</span>
										
										<br />
									</p>
									  -->
									<p >
										<label>
											文章创建时间
										</label>
										<input class="text-input small-input" type="text" id="createDate" name="onearticle.createDate" />
										<span class="input-notification information png_bg">文章创建时间，用于设置添加文章创建时间信息</span>
										<!-- Classes for input-notification: success, error, information, attention -->
										<br />
									</p>
									<!-- 
										<p >
										<label>
											文章点击率
										</label>
										<input class="text-input small-input" type="text" id="click" name="onearticle.click" />
										<span class="input-notification information png_bg">文章点击率，用于设置添加文章点击率信息</span>
										
										<br />
									</p>
									 -->
									<p >
										<label>
											文章内容
										</label>
										
										<span class="input-notification information png_bg">文章内容，用于设置添加文章内容信息</span>
										<fck:editor instanceName="onearticle.content" width="900" height="600">
										
										</fck:editor>	
										<!-- Classes for input-notification: success, error, information, attention -->
										<br />
									</p>
										
									<p>
									<input class="button" type="submit" value="保存"/>
										
									</p>
									</form>
										<!-- ajax多文件上传 -->
									<form method="post" action="${ctx}/admin/article/upload" enctype="multipart/form-data" id="fileupload">
									<p>
										<label>
											附件：
										</label>
										<input class="multi" maxlength="5"  type="file" id="onearticlefile" name="onearticlefile" />
										<span class="input-notification information png_bg" id="tip">最多可以上传5个文件</span>
										<input  class="button" type="submit" value="上传"/>
										<!-- Classes for input-notification: success, error, information, attention -->
										<br />
									</p>
									</form>

								</fieldset>

								<div class="clear"></div>
								<!-- End .clear -->

							
							

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
