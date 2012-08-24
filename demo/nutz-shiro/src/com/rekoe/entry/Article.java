package com.rekoe.entry;

import java.util.Date;

import org.nutz.dao.entity.annotation.ColDefine;
import org.nutz.dao.entity.annotation.ColType;
import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Name;
import org.nutz.dao.entity.annotation.One;
import org.nutz.dao.entity.annotation.Table;

@Table("article")
public class Article {

	@Name
	private String id;

	@Column("create_date")
	@ColDefine(type = ColType.TIMESTAMP)
	private Date createDate;

	@Column("modify_date")
	@ColDefine(type = ColType.TIMESTAMP)
	private Date modifyDate;
	@Column
	private String author;

	@Column
	@ColDefine(type = ColType.TEXT)
	private String content;

	@Column
	private int hits;

	@Column("html_path")
	private String htmlPath;

	@Column("is_publication")
	@ColDefine(type = ColType.BOOLEAN, width = 1)
	private boolean publication;

	@Column("is_recommend")
	@ColDefine(type = ColType.BOOLEAN, width = 1)
	private boolean recommend;

	@Column("is_top")
	@ColDefine(type = ColType.BOOLEAN, width = 1)
	private boolean top;

	@Column("meta_description")
	@ColDefine(type = ColType.TEXT)
	private String metaDescription;

	@Column("meta_keywords")
	@ColDefine(type = ColType.TEXT)
	private String metaKeywords;

	@Column("page_count")
	private int pageCount;

	@Column
	private String title;

	@Column("article_category_id")
	private String articleCategoryId;

	@One(target = ArticleCategory.class, field = "articleCategoryId")
	private ArticleCategory articleCategory;// 文章分类

	public ArticleCategory getArticleCategory() {
		return articleCategory;
	}

	public void setArticleCategory(ArticleCategory articleCategory) {
		this.articleCategory = articleCategory;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getHits() {
		return hits;
	}

	public void setHits(int hits) {
		this.hits = hits;
	}

	public String getHtmlPath() {
		return htmlPath;
	}

	public void setHtmlPath(String htmlPath) {
		this.htmlPath = htmlPath;
	}

	public boolean isPublication() {
		return publication;
	}

	public void setPublication(boolean publication) {
		this.publication = publication;
	}

	public boolean isRecommend() {
		return recommend;
	}

	public void setRecommend(boolean recommend) {
		this.recommend = recommend;
	}

	public boolean isTop() {
		return top;
	}

	public void setTop(boolean top) {
		this.top = top;
	}

	public String getMetaDescription() {
		return metaDescription;
	}

	public void setMetaDescription(String metaDescription) {
		this.metaDescription = metaDescription;
	}

	public String getMetaKeywords() {
		return metaKeywords;
	}

	public void setMetaKeywords(String metaKeywords) {
		this.metaKeywords = metaKeywords;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArticleCategoryId() {
		return articleCategoryId;
	}

	public void setArticleCategoryId(String articleCategoryId) {
		this.articleCategoryId = articleCategoryId;
	}
}