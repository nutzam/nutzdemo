package com.scxxs.cms.dao;

import javax.sql.DataSource;

import org.nutz.dao.impl.NutDao;
import org.nutz.ioc.Ioc;

public class ArticleDao extends BasicDao {
	
	public ArticleDao() {
	}

	public ArticleDao(Ioc ioc) {
		dao = new NutDao(ioc.get(DataSource.class));
	}
}
