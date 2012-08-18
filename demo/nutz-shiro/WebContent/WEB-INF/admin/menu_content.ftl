<#assign sec=JspTaglibs["/WEB-INF/tld/security.tld"] />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>管理菜单 - Powered By SHOP++</title>
<meta name="Author" content="SHOP++ Team" />
<meta name="Copyright" content="SHOP++" />
<link rel="icon" href="favicon.ico" type="image/x-icon" />
<link href="${base}/template/admin/css/base.css" rel="stylesheet" type="text/css" />
<link href="${base}/template/admin/css/admin.css" rel="stylesheet" type="text/css" />
</head>
<body class="menu">
	<div class="body">
		<@sec.authorize ifAnyGranted="ROLE_NAVIGATION,ROLE_ARTICLEE,ROLE_ARTICLE_CATEGORY,ROLE_FRIEND_LINK">
			<dl>
				<dt>
					<span>内容管理</span>
				</dt>
				<@sec.authorize ifAnyGranted="ROLE_NAVIGATION">
					<dd>
						<a href="navigation!list.action" target="mainFrame">导航管理</a>
					</dd>
				</@sec.authorize>
				<@sec.authorize ifAnyGranted="ROLE_ARTICLEE">
					<dd>
						<a href="article!list.action" target="mainFrame">文章管理</a>
					</dd>
				</@sec.authorize>
				<@sec.authorize ifAnyGranted="ROLE_ARTICLE_CATEGORY">
					<dd>
						<a href="article_category!list.action" target="mainFrame">文章分类</a>
					</dd>
				</@sec.authorize>
				<@sec.authorize ifAnyGranted="ROLE_FRIEND_LINK">
					<dd>
						<a href="friend_link!list.action" target="mainFrame">友情链接</a>
					</dd>
				</@sec.authorize>
			</dl>
		</@sec.authorize>
		<@sec.authorize ifAnyGranted="ROLE_PAGE_TEMPLATE,ROLE_MAIL_TEMPLATE,ROLE_PRINT_TEMPLATE">
			<dl>
				<dt>
					<span>模板管理</span>
				</dt>
				<@sec.authorize ifAnyGranted="ROLE_PAGE_TEMPLATE">
					<dd>
						<a href="page_template!list.action" target="mainFrame">页面模板管理</a>
					</dd>
				</@sec.authorize>
				<@sec.authorize ifAnyGranted="ROLE_MAIL_TEMPLATE">
					<dd>
						<a href="mail_template!list.action" target="mainFrame">邮件模板管理</a>
					</dd>
				</@sec.authorize>
				<@sec.authorize ifAnyGranted="ROLE_PRINT_TEMPLATE">
					<dd>
						<a href="print_template!list.action" target="mainFrame">打印模板管理</a>
					</dd>
				</@sec.authorize>
			</dl>
		</@sec.authorize>
		<@sec.authorize ifAnyGranted="ROLE_CACHE">
			<dl>
				<dt>
					<span>缓存管理</span>
				</dt>
				<dd>
					<a href="cache!flush.action" target="mainFrame">更新缓存</a>
				</dd>
			</dl>
		</@sec.authorize>
		<@sec.authorize ifAnyGranted="ROLE_BUILD_HTML">
			<dl>
				<dt>
					<span>网站静态管理</span>
				</dt>
				<dd>
					<a href="build_html!allInput.action" target="mainFrame">一键网站更新</a>
				</dd>
				<dd>
					<a href="build_html!articleInput.action" target="mainFrame">文章更新</a>
				</dd>
				<dd>
					<a href="build_html!goodsInput.action" target="mainFrame">商品更新</a>
				</dd>
			</dl>
		</@sec.authorize>
	</div>
</body>
</html>