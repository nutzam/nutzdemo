package com.scxxs.cms.utils;

import java.util.Date;
import java.util.List;
import java.util.TimerTask;

import org.nutz.dao.Cnd;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;

import com.scxxs.cms.dao.BasicDao;
import com.scxxs.cms.model.Article;

@IocBean
public class Task extends TimerTask {
	
	@Inject
	private BasicDao baiscDao;

	@Override
	public void run() {
		
		System.out.println("do task...");
		
		long today = new Date().getTime();
		
		List<Article> colorArticles = baiscDao.search(Article.class, Cnd.where("color", "!=", "0"));
		
		for(Article a:colorArticles){
			long apt = a.getCreateDate().getTime();
			long diff = today - apt;
			//判断时间是否大于7天
			if(diff/(1000*60*60*24)>7){
				a.setColor("0");
				//自动把颜色更新为黑色
				baiscDao.update(a);
			}
		}
		
	}

}
