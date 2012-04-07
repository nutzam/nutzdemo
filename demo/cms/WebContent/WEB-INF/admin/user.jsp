<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>管理员管理</title>
		<%@include file="/common/common.jsp"%>
		<script type="text/javascript" src="${ctx}/script/user.js"></script>
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
						$("#userid").val(0);
						$("#useruername").val('');
						$("#userpassword").val('');
						document.getElementById("userstate").checked = true;
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
							系统管理员信息
						</h3>

						<ul class="content-box-tabs">
							<li>
								<a href="#tab1" class="default-tab">管理员列表</a>
							</li>
							<li>
								<a href="#tab2" id="role">添加管理员</a>
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
									你可以编辑以下管理员信息
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
											用户名
										</th>
										<th>
											密码
										</th>
										<th>
											登录时间
										</th>
										<th>
											登录次数
										</th>
										<th>
											状态
										</th>
										<th>
											操作
										</th>
									</tr>

								</thead>

								<tfoot>
									<tr>
										<td colspan="8">
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
												<td colspan="5">没有管理员信息，请先添加</td>
											</tr>
										</c:when>
										<c:otherwise>
											<c:forEach var="user" items="${pm.result}" varStatus="status">
												<tr id="r${user.id}">
													<td><input type="checkbox" value="${user.id}"/></td>
													<td>${status.index+1}</td>
													<td>${user.username}</td>
													<td>${user.password}</td>
													<td><fmt:formatDate value="${user.loginTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
													<td>${user.logintimes}</td>
													<td>
														<c:choose>
															<c:when test="${user.state}">
																启用
															</c:when>
															<c:otherwise>
																禁用
															</c:otherwise>
														</c:choose>
													</td>
													<td>
														<!-- Icons -->
														<a href="${ctx}/admin/role/set?uid=${user.id}" title="设置管理员角色"><img src="${ctx}/images/icons/pencil.png" alt="设置管理员角色" /></a>
														<a href="javascript:delById('${ctx}',${user.id});" title="删除管理员"><img src="${ctx}/images/icons/cross.png" alt="删除管理员" /></a>
														<a href="javascript:editUser('${ctx}',${user.id})" title="修改管理员信息"><img src="${ctx}/images/icons/hammer_screwdriver.png" alt="修改管理员信息" /></a>
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
								<input type="hidden" name="user.id" value="0" id="userid"/>
								<fieldset>
									<!-- Set class to "column-left" or "column-right" on fieldsets to divide the form into columns -->

									<p>
										<label>
											管理员用户名
										</label>
										<input class="text-input small-input" type="text" id="userusername" name="user.username" />
										<span class="input-notification information png_bg">管理员用户名可以为数字、字母、下划线</span>
										<!-- Classes for input-notification: success, error, information, attention -->
										<br />
										<small>用于登录后台进行管理的帐号名称</small>
									</p>
									<p>
										<label>
											用户密码
										</label>
										<input class="text-input small-input" type="text" id="userpassword" name="user.password" />
										<span class="input-notification information png_bg">密码为数字和字母</span>
										<!-- Classes for input-notification: success, error, information, attention -->
										<br />
										<small>用于登录系统的密码</small>
									</p>
									<p>
										<label>
											状态
										</label>
										<input type="checkbox" name="user.state" id="userstate" checked="checked"/> 启用该帐号
										<span class="input-notification information png_bg">勾选上为启用帐号,默认为启用</span>
										<!-- Classes for input-notification: success, error, information, attention -->
										<br />
									</p>
									<p>
										<input class="button" type="button" value="保存" onclick="addUser('${ctx}');"/>
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
