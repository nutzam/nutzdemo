package com.rekoe.service;

import java.util.List;

import org.nutz.dao.Dao;
import org.nutz.dao.QueryResult;
import org.nutz.dao.pager.Pager;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.service.IdEntityService;

import com.rekoe.entry.ArticleCategory;

@IocBean(fields = { "dao" })
public class ArticleCategoryService extends IdEntityService<ArticleCategory> {
	public ArticleCategoryService() {
		super();
	}

	public ArticleCategoryService(Dao dao) {
		super(dao);
	}

	public QueryResult getRoleListByPager(int pageNumber, int pageSize) {
		Pager pager = dao().createPager(pageNumber, pageSize);
		List<ArticleCategory> list = dao().query(ArticleCategory.class, null,
				pager);
		pager.setRecordCount(dao().count(ArticleCategory.class));
		return new QueryResult(list, pager);
	}
}
