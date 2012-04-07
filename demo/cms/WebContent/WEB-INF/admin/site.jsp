<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>网站信息管理</title>
		<%@include file="/common/common.jsp"%>
		<script type="text/javascript" src="${ctx}/script/simpla.jquery.configuration.js"></script>
		<script type="text/javascript">
		function buildBottom(){
			$.post("${ctx}/admin/nav/bottom",null,function(data){
				var o = eval("("+data+")");
				if(!o.success){
					alert("生成底部 文件失败");
				}else{
					alert("生成底部 文件成功");
				}
			},'json');
		}	
		</script>
	</head>

	<body style="background-image: none;">
		<div id="main-content">
			<form action="${ctx}/admin/site/add" method="post">
				<input type="hidden" name="cfg.id" value="${cfg.id}" />
				<fieldset>
					<!-- Set class to "column-left" or "column-right" on fieldsets to divide the form into columns -->
					<p>
						<label>
							网站名称
						</label>
						<input class="text-input medium-input" type="text" id="small-input" name="cfg.webName" value="${cfg.webName}"/>
						<span class="input-notification information png_bg">请输入网站名称</span>
						<!-- Classes for input-notification: success, error, information, attention -->
						<br />
					</p>
					<p>
						<label>
							关键字
						</label>
						<input class="text-input medium-input" type="text" id="medium-input" name="cfg.keywords" value="${cfg.keywords}"/>
						<span class="input-notification information png_bg">请输入关键字信息，多个用英文(",")逗号分隔</span>
					</p>
					<p>
						<label>
							网站备案号
						</label>
						<input class="text-input medium-input" type="text" id="large-input" name="cfg.beian"  value="${cfg.beian}"/>
						<span class="input-notification information png_bg">请输入备案号信息，如:蜀ICP备XXXX号</span>
					</p>
					<p>
						<label>
							网站版权
						</label>
						<input class="text-input medium-input" type="text" id="large-input" name="cfg.copyright" value="${cfg.copyright}"/>
						<span class="input-notification information png_bg">请输入网站版权信息,如：版权所有&copy;新西软科技</span>	
					</p>
					<!-- 
					<p>
						<label>
							访问次数
						</label>
						<input class="text-input medium-input" type="text" id="large-input" name="cfg.webclick" value="${cfg.webclick}"/>
						<span class="input-notification information png_bg"> 查看网站访问次数</span>	
					</p>
					<p>
						<label>
							是否全站静态化
						</label>
						<input type="checkbox" name="cfg.html" checked="${cfg.html}"/>
						静态化
					</p>
					 -->
					<p>
						<input class="button" type="submit" value="保存" />
					</p>
					<p>
						<input class="button" type="button" value="生成底部页面" onclick="buildBottom()"/>
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
