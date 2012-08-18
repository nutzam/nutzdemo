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
		<@sec.authorize ifAnyGranted="ROLE_GOODS,ROLE_GOODS_NOTIFY">
			<dl>
				<dt>
					<span>商品管理&nbsp;</span>
				</dt>
				<@sec.authorize ifAnyGranted="ROLE_GOODS">
					<dd>
						<a href="goods!list.action" target="mainFrame">商品列表</a>
					</dd>
					<dd>
						<a href="goods!add.action" target="mainFrame">添加商品</a>
					</dd>
				</@sec.authorize>
				<@sec.authorize ifAnyGranted="ROLE_GOODS_NOTIFY">
					<dd>
						<a href="goods_notify!list.action" target="mainFrame">到货通知</a>
					</dd>
				</@sec.authorize>
			</dl>
		</@sec.authorize>
		<@sec.authorize ifAnyGranted="ROLE_GOODS_CATEGORY">
			<dl>
				<dt>
					<span>商品分类管理&nbsp;</span>
				</dt>
				<dd>
					<a href="goods_category!list.action" target="mainFrame">分类列表</a>
				</dd>
				<dd>
					<a href="goods_category!add.action" target="mainFrame">添加分类</a>
				</dd>
			</dl>
		</@sec.authorize>
		<@sec.authorize ifAnyGranted="ROLE_GOODS_TYPE,ROLE_GOODS_ATTRIBUTE">
			<dl>
				<dt>
					<span>商品类型管理&nbsp;</span>
				</dt>
				<@sec.authorize ifAnyGranted="ROLE_GOODS_TYPE">
					<dd>
						<a href="goods_type!list.action" target="mainFrame">类型列表</a>
					</dd>
					<dd>
						<a href="goods_type!add.action" target="mainFrame">添加类型</a>
					</dd>
				</@sec.authorize>
			</dl>
		</@sec.authorize>
		<@sec.authorize ifAnyGranted="ROLE_SPECIFICATION">
			<dl>
				<dt>
					<span>商品规格管理&nbsp;</span>
				</dt>
				<dd>
					<a href="specification!list.action" target="mainFrame">商品规格</a>
				</dd>
				<dd>
					<a href="specification!add.action" target="mainFrame">添加规格</a>
				</dd>
			</dl>
		</@sec.authorize>
		<@sec.authorize ifAnyGranted="ROLE_BRAND">
			<dl>
				<dt>
					<span>品牌管理&nbsp;</span>
				</dt>
				<dd>
					<a href="brand!list.action" target="mainFrame">品牌列表</a>
				</dd>
				<dd>
					<a href="brand!add.action" target="mainFrame">添加品牌</a>
				</dd>
			</dl>
		</@sec.authorize>
	</div>
</body>
</html>