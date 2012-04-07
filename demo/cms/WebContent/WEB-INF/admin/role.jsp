<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>角色管理</title>
		<%@include file="/common/common.jsp"%>
		<script type="text/javascript" src="${ctx}/script/role.js"></script>
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
						$("#roleid").val(0);
						$("#rolename").val('');
						$("#rolerule").val('');
						$("#role").html("添加角色");
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
							系统角色信息
						</h3>

						<ul class="content-box-tabs">
							<li>
								<a href="#tab1" class="default-tab">角色列表</a>
							</li>
							<li>
								<a href="#tab2" id="role">添加角色</a>
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
									你可以编辑以下角色信息
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
											角色名称
										</th>
										<th>
											优先级(数字越大优先级越高)
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
												<!-- 
												<a href="#" title="First Page">&laquo; First</a><a href="#"
													title="Previous Page">&laquo; Previous</a>
												<a href="#" class="number" title="1">1</a>
												<a href="#" class="number" title="2">2</a>
												<a href="#" class="number current" title="3">3</a>
												<a href="#" class="number" title="4">4</a>
												<a href="#" title="Next Page">Next &raquo;</a><a href="#"
													title="Last Page">Last &raquo;</a>
												-->
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
												<td colspan="5">没有角色信息，请先添加</td>
											</tr>
										</c:when>
										<c:otherwise>
											<c:forEach var="role" items="${pm.result}" varStatus="status">
												<tr id="r${role.id}">
													<td><input type="checkbox" value="${role.id}"/></td>
													<td>${status.index+1}</td>
													<td>${role.name}</td>
													<td>${role.rule}</td>
													<td>
														<!-- Icons -->
														<a href="${ctx}/admin/role/permission?id=${role.id}" title="编辑角色权限"><img src="${ctx}/images/icons/pencil.png" alt="编辑角色权限" /></a>
														<a href="javascript:delById('${ctx}',${role.id});" title="删除角色"><img src="${ctx}/images/icons/cross.png" alt="删除角色" /></a>
														<a href="javascript:editRole('${ctx}',${role.id})" title="修改角色"><img src="${ctx}/images/icons/hammer_screwdriver.png" alt="修改角色" /></a>
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
								<input type="hidden" name="roleid" value="0" id="roleid"/>
								<fieldset>
									<!-- Set class to "column-left" or "column-right" on fieldsets to divide the form into columns -->

									<p>
										<label>
											角色名称
										</label>
										<input class="text-input small-input" type="text"
											id="rolename" name="role.name" />
										<span class="input-notification information png_bg">角色的名称</span>
										<!-- Classes for input-notification: success, error, information, attention -->
										<br />
										<small>用于标志用户的权限</small>
									</p>
									<p>
										<label>
											优先级
										</label>
										<input class="text-input small-input" type="text"
											id="rolerule" name="role.rule" />
										<span class="input-notification information png_bg">角色的优先级</span>
										<!-- Classes for input-notification: success, error, information, attention -->
										<br />
										<small>在用户拥有几个角色的时候，产生冲突，那么奖优先选择优先级高的角色的权限</small>
									</p>
									<p>
										<input class="button" type="button" value="保存" onclick="addRole('${ctx}');"/>
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
