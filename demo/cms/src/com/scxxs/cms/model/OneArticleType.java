package com.scxxs.cms.model;

import java.io.Serializable;
import java.util.List;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Many;
import org.nutz.dao.entity.annotation.Table;



/**
 * 一篇文章分类
 * @author Administrator
 *
 */
@Table("t_onearticle_type")
public class OneArticleType implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1054882372716487095L;
	/*
	 * 数据库ID
	 */
	@Id
	private int id;
	/*
	 * 一篇文章分类名称
	 */
	@Column
	private String name;
	/*
	 * 一篇文章下面所有的文章
	 */
	@Many(target=OneArticle.class,field="typeid")
	private List<OneArticle> oneArticles;
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
	public List<OneArticle> getOneArticles() {
		return oneArticles;
	}
	public void setOneArticles(List<OneArticle> oneArticles) {
		this.oneArticles = oneArticles;
	}
	


}
