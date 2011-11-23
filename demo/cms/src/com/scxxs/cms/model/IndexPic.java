package com.scxxs.cms.model;



import java.io.Serializable;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

@Table("t_IndexPic")
public class IndexPic implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6694234414038687220L;
	@Id
	private int id;
	/*
	 * 图片名称
	 */
	@Column
	private String name;
	/*
	 * 排序号码
	 */
	@Column
	private int sortNumber;
	/*
	 * 链接地址
	 */
	@Column
	private String href;
	/*
	 * 图片地址
	 */
	@Column
	private String pic;
	/*
	 * 跳转方式
	 */
	@Column
	private String target;

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

	public int getSortNumber() {
		return sortNumber;
	}

	public void setSortNumber(int sortNumber) {
		this.sortNumber = sortNumber;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

}
