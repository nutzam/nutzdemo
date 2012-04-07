<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>友情链接管理</title>
		<%@include file="/common/common.jsp"%>
		<script type="text/javascript" src="${ctx}/script/page.js"></script>
		
		<script type="text/javascript" src="${ctx}/script/link.js"></script>
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
						$("#role").html("添加友情链接");
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
			

		
	
			
		</script>
	</head>
	<body style="background-image: none;">
			<!-- Wrapper for the radial gradient background -->
			<div id="main-content" style="width: 100%;height: 100%;margin-left: 0px;">
				<div class="content-box">
					<!-- Start Content Box -->

					<div class="content-box-header">

						<h3>
							友情链接信息
						</h3>

						<ul class="content-box-tabs">
							<li>
								<a href="#tab1" class="default-tab">友情链接列表</a>
							</li>
							<li>
								<a href="#tab2" id="role">添加友情链接</a>
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
									你可以编辑以下友情链接信息
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
											友情链接类型
										</th>
										<th>
											友情链接名称
										</th>
										<th>
											链接地址
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
												<td colspan="5">没有友情链接信息，请先添加</td>
											</tr>
										</c:when>
										<c:otherwise>
											<c:forEach var="type" items="${pm.result}" varStatus="status">
												<tr id="r${type.id}">
													<td><input type="checkbox" value="${type.id}" name="luo"/></td>
													<td>${status.index+1}</td>
													<td>${type.type}</td>
													<td>${type.name}</td>
													<td>${type.url}</td>												
													<td>
														<!-- Icons -->
														<a href="javascript:del('${ctx}',${type.id});" title="删除友情链接信息"><img src="${ctx}/images/icons/cross.png" alt="删除友情链接信息" /></a>
														
														<a href="javascript:editType('${ctx}',${type.id})" title="修改友情链接信息"><img src="${ctx}/images/icons/hammer_screwdriver.png" alt="修改友情链接信息" /></a>
													
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
								<input type="hidden" name="link.id" value="0" id="linkid"/>
								
								<fieldset>
									<!-- Set class to "column-left" or "column-right" on fieldsets to divide the form into columns -->
									<p>
										<label>
											友情链接类型
										</label>
										<select id="type" name="link.type">
											<option value="1">国内相关学院</option>
											<option value="2">国内相关科研院所</option>
											<option value="3">国外相关大学、研究机构</option>
										</select>
										<span class="input-notification information png_bg">友情链接类型，用于设置添加友情链接的类型</span>
										<!-- Classes for input-notification: success, error, information, attention -->
										<br />
									</p>
									<p>
										<label>
											友情链接名称
										</label>
										<input class="text-input small-input" type="text" id="name" name="link.name" />
										<span class="input-notification information png_bg">友情链接名称，用于设置添加友情链接的名称</span>
										<!-- Classes for input-notification: success, error, information, attention -->
										<br />
									</p>
									<p>
										<label>
											友情链接地址
										</label>
										<input class="text-input small-input" type="text" id="filepath" name="link.url" />
										<span class="input-notification information png_bg">友情链接地址，用于设置友情链接的链接地址</span>
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
