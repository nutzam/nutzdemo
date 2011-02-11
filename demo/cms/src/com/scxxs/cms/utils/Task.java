package com.scxxs.cms.utils;

import java.util.Date;
import java.util.List;
import java.util.TimerTask;

import org.nutz.dao.Cnd;
import org.nutz.ioc.Ioc;
import org.nutz.ioc.loader.annotation.IocBean;

import com.scxxs.cms.dao.BasicDao;
import com.scxxs.cms.model.Article;

@IocBean
public class Task extends TimerTask {
	
	private BasicDao dao;
	
	public Task(Ioc ioc) {
		super();
		dao = ioc.get(BasicDao.class);
		
	}
	


	@Override
	public void run() {
		
		System.out.println("do task...");
		
		long today = new Date().getTime();
		
		List<Article> colorArticles = dao.search(Article.class, Cnd.where("color", "!=", "0"));
		
		for(Article a:colorArticles){
			long apt = a.getCreateDate().getTime();
			long diff = today - apt;
			//判断时间是否大于7天
			if(diff/(1000*60*60*24)>7){
				a.setColor("0");
				//自动把颜色更新为黑色
				dao.update(a);
			}
		}
		
	}

}
