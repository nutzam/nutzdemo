package com.rekoe.module;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.nutz.dao.Cnd;
import org.nutz.integration.shiro.realm.bean.Permission;
import org.nutz.integration.shiro.realm.bean.Role;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.Lang;
import org.nutz.mvc.Mvcs;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.Param;

import com.rekoe.service.PermissionService;
import com.rekoe.service.RoleService;

@IocBean
@At("/admin/role")
public class RoleModule {

	@Inject
	private RoleService roleService;
	@Inject
	private PermissionService permissionService;

	@At
	@Ok("fm:admin.role_list")
	@RequiresPermissions("role:read:*")
	public Object all() {
		return roleService.getRoleListByPager(1, 20);
	}

	@At
	@Ok("json")
	@RequiresPermissions("role:read:*")
	public Map<Long, String> map() {
		return roleService.map();
	}

	@At
	@Ok("fm:admin.role_input")
	@RequiresRoles(value = { "admin", "security-admin" }, logical = Logical.OR)
	public List<Permission> p_add() {
		Mvcs.getReq().setAttribute("isAddAction", true);
		return permissionService.list();
	}

	@At
	@Ok(">>:/admin/role/all")
	@RequiresPermissions("role:create:*")
	public void add(@Param("..") Role role) {
		roleService.insert(role);
	}

	@At
	@Ok(">>:/admin/role/delete")
	@RequiresPermissions("role:delete:*")
	public void delete(@Param("id") Long id) {
		roleService.delete(id);
	}

	@At
	@Ok("fm:admin.role_input")
	@RequiresPermissions("role:read:*")
	public List<Permission> view(@Param("id") Long id) {
		Mvcs.getReq().setAttribute("isAddAction", false);
		Mvcs.getReq().setAttribute("role", roleService.view(id));
		return permissionService.list();
	}

	@At
	@Ok(">>:/admin/role/edit")
	@RequiresPermissions("role:update:*")
	public void edit(@Param("..") Role role) {
		roleService.update(role);
	}

	@At
	@Ok(">>:/admin/role/view?id=${p.roleId}")
	@RequiresPermissions("role:permissionAssign:*")
	public void addPermission(@Param("roleId") Long roleId,
			@Param("permissionId") Long permissionId) {
		roleService.addPermission(roleId, permissionId);
	}

	@At
	@Ok(">>:/admin/role/view?id=${p.roleId}")
	@RequiresPermissions("role:permissionAssign:*")
	public void removePermission(@Param("roleId") Long roleId,
			@Param("permissionId") Long permissionId) {
		roleService.removePermission(roleId, permissionId);
	}

	@At
	@Ok(">>:${obj==true? '/admin/role/all' : '/admin/role/p_add'}")
	public boolean save(@Param("::role.") Role role, Integer[] pIDs) {
		Role $role = roleService.fetchByName(role.getName());
		if (Lang.isEmpty($role)) {
			roleService.insert(role);
			List<Permission> permissions = permissionService.query(
					Cnd.where("id", "iN", pIDs), null);
			role.setPermissions(permissions);
			roleService.dao().insertRelation(role, "permissions");
			return true;
		}
		return false;
	}

	@At
	@Ok(">>:${obj==true? '/admin/role/all' : '/admin/role/p_add'}")
	public boolean update(@Param("::role.") Role role, Long id, Integer[] pIDs) {
		Role $role = roleService.fetch(id);
		if (!Lang.isEmpty($role)) {
			role.setId(id);
			roleService.update(role);
			List<Permission> permissions = permissionService.query(
					Cnd.where("id", "iN", pIDs), null);
			role.setPermissions(permissions);
			roleService.dao().insertRelation(role, "permissions");
			return true;
		}
		return false;
	}
}
