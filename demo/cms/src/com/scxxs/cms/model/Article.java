package com.scxxs.cms.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Many;
import org.nutz.dao.entity.annotation.ManyMany;
import org.nutz.dao.entity.annotation.One;
import org.nutz.dao.entity.annotation.Table;

/**
 * 文章类
 * 
 * @author Administrator
 * 
 */
@Table("t_article")
public class Article implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 879047567257454110L;
	/*
	 * 数据库ID
	 */
	@Id
	private int id;
	/*
	 * 文章标题
	 */
	@Column("article_title")
	private String title;
	/*
	 * 关键字
	 */
	@Column("article_keywords")
	private String keywords;
	
	/*
	 * 文章内容
	 */
	@Column("article_content")
	private String content;
	/*
	 * 文章来源
	 */
	@Column("article_source")
	private String source;
	/*
	 * 文章作者
	 */
	@Column("article_author")
	private String author;
	/*
	 * 创建日期
	 */
	@Column("article_createDate")
	private Date createDate;
	/*
	 * 修改日期
	 */
	@Column("article_modifyDate")
	private Date modifyDate;
	/*
	 * 点击率
	 */
	@Column("article_click")
	private int click;
	/*
	 * 是否置顶
	 */
	@Column("article_top")
	private boolean top;
	/*
	 * 文章标题颜色
	 */
	@Column("article_color")
	private String color;
	/*
	 * 是否显示该文章
	 */
	@Column("article_show")
	private boolean show;
	/*
	 * 文章类型
	 */
	@ManyMany(target = NavModel.class, from = "article_id", relation = "t_article_nav", to = "navmodel_id")
	private List<NavModel> nav;
	/*
	 * 文章详细显示的风格
	 */
	@One(target = Templete.class, field = "styleid")
	private Templete style;
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
	@One(target=ArticleType.class,field="typeid")
	private ArticleType type;
	/*
	 * 文章类型id
	 */
	@Column
	private int typeid;
	/*
	 *是否为图片新闻
	 */
	@Column
	private boolean hasPic;
	
	/*
	 * 文章的附件
	 */
	@Many(target=ArticleFile.class,field="aid")
	private List<ArticleFile> files;
	
	
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


	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public boolean isShow() {
		return show;
	}

	public void setShow(boolean show) {
		this.show = show;
	}

	public List<NavModel> getNav() {
		return nav;
	}

	public void setNav(List<NavModel> nav) {
		this.nav = nav;
	}

	public Templete getStyle() {
		return style;
	}

	public void setStyle(Templete style) {
		this.style = style;
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

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public ArticleType getType() {
		return type;
	}

	public void setType(ArticleType type) {
		this.type = type;
	}

	public int getTypeid() {
		return typeid;
	}

	public void setTypeid(int typeid) {
		this.typeid = typeid;
	}

	public List<ArticleFile> getFiles() {
		return files;
	}

	public void setFiles(List<ArticleFile> files) {
		this.files = files;
	}

	public boolean isHasPic() {
		return hasPic;
	}

	public void setHasPic(boolean hasPic) {
		this.hasPic = hasPic;
	}
	
	
	
}
