package com.scxxs.cms.model;

import java.io.Serializable;
import java.util.Date;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

@Table("t_group")
public class Group implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3864405663410894991L;
	/*
	 * 数据库id
	 */
	@Id
	private int id;
	/*
	 * 组名
	 */
	@Column
	private String groupname;
	/*
	 * 组长
	 */
	@Column
	private String groupleader;
	/*
	 * 成员
	 * 名字和链接以","分割，
	 * 人与人以"|"分割。
	 */
	@Column
	private String groupitems;
	/*
	 * 创建时间
	 */
	@Column
	private Date createDate;
	/*
	 * 排序号码
	 */
	@Column
	private int sortNumber;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGroupname() {
		return groupname;
	}

	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}

	public String getGroupleader() {
		return groupleader;
	}

	public void setGroupleader(String groupleader) {
		this.groupleader = groupleader;
	}

	public String getGroupitems() {
		return groupitems;
	}

	public void setGroupitems(String groupitems) {
		this.groupitems = groupitems;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public int getSortNumber() {
		return sortNumber;
	}

	public void setSortNumber(int sortNumber) {
		this.sortNumber = sortNumber;
	}

}
