package com.xvxv.amchart.pojo;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Readonly;
import org.nutz.dao.entity.annotation.Table;
import org.nutz.dao.entity.annotation.View;

@Table("ps_good")
@View("ps_view_good")
public class Good {

	@Column
	@Id
	private int id;

	@Column
	private String name;

	@Column("img_url")
	private String imgUrl;

	@Column("detailed")
	private String detailed;

	@Column("paid_count")
	@Readonly
	private int paidCount;
	
	@Column("viewed_count")
	@Readonly
	private int viewedCount;
	
	@Column("back_count")
	@Readonly
	private int backCount;

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

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getDetailed() {
		return detailed;
	}

	public void setDetailed(String detailed) {
		this.detailed = detailed;
	}

	public int getPaidCount() {
		return paidCount;
	}

	public int getViewedCount() {
		return viewedCount;
	}

	public int getBackCount() {
		return backCount;
	}
}
