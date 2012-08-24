package com.rekoe.entry;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.nutz.dao.entity.annotation.ColDefine;
import org.nutz.dao.entity.annotation.ColType;
import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Many;
import org.nutz.dao.entity.annotation.Name;
import org.nutz.dao.entity.annotation.One;
import org.nutz.dao.entity.annotation.Table;

@Table("article_category")
public class ArticleCategory {

	@Name
	private String id;

	@Column("create_date")
	@ColDefine(type = ColType.TIMESTAMP)
	private Date createDate;

	@Column("modify_date")
	@ColDefine(type = ColType.TIMESTAMP)
	private Date modifyDate;

	@Column
	private int grade;
	@Column("meta_description")
	@ColDefine(type = ColType.TEXT)
	private String metaDescription;
	@Column("meta_keywords")
	@ColDefine(type = ColType.TEXT)
	private String metaKeywords;
	@Column
	@ColDefine(type = ColType.VARCHAR, width = 225)
	private String name;
	@Column("order_list")
	private int orderList;
	@Column
	@ColDefine(type = ColType.TEXT)
	private String path;
	@Column
	@ColDefine(type = ColType.VARCHAR, width = 225)
	private String sign;

	@Column("parent_id")
	private String parentId;

	@One(target = ArticleCategory.class, field = "parentId")
	private ArticleCategory parent;// 上级分类

	@Many(target = ArticleCategory.class, field = "id")
	private Set<ArticleCategory> children;// 下级分类

	@Many(target = Article.class, field = "articleCategoryId")
	private List<Article> articleSet;// 文章

	public ArticleCategory getParent() {
		return parent;
	}

	public void setParent(ArticleCategory parent) {
		this.parent = parent;
	}

	public Set<ArticleCategory> getChildren() {
		return children;
	}

	public void setChildren(Set<ArticleCategory> children) {
		this.children = children;
	}

	public List<Article> getArticleSet() {
		return articleSet;
	}

	public void setArticleSet(List<Article> articleSet) {
		this.articleSet = articleSet;
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

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getOrderList() {
		return orderList;
	}

	public void setOrderList(int orderList) {
		this.orderList = orderList;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	// @Transient
	public String getUrl() {
		return "/art/list/" + this.getId() + "." + "htm";
	}
}
