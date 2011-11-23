package com.scxxs.cms.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Many;
import org.nutz.dao.entity.annotation.One;
import org.nutz.dao.entity.annotation.Table;

import com.scxxs.cms.model.selector.ArticleColor;
@Table("t_one_article")
public class OneArticle implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4150326990891246277L;
	/*
	 * 数据库ID
	 */
	@Id
	private int id;
	/*
	 * 文章标题
	 */
	@Column("one_article_title")
	private String title;
	/*
	 * 关键字
	 */
	@Column("one_article_keywords")
	private String keywords;
	
	/*
	 * 文章内容
	 */
	@Column("one_article_content")
	private String content;
	/*
	 * 文章来源
	 */
	@Column("one_article_source")
	private String source;
	/*
	 * 文章作者
	 */
	@Column("one_article_author")
	private String author;
	/*
	 * 创建日期
	 */
	@Column("one_article_createDate")
	private Date createDate;
	/*
	 * 修改日期
	 */
	@Column("one_article_modifyDate")
	private Date modifyDate;
	/*
	 * 点击率
	 */
	@Column("one_article_click")
	private int click;
	/*
	 * 是否置顶
	 */
	@Column("one_article_top")
	private boolean top;
	/*
	 * 文章标题颜色
	 */
	@Column("one_article_color")
	private ArticleColor color;
	/*
	 * 是否显示该文章
	 */
	@Column("one_article_show")
	private boolean show;
	
	/*
	 * 模版的Id
	 */
	@Column
	private int styleid;
	/*
	 * 文章是否审核
	 */
	@Column
	private boolean shenhe;
	/*
	 * 文章类型
	 */
	@One(target=NavModel.class,field="navid")
	private NavModel nav;
	
	@Column
	private int navid;
	
	
	/*
	 * 文章详细显示的风格
	 */
	@One(target = Templete.class, field = "styleid")
	private Templete style;
	/*
	 * 文章类型
	 */
	@One(target=OneArticleType.class,field="typeid")
	private OneArticleType type;
	/*
	 * 文章类型id
	 */
	@Column
	private int typeid;
	@Many(target=OneArticleFile.class,field="onearticleid")
	private List<OneArticleFile> files;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
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
	public int getClick() {
		return click;
	}
	public void setClick(int click) {
		this.click = click;
	}
	public boolean isTop() {
		return top;
	}
	public void setTop(boolean top) {
		this.top = top;
	}
	public ArticleColor getColor() {
		return color;
	}
	public void setColor(ArticleColor color) {
		this.color = color;
	}
	public boolean isShow() {
		return show;
	}
	public void setShow(boolean show) {
		this.show = show;
	}
	public int getStyleid() {
		return styleid;
	}
	public void setStyleid(int styleid) {
		this.styleid = styleid;
	}
	public boolean isShenhe() {
		return shenhe;
	}
	public void setShenhe(boolean shenhe) {
		this.shenhe = shenhe;
	}
	public NavModel getNav() {
		return nav;
	}
	public void setNav(NavModel nav) {
		this.nav = nav;
	}
	public Templete getStyle() {
		return style;
	}
	public void setStyle(Templete style) {
		this.style = style;
	}
	public OneArticleType getType() {
		return type;
	}
	public void setType(OneArticleType type) {
		this.type = type;
	}
	public int getTypeid() {
		return typeid;
	}
	public void setTypeid(int typeid) {
		this.typeid = typeid;
	}
	public int getNavid() {
		return navid;
	}
	public void setNavid(int navid) {
		this.navid = navid;
	}
	public List<OneArticleFile> getFiles() {
		return files;
	}
	public void setFiles(List<OneArticleFile> files) {
		this.files = files;
	}
	
	

}
