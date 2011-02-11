package com.scxxs.cms.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.ManyMany;
import org.nutz.dao.entity.annotation.Table;

/**
 * 管理员
 * @author Administrator
 *
 */
@Table("t_Manager")
public class Manager implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6022585064079133996L;
	/*
	 * 数据库ID
	 */
	@Id
	private int id;
	/*
	 * 用户名
	 */
	@Column
	private String username;
	/*
	 * 密码
	 */
	@Column
	private String password;
	/*
	 * 上次登录时间
	 */
	@Column
	private Date lastLoginTime;
	/*
	 * 本次登录时间
	 */
	@Column
	private Date loginTime;
	/*
	 * 上次登录IP
	 */
	@Column
	private String lastLoginIp;
	/*
	 * 本次登录IP
	 */
	@Column
	private String loginIp;
	
	/*
	 * 登录次数
	 */
	@Column
	private int logintimes;
	/*
	 * 管理员所拥有的角色信息
	 */
	@ManyMany(target=Role.class,from="manager_id",to="role_id",relation="t_manager_role")
	private List<Role> roles;
	/*
	 * 管理员状态 ，启用和禁用
	 */
	@Column
	private boolean state;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	public String getLastLoginIp() {
		return lastLoginIp;
	}

	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}

	public String getLoginIp() {
		return loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	public int getLogintimes() {
		return logintimes;
	}

	public void setLogintimes(int logintimes) {
		this.logintimes = logintimes;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}
	
	
	
	
	
}
