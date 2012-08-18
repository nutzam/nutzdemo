<#assign shiro=JspTaglibs["/WEB-INF/tld/shiro.tld"] />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>管理菜单 - Powered By NUTZ</title>
<meta name="Author" content="NUTZ Team" />
<meta name="Copyright" content="NUTZ" />
<link rel="icon" href="favicon.ico" type="image/x-icon" />
<link href="${base}/template/admin/css/base.css" rel="stylesheet" type="text/css" />
<link href="${base}/template/admin/css/admin.css" rel="stylesheet" type="text/css" />
</head>
<body class="menu">
	<div class="body">
		<@shiro.hasRole name ="admin">
			<dl>
				<dt>
					<span>网站设置</span>
				</dt>
				<@shiro.hasPermission name="*:*:*">
					<dd>
						<a href="setting/edit" target="mainFrame">系统设置</a>
					</dd>
				</@shiro.hasPermission>
			</dl>
		</@shiro.hasRole>
	</div>
</body>
</html>