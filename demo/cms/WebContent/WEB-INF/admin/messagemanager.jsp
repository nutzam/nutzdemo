<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>一篇文章管理</title>
		<%@include file="/common/common.jsp"%>
		<script type="text/javascript" src="${ctx}/script/message.js"></script>
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
							留言管理
						</h3>

						<ul class="content-box-tabs">
							<li>
								<a href="#tab1" class="default-tab">留言列表</a>
							</li>
						<li>
								<a href="#tab2" id="role">留言详细</a>
							</li>
								
						</ul>

						<div class="clear"></div>

					</div>
					<!-- End .content-box-header -->

					<div class="content-box-content">

						<div class="tab-content default-tab" id="tab1">
							<!-- This is the target div. id must match the href of this div's tab -->

			<!--				<div class="notification attention png_bg">
								<a href="#" class="close"><img
										src="${ctx}/images/icons/cross_grey_small.png"
										title="Close this notification" alt="close" />
								</a>
								<div>
									你可以编辑以下文章信息
								</div>
							</div>-->

							<table>

								<thead>
									<tr>
										<th>
											<input class="check-all" type="checkbox" />
										</th>
										<th>
											编号
										</th>
										<th>
											留言人
										</th>
										<th>
											留言时间
										</th>
										<th>
											正文
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
												<form action="${ctx}/admin/message/messagemanager?currentPage=1" method="post">
												<c:if test="${not empty alltype}">
												条件查询：<select name="tid">
													<c:forEach var="alltype" items="${alltype}">
														<c:if test="${alltype.id==tid}">
														<option value="${alltype.id}" selected="true">${alltype.name}</option>
														</c:if>
														<c:if test="${alltype.id!=tid}">
														<option value="${alltype.id}">${alltype.name}</option>
														</c:if>
													</c:forEach>
												</select>
												<input type="submit" vallue="条件查询">
												</c:if>
												</form>
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
													<td><input type="checkbox" value="${type.id}"/></td>
													<td>${status.index+1}</td>
													<td>${type.vistor}</td>
													<td><fmt:formatDate value="${type.insertTime}" pattern="yyyy-MM-dd"/></td>	
													<td>${fn:substring(type.content,0,20)}</td>										
													<td>
														<!-- Icons -->
														<a href="javascript:delById('${ctx}',${type.id});" title="删除文章信息"><img src="${ctx}/images/icons/cross.png" alt="删除文章信息" /></a>
														<a href="javascript:editMessage('${ctx}',${type.id})" title="修改文章信息"><img src="${ctx}/images/icons/hammer_screwdriver.png" alt="修改文章信息" /></a>
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

							
								<input type="hidden" name="type.id" value="0" id="onearticletypeid"/>
								<fieldset>
									<!-- Set class to "column-left" or "column-right" on fieldsets to divide the form into columns -->
									<p >
										<label>
											留言类型
										</label>
										<input class="text-input small-input" type="text" id="type" name="title" />
										<!-- Classes for input-notification: success, error, information, attention -->
										<br />
									</p>
								
									<p>
										<label>
											留&nbsp;言&nbsp;&nbsp;人
										</label>
										<input class="text-input small-input" type="text" id="vistor" name="vistor" />
										
										<!-- Classes for input-notification: success, error, information, attention -->
										<br />
									</p>
									<p >
										<label>
											留言时间
										</label>
										<input class="text-input small-input" type="text" id="insertTime" name="insertTime" />
										
									
										<!-- Classes for input-notification: success, error, information, attention -->
										<br />
									</p>
									<p >
										<label>
											留言内容
										</label>
										<textarea rows="5" cols="60" name="content" id="content"></textarea>
										
										<!-- Classes for input-notification: success, error, information, attention -->
										<br />
									</p>
									<p style="display:none" id="isdisptel">
										<label>
											留言人电话号码
										</label>
										<input class="text-input small-input" type="text" id="tel" name="tel" />
										
										<!-- Classes for input-notification: success, error, information, attention -->
										<br />
									</p>
									<p style="display:none" id="isdispphone">
										<label>
											留言人手机号码
										</label>
										<input class="text-input small-input" type="text" id="phone" name="phone" />
					
										<!-- Classes for input-notification: success, error, information, attention -->
										<br />
									</p>
									<p style="display:none" id="isdispemail">
										<label>
											留言人email
										</label>
										<input class="text-input small-input" type="text" id="email" name="email" />
										<!-- Classes for input-notification: success, error, information, attention -->
										<br />
									</p>
										<p style="display:none" id="isdispreplayTime">
										<label>
											回复时间
										</label>
										<input class="text-input small-input" type="text" id="replayTime" name="replayTime" />
										
										<!-- Classes for input-notification: success, error, information, attention -->
										<br />
									</p>
									<form id="form1" name="form1" method="post">
											<p style="display:none" id="replay">
										<label>
											回　　复
										</label>
										<input class="text-input small-input" type="hidden" id="pkid" name="pkid" />
										<textarea rows="5" cols="60" name="replayContent" id="replayContent"></textarea>
										
										<!-- Classes for input-notification: success, error, information, attention -->
										<br />
									</p>
									<p style="display:none" id="isreply">
										<input class="button" type="button" value="保存" onclick="update('${ctx}');"/>
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