<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>学术小组</title>
		<%@include file="/common/common.jsp"%>
		<script type="text/javascript" src="${ctx}/script/ajaxfileupload.js"></script>
		<script type="text/javascript" src="${ctx}/script/group.js"></script>
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
						$("#sortNumber").val('');
						$("#role").html("添加新小组");
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
			

	function edit(prefix,id){
	
	var url=prefix+"/admin/group/find";
	
	$.post(url,{"id":id},function(data){
		
		var o = eval("("+data+")");
		
		if(o.id!=0){
			
			$("#id").val(o.id);
			
			$("#target").val(o.groupitems);
			$("#sortNumber").val(o.sortNumber);
			$("#href").val(o.groupleader);
			$("#name").val(o.groupname);
			
			var a = $('.content-box ul.content-box-tabs li a');
			$(a).parent().siblings().find("a").removeClass('current');
			$(a).addClass('current');
			$("#role").html("修改小组信息");
			$(".default-tab").removeClass('current');
			$("#tab1").hide(); 
			$("#tab2").show();
		}else{
			alert("小组信息不存在");
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
							学术小组管理
						</h3>

						<ul class="content-box-tabs">
							<li>
								<a href="#tab1" class="default-tab">学术小组列表</a>
							</li>
							<li>
								<a href="#tab2" id="role">添加新小组</a>
							</li>
						</ul>

						<div class="clear"></div>

					</div>
					<!-- End .content-box-header -->

					<div class="content-box-content">

						<div class="tab-content default-tab" id="tab1">
							<!-- This is the target div. id must match the href of this div's tab -->

							<div class="notification attention png_bg">
								<a href="#" class="close">
								<img src="${ctx}/images/icons/cross_grey_small.png" title="Close this notification" alt="close" />
								</a>
								<div>
									你可以编辑以下小组
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
											小组名称
										</th>
										<th>
											组长
										</th>
										<th>
											添加时间
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
											<c:forEach var="group" items="${pm.result}" varStatus="status">
												<tr id="r${group.id}">
													<td><input type="checkbox" value="${group.id}"/></td>
													<td>${status.index+1}</td>
													<td>${group.groupname}</td>
													<td>${group.groupleader}</td>
													<td>
														<fmt:formatDate value="${group.createDate}" pattern="yyyy/MM/dd"/>
													</td>
													<td>
														<!-- Icons -->
														<a href="javascript:delById('${ctx}',${group.id});" title="删除小组"><img src="${ctx}/images/icons/cross.png" alt="删除小组" /></a>	
													<a href="javascript:edit('${ctx}',${group.id})" title="修改小组信息"><img src="${ctx}/images/icons/hammer_screwdriver.png" alt="修改小组信息" /></a>
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
								<input type="hidden" name="group.id" value="0" id="id"/>
								<fieldset>
									<!-- Set class to "column-left" or "column-right" on fieldsets to divide the form into columns -->

									<p>
										<label>
											小组名称
										</label>
										<input class="text-input small-input" type="text"
											id="name" name="group.groupname" />
										<span class="input-notification information png_bg">学术小组名称</span>
										<!-- Classes for input-notification: success, error, information, attention -->
										<br />
									</p>
									<p>
										<label>
											组长名字
										</label>
										<input class="text-input small-input" type="text" id="href" name="group.groupleader"/>
										<span class="input-notification information png_bg">小组负责人</span>
										<!-- Classes for input-notification: success, error, information, attention -->
										<br />
									</p>
									<p>
										<label>
											排序号码
										</label>
										<input class="text-input small-input" type="text"
											id="sortNumber" name="group.sortNumber" value="#"/>
										<span class="input-notification information png_bg">用于指定小组展示的顺序，数字越大越前</span>
										<!-- Classes for input-notification: success, error, information, attention -->
										<br />
									</p>
									<p>
										<label>
											小组成员
										</label>
										<span class="input-notification attention png_bg">
											名字和链接以","分割，人与人以"|"分割
											如:袁书记,http://www.life.uestc.edu.cn|尧院长,http://xxxxx
										</span>
										<textarea rows="20" cols="20" id="target" name="group.groupitems"></textarea>
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
