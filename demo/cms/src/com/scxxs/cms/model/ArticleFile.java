package com.scxxs.cms.model;

import java.io.Serializable;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.One;
import org.nutz.dao.entity.annotation.Table;

/*
 * 文章附件
 */
@Table("t_ArticleFile")
public class ArticleFile implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8991357769149933778L;
	/**
	 * 图片文件
	 */
	public static final int PICTURE_FILE = 0;
	/**
	 * 下载类型文件
	 */
	public static final int DOWN_FILE = 1;
	/*
	 * 数据库ID
	 */
	@Id
	private int id;
	/*
	 * 附件类型
	 */
	@Column
	private int type;
	/*
	 * 附件的名称
	 */
	@Column
	private String name;
	/*
	 * 附件存放的路径
	 */
	@Column
	private String filePath;

	@One(target = Article.class, field = "aid")
	private Article article;
	/*
	 * 文章id
	 */
	@Column
	private int aid;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

}
