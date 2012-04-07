<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<style type="text/css">
			body{display: none;}
		</style>
		<title>文章管理</title>
		<%@include file="/common/common.jsp"%>
		<script type="text/javascript" src="${ctx}/script/jquery.MetaData.js"></script>
		<script type="text/javascript" src="${ctx}/script/jquery.MultiFile.pack.js"></script>
		<script type="text/javascript" src="${ctx}/script/page.js"></script>
		<script type="text/javascript" src="${ctx}/script/article.js"></script>
		<script type="text/javascript" src="${ctx}/script/FilterHtml.js"></script>
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
						$("#articleid").val(0);
						$("#title").val('');
						$("#role").html("添加新文章");
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
				
				$("#articlefile").MultiFile();
				
				var options = {
						beforeSubmit:function(){
								var files = $("#articlefile").val();
								if(files!=""&&files!=0){
									alert("已经上传过文件，请勿重复上传");
									return false;
								}
						},
						success:function(responseText, statusText, xhr, $form){
							var o = eval("("+responseText+")");
							$("#articlefile").val(o.file);
							$('input:file').MultiFile('reset')
							$('#tip').html("文件上传成功，请勿重复上传");
						},
						url:'${ctx}/admin/article/upload',
						datatype:'json',
						type:'POST'
				};
				$("#fileupload").submit(function(){
					$(this).ajaxSubmit(options);
					return false;
				});
				
				//添加文章
				var option = {
						beforeSubmit:function(){
								
								var title = $.trim($("#title").val());
								if(title==""){
									alert("请填写文章标题");
									$("#title").focus();
									return false;
								}
								
								var date = $.trim($("#createDate").val());
								if(date==""){
									alert("请填写文章发布日期");
									$("#createDate").focus();
									return false;
								}
								
								var style = $.trim($("#styleid").val());
								if(style==0){
									alert("请选择模版样式 ");
									$("#styleid").focus();
									return false;
								}
								var nav = 0;
								$("#navid").find("option").each(function(){
									if(this.selected&&this.value!=0){
										nav += this.value+",";
									}
								});
								if(nav==0){
									alert("请选择文章模块");
									$("#navid").focus();
									return false;
								}
								var click = $.trim($("#click").val());
								$("#click").val(click);
						},
						success:function(responseText, statusText, xhr, form){
							var o = eval("("+responseText+")");
							if(o[0].success){
								var id = $("#articleid").val();
								if(id!=0){
									
								}else{
									
								}
								
								$("#fileupload").reset();
								alert("文章添加成功");
							}else{
								alert("添加文章失败");
							}
							$("#fileupload").reset();
						},
						url:'${ctx}/admin/article/add',
						datatype:'json',
						type:'POST'
				};
				$("#mainform").submit(function(){
					$(this).ajaxSubmit(option);
					return false;
				});
				
				Date.format = 'yyyy-mm-dd';
				$('#createDate').datePicker({clickInput:true});
				$('#pubtime').datePicker({clickInput:true});
			});	
			
//设置导航数据显示的样式

