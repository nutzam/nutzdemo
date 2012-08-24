<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>文章分类列表 - Powered By SHOP++</title>
<meta name="Author" content="SHOP++ Team" />
<meta name="Copyright" content="SHOP++" />
<link rel="icon" href="favicon.ico" type="image/x-icon" />
<link href="${base}/template/admin/css/base.css" rel="stylesheet" type="text/css" />
<link href="${base}/template/admin/css/admin.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${base}/template/common/js/jquery.js"></script>
<script type="text/javascript" src="${base}/template/admin/js/base.js"></script>
<script type="text/javascript" src="${base}/template/admin/js/admin.js"></script>
<script type="text/javascript">
$(document).ready(function() {

	var $deleteArticleCategory = $("#listTable .deleteArticleCategory");
	var $articleCategoryName = $("#listTable .articleCategoryName");

	// 删除商品分类
	$deleteArticleCategory.click( function() {
		if (confirm("您确定要删除此文章分类吗?") == false) {
			return false;
		}
	});

	// 树折叠
	$articleCategoryName.click( function() {
		var $this = $(this);
		var grade = $this.parent().attr("grade");
		var isHide;
		$this.parent().nextAll("tr").each(function(){
			$this = $(this);
			var thisLevel = $this.attr("grade");
			if(thisLevel <=  grade) {
				return false;
			}
			if(isHide == null) {
				if($this.is(":hidden")){
					isHide = true;
				} else {
					isHide = false;
				}
			}
			if(isHide) {
				$this.show();
			} else {
				$this.hide();
			}
		});
	});	
})
</script>
</head>
<body class="list">
	<div class="bar">
		文章分类列表&nbsp;总记录数: ${articleCategoryTreeList?size}
	</div>
	<div class="body articleCategory">
		<form id="listForm" action="article_category!list.action" method="post">
			<div class="listBar">
				<input type="button" class="formButton" onclick="location.href='article_category!add.action'" value="添加分类" hidefocus />
			</div>
			<table id="listTable" class="listTable">
				<tr>
					<th>
						<span>分类名称</span>
					</th>
					<th>
						<span>排序</span>
					</th>
					<th>
						<span>操作</span>
					</th>
				</tr>
				<#list articleCategoryTreeList as articleCategory>
					<tr grade="${articleCategory.grade}">
						<td class="articleCategoryName">
							<#if articleCategory.grade == 0>
								<span class="pointer firstCategory" style="margin-left: ${articleCategory.grade * 20}px;">
									${articleCategory.name}
								</span>
							<#else>
								<span class="pointer category" style="margin-left: ${articleCategory.grade * 20}px;">
									${articleCategory.name}
								</span>
							</#if>
						</td>
						<td>
							${articleCategory.orderList}
						</td>
						<td>
							<a href="${base}${articleCategory.url}" target="_blank" title="浏览">[浏览]</a>
							<#if (articleCategory.children?size > 0)>
								<span title="无法删除">[删除]</span>
							<#else>
								<a href="article_category!delete.action?id=${articleCategory.id}" class="deleteArticleCategory" title="删除">[删除]</a>
							</#if>
							<a href="article_category!edit.action?id=${articleCategory.id}" title="编辑">[编辑]</a>
						</td>
					</tr>
				</#list>
			</table>
			<#if articleCategoryTreeList?size == 0>
				<div class="noRecord">没有找到任何记录!</div>
			</#if>
		</form>
	</div>
</body>
</html>