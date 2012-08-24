<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>添加/编辑文章 - Powered By SHOP++</title>
<meta name="Author" content="SHOP++ Team" />
<meta name="Copyright" content="SHOP++" />
<link rel="icon" href="favicon.ico" type="image/x-icon" />
<link href="${base}/template/admin/css/base.css" rel="stylesheet" type="text/css" />
<link href="${base}/template/admin/css/admin.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${base}/js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="${base}/template/common/js/jquery.validate.js"></script>
<script type="text/javascript" src="${base}/template/common/js/jquery.validate.methods.js"></script>
<script type="text/javascript" src="${base}/template/common/editor/kindeditor.js"></script>
<script type="text/javascript" src="${base}/template/admin/js/base.js"></script>
<script type="text/javascript" src="${base}/template/admin/js/admin.js"></script>
<script type="text/javascript">
$().ready(function() {

	var $validateErrorContainer = $("#validateErrorContainer");
	var $validateErrorLabelContainer = $("#validateErrorContainer ul");
	var $validateForm = $("#validateForm");
	
	// 表单验证
	$validateForm.validate({
		errorContainer: $validateErrorContainer,
		errorLabelContainer: $validateErrorLabelContainer,
		wrapper: "li",
		errorClass: "validateError",
		ignoreTitle: true,
		rules: {
			"article.title": "required",
			"article.content": "required",
			"article.articleCategory.id": "required"
		},
		messages: {
			"article.title": "请填写文章标题",
			"article.content": "请填写文章内容",
			"article.articleCategory.id": "请选择文章分类"
		},
		submitHandler: function(form) {
			$(form).find(":submit").attr("disabled", true);
			form.submit();
		}
	});
	
})
</script>
</head>
<body class="input">
	<div class="bar">
		<#if isAddAction>添加文章<#else>编辑文章</#if>
	</div>
	<div id="validateErrorContainer" class="validateErrorContainer">
		<div class="validateErrorTitle">以下信息填写有误,请重新填写</div>
		<ul></ul>
	</div>
	<div class="body">
		<form id="validateForm" action="<#if isAddAction>save<#else>update</#if>" method="post">
			<#if !isAddAction><input type="hidden" name="article.id" value="${article.id}" /></#if>
			<table class="inputTable">
				<tr>
					<th>
						文章标题: 
					</th>
					<td>
						<input type="text" name="article.title" class="formText" value="${(article.title)!}" />
						<label class="requireField">*</label>
					</td>
				</tr>
				<tr>
					<th>
						文章分类: 
					</th>
					<td>
						<select name="article.articleCategoryId" >
							<option value="">请选择...</option>
							<#list obj as articleCategoryTree>
								<option value="${articleCategoryTree.id}"<#if (articleCategoryTree.id == article.articleCategory.id)!> selected</#if>>
									<#if articleCategoryTree.grade != 0>
										<#list 1..articleCategoryTree.grade as i>
											&nbsp;&nbsp;
										</#list>
									</#if>
									${articleCategoryTree.name}
								</option>
							</#list>
						</select>
						<label class="requireField">*</label>
					</td>
				</tr>
				<tr>
					<th>
						作者: 
					</th>
					<td>
						<input type="text" class="formText" name="article.author" value="${(article.author)!}" />
					</td>
				</tr>
				<tr>
					<th>
						设置: 
					</th>
					<td>
						<label>
							<input type="checkbox" checked="checked" id="article_publication" value="true" name="article.publication">发布
						</label>
						<label>
							<input type="checkbox" id="article_recommend" value="true" name="article.recommend">推荐
						</label>
						<label>
							<input type="checkbox" id="article_top" value="true" name="article.top">置顶
						</label>
					</td>
				</tr>
				<tr>
					<th>
						内容: 
					</th>
					<td>
						<textarea id="editor" name="article.content" class="editor">${(article.content)!}</textarea>
						<div class="blank"></div>
					</td>
				</tr>
				<tr>
					<th>
						&nbsp;
					</th>
					<td>
						<span class="warnInfo"><span class="icon">&nbsp;</span>提示: 若需要强制分页,请在文章内容中插入 {nextPage} 标记</span>
					</td>
				</tr>
				<tr>
					<th>
						页面关键词: 
					</th>
					<td>
						<input type="text" class="formText" name="article.metaKeywords" value="${(article.metaKeywords)!}" />
					</td>
				</tr>
				<tr>
					<th>
						页面描述: 
					</th>
					<td>
						<textarea name="article.metaDescription" class="formTextarea">${(article.metaDescription)!}</textarea>
					</td>
				</tr>
			</table>
			<div class="buttonArea">
				<input type="submit" class="formButton" value="确  定" hidefocus />&nbsp;&nbsp;
				<input type="button" class="formButton" onclick="window.history.back(); return false;" value="返  回" hidefocus />
			</div>
		</form>
	</div>
</body>
</html>