function processdd(o,str){
var option="";
<c:if test="${not empty navid}">
if(o.id==${navid}){
	option="<option value='"+o.id+"' selected='true'>"+str+o.text+"</option>";
}
else{
option="<option value='"+o.id+"'>"+str+o.text+"</option>";
}
</c:if>
	if(o.children){
		$(o.children).each(function(){
			option += processdd(this,str+"--");
		});
	}
	return option;
}
//查询全部
function searchAll(){
	window.location="${ctx}/admin/article?currentPage=1";
}
		</script>
		<style type="text/css">
			label{
				float: left;
			}
		</style>
	</head>
	<body style="background-image: none;">
			<!-- Wrapper for the radial gradient background -->
			<div id="main-content" style="width: 100%;height: 100%;margin-left: 0px;">
				<div class="content-box">
					<!-- Start Content Box -->

					<div class="content-box-header">

						<h3>
							文章管理
						</h3>

						<ul class="content-box-tabs">
							<li>
								<a href="#tab1" class="default-tab">文章信息列表</a>
							</li>
							<li>
								<a href="#tab2" id="role">添加新文章</a>
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
								<form action="${ctx}/admin/article/searchby" method="get">
									<input type="hidden" name="currentPage" value="1">
									导航名<select style="width:140px" id="navid2" name="navid"></select>
									时间<input class="Medium-input" type="text" id="pubtime" name="pubtime" size="8" value="${pubtime}" />

									　关键字<input type="text" value="${keyword}" name="keyword"/>
									　<input type="submit" value="查询">　<input type="button" value="查询全部" onclick="searchAll()"/></form>
									</input>
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
											文章描述
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
										<td colspan="7">
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
												<td colspan="7">没有文章分类信息，请先添加</td>
											</tr>
										</c:when>
										<c:otherwise>
											<c:forEach var="article" items="${pm.result}" varStatus="status">
												<tr id="r${article.id}">
													<td><input type="checkbox" name="xidx" value="${article.id}"/></td>
													<td>${status.index+1}</td>
													<td>${fn:substring(article.title,0,10)}</td>
													<td>${fn:substring(article.keywords,0,8)}</td>
													<td>${fn:substring(fht:delHTMLTag(article.content),0,20)}...</td>
													<td>
														<fmt:formatDate value="${article.createDate}" pattern="yyyy/MM/dd"/>
													</td>												
													<td>
														<!-- Icons -->
														<a href="javascript:delById('${ctx}',${article.id});" title="删除文章分类信息"><img src="${ctx}/images/icons/cross.png" alt="删除文章分类信息" /></a>
														<a href="javascript:edit('${ctx}',${article.id})" title="修改文章分类信息"><img src="${ctx}/images/icons/hammer_screwdriver.png" alt="修改文章分类信息" /></a>
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
								<form action="${ctx}/admin/article/add" method="post" id="mainform">
								<input type="hidden" name="a.id" value="0" id="articleid"/>
								<input type="hidden" name="articlefile" value="0" id="articlefile"/>
									<!-- Set class to "column-left" or "column-right" on fieldsets to divide the form into columns -->
									<p>
										<label style="color: red;">
											文章标题：
										</label>
										<input class="text-input small-input" type="text" id="title" name="a.title" />
										<select id="color" name="color">
											<option value="0">默认</option>
											<option value="1">红色</option>
											<option value="2">绿色</option>
											<option value="3">蓝色</option>
											
										</select>
										<span class="input-notification attention png_bg">输入文章的标题信息</span>
										<!-- Classes for input-notification: success, error, information, attention -->
										<br />
									</p>
									<p>
										<label>
											&nbsp;&nbsp;&nbsp;关键字：
										</label>
										<input class="text-input Medium-input" type="text" id="keywords" name="a.keywords" />
										<span class="input-notification information png_bg">文章的关键字 信息</span>
										<!-- Classes for input-notification: success, error, information, attention -->
										<br />
									</p>
									<p>
										<label>
											文章来源：
										</label>
										<input class="text-input Medium-input" type="text" id="source" name="a.source" />
										<span class="input-notification information png_bg">文章的来源信息,如：原创、转载等</span>
										<!-- Classes for input-notification: success, error, information, attention -->
										<br />
									</p>
									<p>
										<label>
											&nbsp;&nbsp;&nbsp;发布者：
										</label>
										<input class="text-input Medium-input" type="text" id="author" name="a.author" />
										<span class="input-notification information png_bg">文章的发布人或者是作者</span>
										<!-- Classes for input-notification: success, error, information, attention -->
										<br />
									</p>
									<p>
										<label>
											发布日期：
										</label>
										<input class="text-input Medium-input" type="text" id="createDate" name="a.createDate" />
										<span class="input-notification information png_bg">本网站发布文章的日期</span>
										<!-- Classes for input-notification: success, error, information, attention -->
										<br />
									</p>
									<p>
										<label>
											&nbsp;&nbsp;&nbsp;点击率：
										</label>
										<input class="text-input Medium-input" type="text" id="click" name="a.click" />
										<span class="input-notification information png_bg">文章被浏览的次数</span>
										<!-- Classes for input-notification: success, error, information, attention -->
										<br />
									</p>
									<p>
										<label style="color: red;">
											首页显示：
										</label>
										<input type="checkbox" name="a.top" id="top" value="true"/>显示
										<span class="input-notification attention png_bg">设置这篇文章是否在首页显示</span>
										<!-- Classes for input-notification: success, error, information, attention -->
										<br />
									</p>
									<p>
										<label style="color: red;">
											文章显示：
										</label>
										<input type="checkbox" name="a.show" id="show" checked="checked" value="true"/>显示
										<span class="input-notification attention png_bg">设置这篇文章是否在网站中显示</span>
										<br/>
									</p>
									<p>
										<label style="color: red;">
											图片新闻：
										</label>
										<input type="checkbox" name="a.hasPic" id="hasPic"  value="true"/>是
										<span class="input-notification attention png_bg">设置这篇文章是否是图片新闻的显示样式</span>
										<br/>
									</p>
									<p>
										<label style="color: red;">
											审核状态：
										</label>
										<input type="checkbox" name="a.shenhe" value="true" id="shenhe"/>已审核
										<span class="input-notification attention png_bg">管理员是否同意这篇文章的申请</span>
										<br/>
									</p>
									<!-- 
									<p>
										<label style="color: red;">
											文章分类：
										</label>
										<select name="a.typeid" id="typeid">
											<option value="0">---无分类---</option>
										</select>
										<span class="input-notification attention png_bg">管理员自定义的文章分类</span>
										<br/>
									</p>
									 -->
									<p>
										<label style="color: red;">
											显示风格：
										</label>
										<select name="a.styleid" id="styleid">
											<option value="0">---请选择---</option>
										</select>
										<span class="input-notification attention png_bg"> 文章内容在网站上展示的风格</span>
										<br/>
									</p>
									<p>
										<label style="color: red;">
											所属模块：
										</label>
										<select multiple="multiple" name="navid" id="navid" style="height: 150px;width: 300px;">
										</select>
										<span class="input-notification attention png_bg"> 文章内容在网站上属于哪个模块,只能选择<font color='red'>最后的子模块</font>，按住Shift可以多选</span>
										<br/>
									</p>
									<p>
										<label style="color: red;">
											文章内容：
										</label>
										<span class="input-notification attention png_bg"> 文章内容在网站上属于哪个模块</span>
										<fck:editor instanceName="a.content" width="900" height="600">
										
										</fck:editor>	
										<br/>
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
										<input class="multi" maxlength="5"  type="file" id="articlefile" name="articlefile" />
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
			<script type="text/javascript">
				load('${ctx}');
			</script>
	</body>
</html>
