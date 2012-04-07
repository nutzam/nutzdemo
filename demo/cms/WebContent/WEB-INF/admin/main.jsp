<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN""http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>Nws Content Manage System</title>
		<%@include file="/common/common.jsp"%>
		<script type="text/javascript" src="${ctx}/script/simpla.jquery.configuration.js"></script>
		<script>
			function load(url){
				$("#main-content").html("");
				var iframe = document.createElement("iframe");
				iframe.src = url;
				iframe.setAttribute('frameborder', '0', 0);
				iframe.setAttribute('scrolling', 'no', 0);
				$("#main-content").html(iframe);
			}
		</script>
		<style type="text/css">
			iframe{
				height:1500px;width:100%;
			}
		</style>
	</head>
	<body><div id="body-wrapper"> <!-- Wrapper for the radial gradient background -->
		
		<div id="sidebar"><div id="sidebar-wrapper"> <!-- Sidebar with logo and menu -->
			
			<h1 id="sidebar-title"><a href="#">Cms Admin</a></h1>
		  
			<!-- Logo (221px wide) -->
			<a href="#"><img id="logo" src="${ctx}/images/logo.png" alt="Simpla Admin logo" /></a>
		  
			<!-- Sidebar Profile links -->
			<div id="profile-links">
				你好, <a href="#" title="编辑你的资料">${sessionScope.admin.username}</a><!-- , 你有 <a href="#messages" rel="modal" title="3 Messages">3 条信息</a> --><br />
				<br />
				<a href="${ctx}/" title="点击查看网站首页信息">【网站】</a> | <a href="${ctx}/admin/logout" title="注销">注销</a>
			</div>        
			
			<ul id="main-nav">  <!-- Accordion Menu -->
				<!-- 
				<li>
					<a  href="javascript:load('http://www.google.cn');" class="nav-top-item no-submenu">
						谷歌
					</a>       
				</li>
				 -->
				<li> 
					<!-- Add the class "current" to current menu item current-->
					<security:check action="2" resource="1">
						<a href="#" class="nav-top-item "> 
						内容管理
						</a>
					</security:check>
					<ul>
						<!-- 
						<li><a href="javascript:load('${ctx}/admin/articletype?currentPage=1');">文章分类</a></li>
						 -->
						<security:check action="2" resource="2"> 
							<li><a href="javascript:load('${ctx}/admin/article?currentPage=1');">文章管理</a></li>
						</security:check>
						<!-- 
						<li><a href="javascript:load('${ctx}/admin/onearticletype?currentPage=1');">一篇文章分类</a></li>
						 -->
						<security:check action="2" resource="3">
							<li><a href="javascript:load('${ctx}/admin/onearticle?currentPage=1');">单页管理</a></li>
						</security:check>
						<security:check action="2" resource="4">
							<li><a href="javascript:load('${ctx}/admin/download?currentPage=1');">资料下载</a></li>
						</security:check>
						<security:check action="2" resource="19">
							<li><a href="javascript:load('${ctx}/admin/link?currentPage=1');">友情链接</a></li>
						</security:check>
						<!-- class="current" -->
					</ul>
				</li>
				
				<li>
					<security:check action="2" resource="5">
						<a href="#" class="nav-top-item">
							网站管理
						</a>
					</security:check>
					<ul>
					<security:check action="2" resource="6">
						<li><a href="javascript:load('${ctx}/admin/navmodel');">导航设置</a></li>
					</security:check>
					<security:check action="2" resource="7">	
						<li><a href="javascript:load('${ctx}/admin/templete?currentPage=1');">模版管理</a></li>
					</security:check>	
					<security:check action="2" resource="8">
						<li><a href="javascript:load('${ctx}/admin/indexpic?currentPage=1');">首页图片</a></li>
					</security:check>	
					</ul>
				</li>
				
				<li>
					<security:check action="2" resource="9">
						<a href="#" class="nav-top-item">
							留言及其他
						</a>
					</security:check>
					<ul>
						<!-- <li><a href="javascript:load('${ctx}/admin/message/messagetype');">留言模板设置</a></li> -->  <!-- Add class "current" to sub menu items also -->
						<security:check action="2" resource="10">
							<li><a href="javascript:load('${ctx}/admin/message/messagemanager?currentPage=1')">留言管理</a></li>
						</security:check>
						<security:check action="2" resource="11">
							<li><a href="javascript:load('${ctx}/admin/contact/find')">联系我们</a></li>
						</security:check>
						<security:check action="2" resource="12">
							<li><a href="javascript:load('${ctx}/admin/group?currentPage=1')">学术小组</a></li>
						</security:check>
					</ul>
				</li>
				
				<li>
					<security:check action="2" resource="13">
						<a href="#" class="nav-top-item">
							我的资料
						</a>
					</security:check>
					<ul>
						<security:check action="2" resource="14">
							<li><a href="javascript:load('${ctx}/admin/user/toupdatepwd')">修改密码</a></li>
						</security:check>
					</ul>
				</li>
				
				<li>
					<security:check action="2" resource="15">
						<a href="#" class="nav-top-item">
							系统设置
						</a>
					</security:check>
					<ul>
						<security:check action="2" resource="16">
							<li><a href="javascript:load('${ctx}/admin/site');">网站信息</a></li>
						</security:check>
						<security:check action="2" resource="17">
							<li><a href="javascript:load('${ctx}/admin/role?currentPage=1');">角色管理</a></li>
						</security:check>
						<security:check action="2" resource="18">
							<li><a href="javascript:load('${ctx}/admin/user?currentPage=1');">人员管理</a></li>
						</security:check>
						<!-- 
						<li><a href="#">数据管理</a></li>
						 -->
					</ul>
				</li>      
				
			</ul> <!-- End #main-nav -->
			
			<div id="messages" style="display: none"> <!-- Messages are shown when a link with these attributes are clicked: href="#messages" rel="modal"  -->
				
				<h3>3 Messages</h3>
			 
				<p>
					<strong>17th May 2009</strong> by Admin<br />
					Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus magna. Cras in mi at felis aliquet congue.
					<small><a href="#" class="remove-link" title="Remove message">Remove</a></small>
				</p>
			 
				<p>
					<strong>2nd May 2009</strong> by Jane Doe<br />
					Ut a est eget ligula molestie gravida. Curabitur massa. Donec eleifend, libero at sagittis mollis, tellus est malesuada tellus, at luctus turpis elit sit amet quam. Vivamus pretium ornare est.
					<small><a href="#" class="remove-link" title="Remove message">Remove</a></small>
				</p>
			 
				<p>
					<strong>25th April 2009</strong> by Admin<br />
					Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus magna. Cras in mi at felis aliquet congue.
					<small><a href="#" class="remove-link" title="Remove message">Remove</a></small>
				</p>
				
				<form action="#" method="post">
					
					<h4>New Message</h4>
					
					<fieldset>
						<textarea class="textarea" name="textfield" cols="79" rows="5"></textarea>
					</fieldset>
					
					<fieldset>
					
						<select name="dropdown" class="small-input">
							<option value="option1">Send to...</option>
							<option value="option2">Everyone</option>
							<option value="option3">Admin</option>
							<option value="option4">Jane Doe</option>
						</select>
						
						<input class="button" type="submit" value="Send" />
						
					</fieldset>
					
				</form>
				
			</div> <!-- End #messages -->
			
		</div></div> <!-- End #sidebar -->
		
