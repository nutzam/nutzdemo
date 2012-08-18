<#assign shiro=JspTaglibs["/WEB-INF/tld/shiro.tld"] />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>管理中心 - Powered By NUTZ</title>
<meta name="Author" content="NUTZ Team" />
<meta name="Copyright" content="NUTZ" />
<link rel="icon" href="favicon.ico" type="image/x-icon" />
<link href="${base}/template/admin/css/base.css" rel="stylesheet" type="text/css" />
<link href="${base}/template/admin/css/admin.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${base}/js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="${base}/template/admin/js/base.js"></script>
<script type="text/javascript" src="${base}/template/admin/js/admin.js"></script>
<script type="text/javascript">
$().ready(function() {

	var $menuItem = $("#menu .menuItem");
	var $previousMenuItem;
	
	$menuItem.click( function() {
		var $this = $(this);
		if ($previousMenuItem != null) {
			$previousMenuItem.removeClass("current");
		}
		$previousMenuItem = $this;
		$this.addClass("current");
	})

})
</script>
</head>
<body class="header">
	<div class="body">
		<div class="bodyLeft">
			<div class="logo"></div>
		</div>
		<div class="bodyRight">
			<div class="link">
				<span class="welcome">
					<strong><@shiro.principal /></strong>&nbsp;您好!&nbsp;
				</span>
				<a href="page/index" target="mainFrame">后台首页</a>|
            	<a href="#" target="_blank">技术支持</a>|
                <a href="#" target="_blank">关于我们</a>|
                <a href="#" target="_blank">联系我们</a>
			</div>
			<div id="menu" class="menu">
				<ul>
					<@shiro.hasRole name="admin">
						<li class="menuItem">
							<a href="${base}/admin/menu/admin" target="menuFrame" hidefocus>管理员</a>
						</li>
					</@shiro.hasRole>
					<li class="home">
						<a href="${base}/" target="_blank" hidefocus>网站首页</a>
					</li>
	            </ul>
	            <div class="info">
					<a class="profile" href="admin_profile/edit" target="mainFrame">个人资料</a>
					<a class="logout" href="${base}/admin/usr/logout" target="_top">退出</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>