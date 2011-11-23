package com.scxxs.cms.model;

import java.io.Serializable;
import java.util.List;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Many;
import org.nutz.dao.entity.annotation.ManyMany;
import org.nutz.dao.entity.annotation.Table;

/**
 * 角色类
 * 
 * @author Administrator
 * 
 */
@Table("t_role")
public class Role implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7123031100950590037L;
	/*
	 * 数据库ID
	 */
	@Id
	private int id;
	/*
	 * 角色名称
	 */
	@Column
	private String name;
	/*
	 * 角色优先级，即和其他角色产生冲突的时候 使用那个的权限
	 */
	@Column
	private int rule;
	/*
	 * 角色下面的管理员信息
	 */
	@ManyMany(target = Manager.class, from = "role_id", to = "manager_id", relation = "t_manager_role")
	private List<Manager> manager;
	/*
	 *角色对应的权限信息 
	 */
	@Many(target=Permission.class,field="roleid")
	private List<Permission> permission;
	
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

	public int getRule() {
		return rule;
	}

	public void setRule(int rule) {
		this.rule = rule;
	}

	public List<Manager> getManager() {
		return manager;
	}

	public void setManager(List<Manager> manager) {
		this.manager = manager;
	}

	public List<Permission> getPermission() {
		return permission;
	}

	public void setPermission(List<Permission> permission) {
		this.permission = permission;
	}

	
	
}
