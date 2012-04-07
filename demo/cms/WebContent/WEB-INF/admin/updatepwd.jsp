<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>网站信息管理</title>
		<%@include file="/common/common.jsp"%>
		<script type="text/javascript" src="${ctx}/script/jquery.form.js"></script>
		<script type="text/javascript" src="${ctx}/script/simpla.jquery.configuration.js"></script>
		<script type="text/javascript">

				$(document).ready(function(){	
		$("#dataform").submit(function(){
			$(this).ajaxSubmit({
				beforeSubmit:function(){
				var newp=document.getElementById("newp").value;
				var newpwd=document.getElementById("newpwd").value;
				if(newp!=newpwd){
					document.getElementById("newpd").innerHTML="您输入两次密码不一致，请检查";
					return false;
				}
				if(newp==""){
					document.getElementById("newpwdd").innerHTML="请输入新密码";
					return false;
				}
				},
				success:function(data){
				var o = eval("("+eval("("+data+")")+")");
					if(o.success){
						alert("设置成功！");
					}else{
					
						document.getElementById("pwdo").innerHTML="原始密码错误，请重新填写";
					
					}
				},
				url:"${ctx}/admin/user/updatepwd",
				type:'post'
			});
			return false;
		});
		});
		</script>
	</head>

	<body style="background-image: none;">
		<div id="main-content">
			<form id="dataform"  method="post">
				<input type="hidden" name="user.id" value="${sessionScope.admin.id}" />
				<fieldset>
					<!-- Set class to "column-left" or "column-right" on fieldsets to divide the form into columns -->
					<p>
						<label>
							管理员登录名
						</label>
						<input class="text-input medium-input" type="text" id="small-input" name="user.username"  value="${sessionScope.admin.username}" readonly="readonly"/>
						<!-- Classes for input-notification: success, error, information, attention -->
						<br/>
					</p>
					<p>
						<label>
							旧密码
						</label>
						<input class="text-input medium-input" type="password" name="oldpwd" id="oldpwd"/>
						<span class="input-notification information png_bg" id="pwdo">请输入旧密码</span>
					</p>
					<p>
						<label>
							新密码
						</label>
						<input class="text-input medium-input" type="password" name="user.password" id="newp"/>
						<span class="input-notification information png_bg" id="newpwdd">请输入新密码</span>
					</p>
					<p>
						<label>
							确认新密码
						</label>
						<input class="text-input medium-input" type="password" id="newpwd"/>
						<span class="input-notification information png_bg" id="newpd">请再次输入新密码</span>	
					</p>

					<p>
						<input class="button" type="submit" value="保存" />
					</p>

				</fieldset>

				<div class="clear"></div>
				<!-- End .clear -->

			</form>

		</div>
		<!-- End #tab2 -->

		<!-- End .content-box -->
		<div class="clear"></div>
		<div id="footer">
				<small> <!-- Remove this notice or replace it with whatever you want -->
						&#169; Copyright 2009  新西软科技| Powered by <a href="http://themeforest.net/item/simpla-admin-flexible-user-friendly-admin-skin/46073">Shine</a> | <a href="#">Top</a>
				</small>
			</div><!-- End #footer -->
		<!-- End #main-content -->
	</body>
</html>
