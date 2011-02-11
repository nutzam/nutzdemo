package com.scxxs.cms.model;

import java.io.Serializable;
import java.util.Date;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;
@Table("t_download")
public class Download implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4415573133250370619L;
	/*
	 * 数据库ID
	 */
	@Id
	private int id;
	/*
	 * 标题
	 */
	@Column
	private String title;
	/*
	 * 上传资源的服务器地址
	 */
	@Column
	private String url;
	/*
	 * 下载此资源的下载次数
	 */
	@Column
	private int click;
	/*
	 * 上传该资源的时间
	 */
	@Column
	private Date time;
	/*
	 * 该资源所在的模块ID
	 */
	@Column
	private int modelid;
	/*
	 * 图片存放地址
	 */
	@Column
	private String imageurl;
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
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getClick() {
		return click;
	}
	public void setClick(int click) {
		this.click = click;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public int getModelid() {
		return modelid;
	}
	public void setModelid(int modelid) {
		this.modelid = modelid;
	}
	public String getImageurl() {
		return imageurl;
	}
	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}
	

}
