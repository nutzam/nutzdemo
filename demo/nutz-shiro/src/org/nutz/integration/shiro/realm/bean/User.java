package org.nutz.integration.shiro.realm.bean;

import java.util.Date;
import java.util.List;

import org.nutz.dao.entity.annotation.ColDefine;
import org.nutz.dao.entity.annotation.ColType;
import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.ManyMany;
import org.nutz.dao.entity.annotation.Table;

//alter table shiro.system_user add  locked bit(1) NOT NULL default 0;
@Table("SYSTEM_USER")
public class User {

	@Id
	private int id;
	@Column
	private String username;
	@Column
	private String password;
	@Column("login_ip")
	private String loginIP;
	@Column
	private String name;
	@Column
	private String email;
	@Column("is_account_enabled")
	@ColDefine(notNull = false, type = ColType.BOOLEAN, width = 1)
	private Boolean accountEnabled;

	@Column("locked_date")
	@ColDefine(notNull = false, type = ColType.TIMESTAMP)
	private Date lockedDate;
	@Column("is_account_expired")
	@ColDefine(notNull = false, type = ColType.BOOLEAN, width = 1)
	private Boolean accountExpired;

	@Column("is_account_locked")
	@ColDefine(notNull = false, type = ColType.BOOLEAN, width = 1)
	private Boolean accountLocked;

	@Column("is_credentials_expired")
	@ColDefine(notNull = false, type = ColType.BOOLEAN, width = 1)
	private Boolean credentialsExpired;

	@Column("login_failure_count")
	@ColDefine(notNull = false, type = ColType.BOOLEAN, width = 11)
	private Integer loginFailureCount;

	@ColDefine(notNull = false, type = ColType.TIMESTAMP)
	@Column("create_date")
	private Date createDate;

	@Column("modify_date")
	@ColDefine(notNull = false, type = ColType.TIMESTAMP)
	private Date modifyDate;

	@Column("login_date")
	@ColDefine(notNull = false, type = ColType.TIMESTAMP)
	private Date loginDate;
	@Column("department")
	@ColDefine(notNull = false, type = ColType.VARCHAR, width = 255)
	private String department;
	@Column
	@ColDefine(type = ColType.CHAR, width = 24)
	private String salt;

	@ManyMany(target = Role.class, relation = "SYSTEM_USER_ROLE", from = "USERID", to = "ROLEID")
	private List<Role> roles;

	public Date getLockedDate() {
		return lockedDate;
	}

	public void setLockedDate(Date lockedDate) {
		this.lockedDate = lockedDate;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

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

	public String getLoginIP() {
		return loginIP;
	}

	public void setLoginIP(String loginIP) {
		this.loginIP = loginIP;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getAccountEnabled() {
		return accountEnabled;
	}

	public void setAccountEnabled(Boolean accountEnabled) {
		this.accountEnabled = accountEnabled;
	}

	public Boolean getAccountExpired() {
		return accountExpired;
	}

	public void setAccountExpired(Boolean accountExpired) {
		this.accountExpired = accountExpired;
	}

	public Boolean getAccountLocked() {
		return accountLocked;
	}

	public void setAccountLocked(Boolean accountLocked) {
		this.accountLocked = accountLocked;
	}

	public Boolean getCredentialsExpired() {
		return credentialsExpired;
	}

	public void setCredentialsExpired(Boolean credentialsExpired) {
		this.credentialsExpired = credentialsExpired;
	}

	public Integer getLoginFailureCount() {
		return loginFailureCount;
	}

	public void setLoginFailureCount(Integer loginFailureCount) {
		this.loginFailureCount = loginFailureCount;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

}
