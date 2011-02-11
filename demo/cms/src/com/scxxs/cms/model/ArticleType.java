package com.scxxs.cms.model;

import java.io.Serializable;
import java.util.List;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Many;
import org.nutz.dao.entity.annotation.Table;

/*
 * 文章分类
 */
@Table("t_Article_Type")
public class ArticleType implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -9034663639302842095L;
	/*
	 * 数据库ID
	 */
	@Id
	private int id;
	/*
	 * 文章分类名称
	 */
	@Column
	private String name;
	/*
	 * 分类下面的所有文章
	 */
	@Many(target=Article.class,field="typeid")
	private List<Article> articles;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Article> getArticles() {
		return articles;
	}
	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
	
	
}
