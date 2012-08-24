package com.rekoe.service;

import java.util.List;

import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.dao.QueryResult;
import org.nutz.dao.pager.Pager;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.service.IdEntityService;

import com.rekoe.entry.Article;

@IocBean(fields = { "dao" })
public class ArticleService extends IdEntityService<Article> {
	public ArticleService() {
		super();
	}

	public ArticleService(Dao dao) {
		super(dao);
	}

	public List<Article> list() {
		return query(null, null);
	}

	public void insert(Article art) {
		dao().insert(art);
	}

	public void update(Article art) {
		dao().update(art);
	}

	public Article fetchByID(String id) {
		return fetch(Cnd.where("id", "=", id));
	}

	public QueryResult getArticleListByPager(int pageNumber, int pageSize) {
		Pager pager = dao().createPager(pageNumber, pageSize);
		List<Article> list = dao().query(Article.class, null, pager);
		for (Article atricle : list) {
			atricle = dao().fetchLinks(atricle, "articleCategory");
		}
		pager.setRecordCount(dao().count(Article.class));
		return new QueryResult(list, pager);
	}
}
