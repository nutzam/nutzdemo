package com.xvxv.amchart.pojo;

import java.sql.Timestamp;
import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

@Table("ps_good_back")
public class GoodBack {

	@Column
	@Id
	private int id;

	@Column("good_id")
	private int goodId;

	@Column("back_date")
	private Timestamp backDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getGoodId() {
		return goodId;
	}

	public void setGoodId(int goodId) {
		this.goodId = goodId;
	}

	public Timestamp getBackDate() {
		return backDate;
	}

	public void setBackDate(Timestamp backDate) {
		this.backDate = backDate;
	}

}
