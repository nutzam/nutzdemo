package com.scxxs.cms.model;

import java.io.Serializable;
import java.util.Date;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

import com.scxxs.cms.model.selector.TemplateType;

/**
 * 网页模版类
 * 
 * @author Administrator
 * 
 */
@Table("t_templete")
public class Templete implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6653600117184411233L;
	/*
	 * 数据库ID
	 */
	@Id
	private int id;
	/*
	 * 模版的名称
	 */
	@Column
	private String templeteName;
	/*
	 * 模版简介
	 */
	@Column
	private String description;
	/*
	 * 模版创建时间
	 */
	@Column
	private Date createDate;
	/*
	 * 模版文件的名称
	 */
	@Column
	private String filePath;
	/*
	 * 模板类型
	 */
	@Column
	private TemplateType type;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTempleteName() {
		return templeteName;
	}

	public void setTempleteName(String templeteName) {
		this.templeteName = templeteName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public TemplateType getType() {
		return type;
	}

	public void setType(TemplateType type) {
		this.type = type;
	}
	
	
}
