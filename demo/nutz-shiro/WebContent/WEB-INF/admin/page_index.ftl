<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>管理中心首页 - Powered By NUTZ</title>
<meta name="Author" content="NUTZ Team" />
<meta name="Copyright" content="NUTZ" />
<link rel="icon" href="favicon.ico" type="image/x-icon" />
<link href="${base}/template/admin/css/base.css" rel="stylesheet" type="text/css" />
<link href="${base}/template/admin/css/admin.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${base}/js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="${base}/template/admin/js/base.js"></script>
<script type="text/javascript" src="${base}/template/admin/js/admin.js"></script>
</head>
<body class="index">
	<div class="bar">
		欢迎使用NUTZ网店管理系统！
	</div>
	<div class="body">
		<div class="listTable">
		<table class="listTable">
				<tr>
					<th colspan="2">
						系统信息
					</th>
				</tr>
				<tr>
					<td width="110">
						Java版本: 
					</td>
					<td>
						${system['java.version']}
					</td>
				</tr>
				<tr>
					<td>
						操作系统名称: 
					</td>
					<td>${system['os.name']}
						
					</td>
				</tr>
				<tr>
					<td>
						操作系统构架: 
					</td>
					<td>
						${system['os.arch']}
					</td>
				</tr>
				<tr>
					<td>
						操作系统版本: 
					</td>
					<td>
						${system['os.version']}
					</td>
				</tr>
				<tr>
					<td>
						文件路径: 
					</td>
					<td>
						${system['java.io.tmpdir']}
					</td>
				</tr>
				<tr>
					<td>
						虚拟机实现供应商: 
					</td>
					<td>
						${system['java.vm.vendor']}
					</td>
				</tr>
				<tr>
					<td>
						会员总数: 
					</td>
					<td>
						${obj}
					</td>
				</tr>
			</table>
		</div>
		<div class="bodyRight">
			<div class="blank"></div>
		</div>
		<p class="copyright">Copyright © 2005-2011 xxx.com All Rights Reserved.</p>
	</div>
</body>
</html>