package com.scxxs.cms.model;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.One;
import org.nutz.dao.entity.annotation.Table;

/**
 * 留言类型
 * @author Administrator
 *
 */
@Table("t_MessageType")
public class MessageType implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3979903614704416383L;
	/*
	 * 数据库ID
	 */
	@Id
	private int id;
	/*
	 * 类型名称
	 */
	@Column
	private String name;
	/*
	 * 排序号码
	 */
	@Column
	private Integer sortNumber;
	/*
	 * 是否可以回复
	 */
	@Column
	private boolean replay; 
	/*
	 * 是否显示标题
	 */
	@Column
	private boolean isdisptitle;
	/*
	 * 是否显示留言内容
	 */
	@Column
	private boolean isdispcontent;
	/*
	 * 是否显示留言人
	 */
	@Column
	private boolean isdispvistor;
	/*
	 *是否显示留言者手机 
	 */
	@Column
	private boolean isdisptel;
	/*
	 * 是否显示座机号码
	 */
	@Column
	private boolean isdispphone;
	/*
	 * 是否显示留言者email
	 */
	@Column
	private boolean isdispemail;
	/*
	 * 是否显示留言时间
	 */
	@Column
	private boolean isdispinsertTime;
	/*
	 * 是否需要回复
	 */
	@Column
	private boolean isdispreplayContent;
	/*
	 * 是否显示回复时间
	 */
	@Column
	private boolean isdispreplayTime;
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

	public Integer getSortNumber() {
		return sortNumber;
	}

	public void setSortNumber(Integer sortNumber) {
		this.sortNumber = sortNumber;
	}
	
	public boolean isReplay() {
		return replay;
	}

	public void setReplay(boolean replay) {
		this.replay = replay;
	}
	
	public boolean isIsdisptitle() {
		return isdisptitle;
	}

	public void setIsdisptitle(boolean isdisptitle) {
		this.isdisptitle = isdisptitle;
	}

	public boolean isIsdispcontent() {
		return isdispcontent;
	}

	public void setIsdispcontent(boolean isdispcontent) {
		this.isdispcontent = isdispcontent;
	}

	public boolean isIsdispvistor() {
		return isdispvistor;
	}

	public void setIsdispvistor(boolean isdispvistor) {
		this.isdispvistor = isdispvistor;
	}

	public boolean isIsdisptel() {
		return isdisptel;
	}

	public void setIsdisptel(boolean isdisptel) {
		this.isdisptel = isdisptel;
	}

	public boolean isIsdispphone() {
		return isdispphone;
	}

	public void setIsdispphone(boolean isdispphone) {
		this.isdispphone = isdispphone;
	}

	public boolean isIsdispemail() {
		return isdispemail;
	}

	public void setIsdispemail(boolean isdispemail) {
		this.isdispemail = isdispemail;
	}

	public boolean isIsdispinsertTime() {
		return isdispinsertTime;
	}

	public void setIsdispinsertTime(boolean isdispinsertTime) {
		this.isdispinsertTime = isdispinsertTime;
	}

	public boolean isIsdispreplayContent() {
		return isdispreplayContent;
	}

	public void setIsdispreplayContent(boolean isdispreplayContent) {
		this.isdispreplayContent = isdispreplayContent;
	}

	public boolean isIsdispreplayTime() {
		return isdispreplayTime;
	}

	public void setIsdispreplayTime(boolean isdispreplayTime) {
		this.isdispreplayTime = isdispreplayTime;
	}

	/**
	 * 本类只是为提高Nutz构建对象的速度
	 * @param rs SQL查询结果集
	 * @return
	 * @throws SQLException
	 */
	public static MessageType getInstance(ResultSet rs) throws SQLException{
		 
		 MessageType type = new MessageType();
		 
		 type.id 		= 	rs.getInt("id");
		 type.name		= 	rs.getString("name");
		 type.sortNumber=	rs.getInt("sortNumber");
		 type.replay    =   rs.getBoolean("replay");
		 type.isdispcontent=rs.getBoolean("isdispcontent");
		 type.isdispemail=rs.getBoolean("isdispemail");
		 type.isdispinsertTime=rs.getBoolean("isdispinsertTime");
		 type.isdispphone=rs.getBoolean("isdispphone");
		 type.isdispreplayContent=rs.getBoolean("isdispreplayContent");
		 type.isdispreplayTime=rs.getBoolean("isdispreplayTime");
		 type.isdisptel=rs.getBoolean("isdisptel");
		 type.isdisptitle=rs.getBoolean("isdisptitle");
		 type.isdispvistor=rs.getBoolean("isdispvistor");
		 return type;
	 }
	
}
