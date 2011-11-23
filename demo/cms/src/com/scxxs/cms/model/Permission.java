package com.scxxs.cms.model;

import java.io.Serializable;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.One;
import org.nutz.dao.entity.annotation.Table;

/**
 * 权限类
 * @author Administrator
 *
 */
@Table("t_Permission")
public class Permission implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3920523629540268618L;

	public static final int C  =  1;
	
	public static final int R  =  2;
	
	public static final int U  =  4;
	
	public static final int D  =  8;
	
	
	/*
	 * 数据库Id
	 */
	@Id
	private int id;
	/*
	 * 模块id
	 */
	@Column
	private int resource;
	/*
	 * 访问权限
	 */
	@Column
	private int acl;
	/*
	 * 权限对应角色
	 */
	@One(target=Role.class,field="roleid")
	private Role role;
	/*
	 * 角色id
	 */
	@Column
	private int roleid;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getResource() {
		return resource;
	}
	
	public void setResource(int resource) {
		this.resource = resource;
	}
	
	public int getAcl() {
		return acl;
	}
	
	public void setAcl(int acl) {
		this.acl = acl;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public int getRoleid() {
		return roleid;
	}

	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}
	
}
