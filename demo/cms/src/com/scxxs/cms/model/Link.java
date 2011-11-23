package com.scxxs.cms.model;

import java.io.Serializable;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

@Table("t_link")
public class Link implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6889306607734813473L;
	/*
	 * 数据库主键
	 */
	@Id
	private int id;
	/*
	 * 友情链接类型
	 */
	@Column
	private String type;
	/*
	 * 友情链接名称
	 */
	@Column
	
	private String name;
	/*
	 * 友情链接地址
	 */
	@Column
	private String url;
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
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	

}
