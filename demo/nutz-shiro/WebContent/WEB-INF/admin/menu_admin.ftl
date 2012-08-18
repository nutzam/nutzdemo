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
		<@shiro.hasRole name="admin">
			<dl>
				<dt>
					<span>管理员&nbsp;</span>
				</dt>
				<@shiro.hasRole name="admin">
					<dd>
						<a href="${base}/admin/list" target="mainFrame">管理员列表</a>
					</dd>
				</@shiro.hasRole>
				<@shiro.hasRole name="admin">
					<dd>
						<a href="${base}/admin/role/all" target="mainFrame">角色管理</a>
					</dd>
				</@shiro.hasRole>
			</dl>
		</@shiro.hasRole>
	</div>
</body>
</html>