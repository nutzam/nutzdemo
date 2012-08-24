package com.rekoe.service;

import java.util.ArrayList;
import java.util.List;

import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.dao.QueryResult;
import org.nutz.dao.pager.Pager;
import org.nutz.integration.shiro.realm.bean.Role;
import org.nutz.integration.shiro.realm.bean.User;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.Lang;
import org.nutz.service.IdEntityService;

@IocBean(fields = { "dao" })
public class UserService extends IdEntityService<User> {

	public UserService() {
		super();
	}

	public UserService(Dao dao) {
		super(dao);
	}

	public List<User> list() {
		return query(null, null);
	}

	public void update(User user) {
		dao().update(user);
	}

	public void insert(User user) {
		dao().insert(user);
	}

	public User view(Long id) {
		return dao().fetchLinks(fetch(id), "roles");
	}

	public User fetchByName(String name) {
		return fetch(Cnd.where("NAME", "=", name));
	}

	public List<String> getRoleNameList(User user) {
		dao().fetchLinks(user, "roles");
		List<String> roleNameList = new ArrayList<String>();
		for (Role role : user.getRoles()) {
			roleNameList.add(role.getName());
		}
		return roleNameList;
	}

	public void addRole(Long userId, Long roleId) {
		User user = fetch(userId);
		Role role = new Role();
		role.setId(roleId);
		user.setRoles(Lang.list(role));
		dao().insertRelation(user, "roles");
	}

	public void removeRole(Long userId, Long roleId) {
		dao().clear("SYSTEM_USER_ROLE",
				Cnd.where("USERID", "=", userId).and("ROLEID", "=", roleId));
	}

	public QueryResult getUserListByPager(int pageNumber, int pageSize) {
		Pager pager = dao().createPager(pageNumber, pageSize);
		List<User> list = dao().query(User.class, null, pager);
		pager.setRecordCount(dao().count(User.class));
		return new QueryResult(list, pager);
	}
}