<!-- 内容显示区域 -->		
		<div id="main-content"> <!-- Main Content Section with everything -->
			
			<noscript> <!-- Show a notification if the user has disabled javascript -->
				<div class="notification error png_bg">
					<div>
						你的浏览器不支持JavaScript,请打开你的浏览器的脚本支持。或者下载firfox\ie7+\chrome等浏览器
					</div>
				</div>
			</noscript>
			
			<!-- Page Head -->
			<h2>欢迎${sessionScope.admin.username}使用新西软内容管理系统</h2>
			<p id="page-intro">你想做什么呢？</p>
			
			<ul class="shortcut-buttons-set">
				
				<li><a class="shortcut-button" href="#"><span>
					<img src="${ctx}/images/icons/pencil_48.png" alt="icon" /><br />
					发布文章
				</span></a></li>
				
				<li><a class="shortcut-button" href="#"><span>
					<img src="${ctx}/images/icons/paper_content_pencil_48.png" alt="icon" /><br />
					创建栏目
				</span></a></li>
				
				<li><a class="shortcut-button" href="#"><span>
					<img src="${ctx}/images/icons/image_add_48.png" alt="icon" /><br />
					上传资料
				</span></a></li>
				
				<li><a class="shortcut-button" href="#"><span>
					<img src="${ctx}/images/icons/clock_48.png" alt="icon" /><br />
					添加任务
				</span></a></li>
				
				<li><a class="shortcut-button" href="#messages" rel="modal"><span>
					<img src="${ctx}/images/icons/comment_48.png" alt="icon" /><br />
					查看帮助
				</span></a></li>
				
			</ul><!-- End .shortcut-buttons-set -->
			
			<div class="clear"></div> <!-- End .clear -->
			
			<div class="content-box"><!-- Start Content Box -->
				
				<div class="content-box-header">				
					<h3>我的资料</h3>
					<div class="clear"></div>
				</div> <!-- End .content-box-header -->
				
				<div class="content-box-content">
					
					<div class="tab-content default-tab" id="tab1">
					
						<form action="#" method="post">
							
							<fieldset> <!-- Set class to "column-left" or "column-right" on fieldsets to divide the form into columns -->
								
								<p>
									<label>上次登录时间：</label>
									<input class="text-input medium-input" type="text" value='<fmt:formatDate value="${sessionScope.admin.lastLoginTime}" pattern="yyyy/MM/dd HH:mm:ss"/>' readonly="readonly"/> 
									<span class="input-notification information png_bg">这里记录了你上次登录的时间，如有不同请及时修改你的密码</span>
									<!-- Classes for input-notification: success, error, information, attention -->
									<br />
								</p>
								
								<p>
									<label>上次登录IP：</label>
									<input class="text-input medium-input" type="text" value="${sessionScope.admin.lastLoginIp}" readonly="readonly"/> 
									<span class="input-notification information png_bg">上次登录的IP地址信息</span>
									
								</p>
								
								<p>
									<label>登录次数</label>
									<input class="text-input medium-input" type="text" value="${sessionScope.admin.logintimes}" readonly="readonly"/>
									<span class="input-notification information png_bg">记录了你总共登录的次数</span>
								</p>
								
							</fieldset>
							
							<div class="clear"></div><!-- End .clear -->
							
						</form>
						
					</div> <!-- End #tab2 -->        
					
				</div> <!-- End .content-box-content -->
				
			</div> <!-- End .content-box -->
			
			<div id="footer">
				<small> <!-- Remove this notice or replace it with whatever you want -->
						&#169; Copyright 2009  新西软科技| Powered by <a href="http://themeforest.net/item/simpla-admin-flexible-user-friendly-admin-skin/46073">Shine</a> | <a href="#">Top</a>
				</small>
			</div><!-- End #footer -->
			
			</div> <!-- End #main-content -->
		
		</div>
	</body>

</html>
