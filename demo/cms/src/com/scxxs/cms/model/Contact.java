package com.scxxs.cms.model;

import java.io.Serializable;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.One;
import org.nutz.dao.entity.annotation.Table;

/**
 * 联系我们
 * @author Administrator
 *
 */
@Table("t_contact")
public class Contact implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -752610897550207424L;
	/*
	 * 数据库ID
	 */
	@Id
	private int id;
	@Column
	private String type1;
	@Column
	private String name1;
	@Column
	private String type2;
	@Column
	private String name2;
	@Column
	private String type3;
	@Column
	private String name3;
	@Column
	private String type4;
	@Column
	private String name4;
	@Column
	private String type5;
	@Column
	private String name5;
	@Column
	private String type6;
	@Column
	private String name6;
	@Column
	private String type7;
	@Column
	private String name7;
	@Column
	private String type8;
	@Column
	private String name8;
	@Column
	private String imgurl;
	
	@One(target = NavModel.class, field = "navid")
		/*
	 * 导航
	 */
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
	public String getType1() {
		return type1;
	}
	public void setType1(String type1) {
		this.type1 = type1;
	}
	public String getName1() {
		return name1;
	}
	public void setName1(String name1) {
		this.name1 = name1;
	}
	public String getType2() {
		return type2;
	}
	public void setType2(String type2) {
		this.type2 = type2;
	}
	public String getName2() {
		return name2;
	}
	public void setName2(String name2) {
		this.name2 = name2;
	}
	public String getType3() {
		return type3;
	}
	public void setType3(String type3) {
		this.type3 = type3;
	}
	public String getName3() {
		return name3;
	}
	public void setName3(String name3) {
		this.name3 = name3;
	}
	public String getType4() {
		return type4;
	}
	public void setType4(String type4) {
		this.type4 = type4;
	}
	public String getName4() {
		return name4;
	}
	public void setName4(String name4) {
		this.name4 = name4;
	}
	public String getType5() {
		return type5;
	}
	public void setType5(String type5) {
		this.type5 = type5;
	}
	public String getName5() {
		return name5;
	}
	public void setName5(String name5) {
		this.name5 = name5;
	}
	public String getType6() {
		return type6;
	}
	public void setType6(String type6) {
		this.type6 = type6;
	}
	public String getName6() {
		return name6;
	}
	public void setName6(String name6) {
		this.name6 = name6;
	}
	public String getType7() {
		return type7;
	}
	public void setType7(String type7) {
		this.type7 = type7;
	}
	public String getName7() {
		return name7;
	}
	public void setName7(String name7) {
		this.name7 = name7;
	}
	public String getType8() {
		return type8;
	}
	public void setType8(String type8) {
		this.type8 = type8;
	}
	public String getName8() {
		return name8;
	}
	public void setName8(String name8) {
		this.name8 = name8;
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
	public String getImgurl() {
		return imgurl;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	
}
