package com.rekoe.module;

import org.nutz.dao.Cnd;
import org.nutz.dao.pager.Pager;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.Mvcs;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.Param;

import com.rekoe.service.ArticleCategoryService;
import com.rekoe.service.ArticleService;

@IocBean
@At("/art")
public class ArticleFrontModule {

	@Inject
	private ArticleCategoryService articleCategoryService;
	@Inject
	private ArticleService articleService;

	@At
	@Ok("fm:front.article_list")
	public Object list(@Param("::pager.") Pager pager) {
		// Mvcs.getReq().setAttribute("articleList", articleService.query(null,
		// null));
		Mvcs.getReq().setAttribute("queryResult",
				articleService.getArticleListByPager(pager.getPageNumber(), 8));
		return articleCategoryService.fetch(Cnd.where("id", "=",
				"402881833054a24b013054ae2818000d"));
	}

}
