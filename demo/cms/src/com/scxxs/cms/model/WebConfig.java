package com.scxxs.cms.model;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

/**
 * 网站配置类
 * 
 * @author Administrator
 * 
 */
@Table("t_webconfig")
public class WebConfig implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6679856995810661532L;
	/*
	 * 数据库ID
	 */
	@Id
	private int id;
	/*
	 * 网站名称
	 */
	@Column
	private String webName;
	/*
	 * 网站关键字
	 */
	@Column
	private String keywords;
	/*
	 * 备案号
	 */
	@Column
	private String beian;
	/*
	 * 版权
	 */
	@Column
	private String copyright;
	/*
	 * 点击次数
	 */
	@Column
	private long webclick;
	/*
	 * 是否生成静态页面
	 */
	@Column
	private boolean html;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getWebName() {
		return webName;
	}

	public void setWebName(String webName) {
		this.webName = webName;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getBeian() {
		return beian;
	}

	public void setBeian(String beian) {
		this.beian = beian;
	}

	public String getCopyright() {
		return copyright;
	}

	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}

	public long getWebclick() {
		return webclick;
	}

	public void setWebclick(long webclick) {
		this.webclick = webclick;
	}

	public boolean isHtml() {
		return html;
	}

	public void setHtml(boolean html) {
		this.html = html;
	}
	/**
	 * 本类只是为提高Nutz构建对象的速度
	 * @param rs SQL查询结果集
	 * @return
	 * @throws SQLException
	 */
	public static WebConfig getInstance(ResultSet rs) throws SQLException{
		 
		 WebConfig cfg = new WebConfig();
		 
		 cfg.id 		= 	rs.getInt("id");
		 cfg.beian 		= 	rs.getString("beian");
		 cfg.copyright 	= 	rs.getString("copyright");
		 cfg.html 		= 	rs.getBoolean("html");
		 cfg.keywords 	=  	rs.getString("keywords");
		 cfg.webclick 	= 	rs.getInt("webclick");
		 cfg.webName  	= 	rs.getString("webName");
		 
		 return cfg;
		 
	 }
}
