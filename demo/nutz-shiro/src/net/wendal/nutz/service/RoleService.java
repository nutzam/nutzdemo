package net.wendal.nutz.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.nutz.dao.Chain;
import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.dao.QueryResult;
import org.nutz.dao.pager.Pager;
import org.nutz.integration.shiro.realm.bean.Permission;
import org.nutz.integration.shiro.realm.bean.Role;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.service.IdEntityService;

@IocBean(fields = { "dao" })
public class RoleService extends IdEntityService<Role> {
	public RoleService() {
		super();
	}

	public RoleService(Dao dao) {
		super(dao);
	}

	public List<Role> list() {
		return query(null, null);
	}
	
	public void insert(Role role){
		dao().insert(role);
	}
	
	public Role view(Long id) {
		return dao().fetchLinks(fetch(id), "permissions");
	}
	
	public void update(Role role) {
		dao().update(role);
	}

	public Role fetchByName(String name) {
		return fetch(Cnd.where("NAME", "=", name));
	}

	public List<String> getPermissionNameList(Role role) {
		dao().fetchLinks(role, "permissions");
		List<String> permissionNameList = new ArrayList<String>();

		for (Permission permission : role.getPermissions()) {
			permissionNameList.add(permission.getName());
		}
		return permissionNameList;
	}

	public Map<Long, String> map() {
		Map<Long, String> map = new HashMap<Long, String>();
		List<Role> roles = query(null, null);
		for (Role role : roles) {
			map.put(role.getId(), role.getName());
		}
		return map;
	}

	public void addPermission(Long roleId, Long permissionId) {
		dao().insert("SYSTEM_ROLE_PERMISSION", Chain.make("ROLEID", roleId).add("PERMISSIONID", permissionId));
	}

	public void removePermission(Long roleId, Long permissionId) {
		dao().clear("SYSTEM_ROLE_PERMISSION", Cnd.where("ROLEID", "=", roleId).and("PERMISSIONID", "=", permissionId));
	}
	
	public QueryResult getRoleListByPager(int pageNumber, int pageSize){
		Pager pager = dao().createPager(pageNumber, pageSize);
		List<Role> list = dao().query(Role.class, null, pager);
		pager.setRecordCount(dao().count(Role.class));
		return new QueryResult(list, pager);
	}
}
