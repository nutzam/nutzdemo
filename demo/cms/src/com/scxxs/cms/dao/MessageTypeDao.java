package com.scxxs.cms.dao;

import org.nutz.dao.Sqls;
import org.nutz.dao.sql.Sql;
import org.nutz.ioc.loader.annotation.IocBean;

@IocBean
public class MessageTypeDao extends BasicDao{

	public void updatesort(String msql){
		Sql sql = Sqls.create(msql);
		
		dao.execute(sql);
	}
}
