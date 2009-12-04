package org.nutz.demo.petstore.domain;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Name;
import org.nutz.dao.entity.annotation.Table;

@Table("profile")
public class Profile {
	@Column
	@Name
	private String userid;
	@Column
	private String langpref;
	@Column
	private String favcategory;
	@Column
	private Boolean mylistopt;
	@Column
	private Boolean banneropt;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getLangpref() {
		return langpref;
	}

	public void setLangpref(String langpref) {
		this.langpref = langpref;
	}

	public String getFavcategory() {
		return favcategory;
	}

	public void setFavcategory(String favcategory) {
		this.favcategory = favcategory;
	}

	public Boolean getMylistopt() {
		return mylistopt;
	}

	public void setMylistopt(Boolean mylistopt) {
		this.mylistopt = mylistopt;
	}

	public Boolean getBanneropt() {
		return banneropt;
	}

	public void setBanneropt(Boolean banneropt) {
		this.banneropt = banneropt;
	}
}
