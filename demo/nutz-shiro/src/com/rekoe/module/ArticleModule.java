package com.rekoe.module;

import java.util.List;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.Lang;
import org.nutz.lang.Strings;
import org.nutz.lang.Times;
import org.nutz.mvc.Mvcs;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.Param;

import com.rekoe.entry.Article;
import com.rekoe.entry.ArticleCategory;
import com.rekoe.service.ArticleCategoryService;
import com.rekoe.service.ArticleService;

@IocBean
@At("/admin/article")
public class ArticleModule {

	@org.nutz.ioc.loader.annotation.Inject
	private ArticleService articleService;

	@org.nutz.ioc.loader.annotation.Inject
	private ArticleCategoryService articleCategoryService;

	@At
	@Ok("fm:admin.article_list")
	@RequiresAuthentication
	public Object list(Integer pageNumber) {
		if (Lang.isEmpty(pageNumber)) {
			pageNumber = 1;
		}
		return articleService.getArticleListByPager(pageNumber, 20);
	}

	@At
	@Ok("fm:admin.article_input")
	@RequiresAuthentication
	public Object p_add() {
		Mvcs.getReq().setAttribute("isAddAction", true);
		List<ArticleCategory> list = articleCategoryService.query(null, null);
		return list;
	}

	@At
	@Ok(">>:/admin/article/list")
	@RequiresAuthentication
	public boolean save(@Param("::article.") Article article) {
		if (Strings.isEmpty(article.getArticleCategoryId())) {
			return false;
		}
		article.setId(StringUtils.remove(UUID.randomUUID().toString(), "-"));
		article.setCreateDate(Times.now());
		article.setModifyDate(Times.now());
		article.setHtmlPath("/");
		articleService.insert(article);
		return true;
	}

	@At
	@Ok("fm:admin.article_input")
	@RequiresAuthentication
	public Object edit(String id) {
		Article art = articleService.fetchByID(id);
		art = articleService.dao().fetchLinks(art, "articleCategory");
		List<ArticleCategory> list = articleCategoryService.query(null, null);
		Mvcs.getReq().setAttribute("article", art);
		Mvcs.getReq().setAttribute("isAddAction", false);
		return list;
	}

	@At
	@Ok(">>:/admin/article/list")
	@RequiresAuthentication
	public boolean update(@Param("::article.") Article article) {
		articleService.update(article);
		return true;
	}
}
