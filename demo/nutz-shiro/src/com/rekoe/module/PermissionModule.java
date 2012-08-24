package com.rekoe.module;

import java.util.List;
import java.util.Map;

import org.nutz.integration.shiro.realm.bean.Permission;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.Param;

import com.rekoe.service.PermissionService;

@IocBean
@At("/permission")
public class PermissionModule {

	@Inject
	private PermissionService permissionService;

	@At
	@Ok("jsp:jsp.permission_list")
	// @Authorization(requiresPermissions = "permission:read:*")
	public List<Permission> all() {
		return permissionService.list();
	}

	@At
	@Ok("json")
	// @Authorization(requiresPermissions = "permission:read:*")
	public Map<Long, String> map() {
		return permissionService.map();
	}

	@At
	@Ok(">>:/permission/all")
	// @Authorization(requiresPermissions = "permission:delete:*")
	public void delete(@Param("id") Long id) {
		permissionService.delete(id);
	}

	@At
	@Ok("jsp:jsp.permission_add")
	// @Authorization(requiresRolesAtLeastOne = "admin,security-admin")
	public void p_add() {

	}

	@At
	@Ok(">>:/permission/all")
	// @Authorization(requiresPermissions = "permission:create:*")
	public void add(@Param("..") Permission permission) {
		permissionService.insert(permission);
	}

	@At
	@Ok("jsp:jsp.permission_view")
	// @Authorization(requiresPermissions = "permission:read:*")
	public Permission view(@Param("id") Long id) {
		return permissionService.view(id);
	}

	@At
	@Ok(">>:/permission/all")
	// @Authorization(requiresPermissions = "permission:update:*")
	public void edit(@Param("..") Permission permission) {
		permissionService.update(permission);
	}
}
