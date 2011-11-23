package com.scxxs.cms.model;

import java.io.Serializable;
import java.util.Date;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.One;
import org.nutz.dao.entity.annotation.Table;

/**
 * 留言管理类
 * 
 * @author Administrator
 * 
 */
@Table("t_Message")
public class Message implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7170530962219719920L;
	/*
	 * 数据库ID
	 */
	@Id
	private int id;
	/*
	 * 留言标题
	 */
	@Column
	private String title;
	/*
	 * 留言内容
	 */
	@Column
	private String content;
	/*
	 * 访问者
	 */
	@Column
	private String vistor;
	/*
	 * 电话号码
	 */
	@Column
	private String tel;
	/*
	 * 手机号码
	 */
	@Column
	private String phone;
	/*
	 * 电子邮件
	 */
	@Column
	private String email;
	/*
	 * 留言时间
	 */
	@Column
	private Date insertTime;
	/*
	 * 回复内容
	 */
	@Column
	private String replayContent;
	/*
	 * 回复日期
	 */
	@Column
	private Date replayTime;
	/*
	 * 留言类型
	 */
	@One(target = MessageType.class, field = "tid")
	private MessageType type;
	/*
	 * 留言类型的关联
	 */
	@Column
	private Integer tid;
	/*
	 * 导航
	 */
	@One(target = NavModel.class, field = "navid")
	private NavModel nav;
	/*
	 * 记录导航的id
	 */
	@Column
	private Integer navid;

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

	public String getVistor() {
		return vistor;
	}

	public void setVistor(String vistor) {
		this.vistor = vistor;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getInsertTime() {
		return insertTime;
	}

	public void setInsertTime(Date insertTime) {
		this.insertTime = insertTime;
	}

	public String getReplayContent() {
		return replayContent;
	}

	public void setReplayContent(String replayContent) {
		this.replayContent = replayContent;
	}

	public Date getReplayTime() {
		return replayTime;
	}

	public void setReplayTime(Date replayTime) {
		this.replayTime = replayTime;
	}

	public MessageType getType() {
		return type;
	}

	public void setType(MessageType type) {
		this.type = type;
	}

	public Integer getTid() {
		return tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

	public NavModel getNav() {
		return nav;
	}

	public void setNav(NavModel nav) {
		this.nav = nav;
	}

	public Integer getNavid() {
		return navid;
	}

	public void setNavid(Integer navid) {
		this.navid = navid;
	}

}
