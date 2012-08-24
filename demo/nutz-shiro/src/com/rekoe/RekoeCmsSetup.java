package com.rekoe;

import java.util.List;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.integration.shiro.realm.bean.Permission;
import org.nutz.integration.shiro.realm.bean.Role;
import org.nutz.integration.shiro.realm.bean.User;
import org.nutz.lang.Times;
import org.nutz.mvc.NutConfig;
import org.nutz.mvc.Setup;

import com.rekoe.entry.Article;
import com.rekoe.entry.ArticleCategory;

public class RekoeCmsSetup implements Setup {

	@Override
	public void init(NutConfig config) {

		Dao dao = config.getIoc().get(Dao.class);
		// 若必要的数据表不存在，则初始化数据库
		if (!dao.exists(User.class)) {
			dao.create(User.class, true);
			dao.create(Role.class, true);
			dao.create(Permission.class, true);
			createPermission(dao, "*:*:*", "全部权限");
			createPermission(dao, "*:read:*", "读取权限");
			createPermission(dao, "user:read:*", "对用户的浏览");
			createPermission(dao, "user:read,update:*", "对用户的浏览和编辑");
			createPermission(dao, "user:*:*", "对用户的任意操作");
			createPermission(dao, "user:roleAssign:*", "对用户分配角色");
			createPermission(dao, "role:*:*", "对角色的任意操作");
			createPermission(dao, "permission:*:*", "对权限的任意操作");
			createPermission(dao, "role:PermissionAssign:*", "对角色分配权限");

			createRole(dao, "admin", "超级管理员：拥有全部权限的角色", new Integer[] { 1 });
			createRole(dao, "viewer", "审阅者：拥有任何对象的浏览权限的角色", new Integer[] { 2 });
			createRole(dao, "user-superadmin", "用户超级管理员：拥有对用户的任意操作权限的角色",
					new Integer[] { 5 });
			createRole(dao, "user-admin", "用户管理员：拥有对用户的浏览、增加和编辑(不包括删除)权限的角色",
					new Integer[] { 4 });
			createRole(dao, "security-admin",
					"安全管理员：拥有对角色和权限的任意操作，对用户分配角色及对角色分配权限的权限", new Integer[] {
							7, 8, 9 });

			createUser(dao, "admin", new Integer[] { 1 });
			createUser(dao, "jack", new Integer[] { 2, 3 });
			createUser(dao, "kate", new Integer[] { 4 });
			createUser(dao, "sawyer", new Integer[] { 2 });
			createUser(dao, "john", new Integer[] { 2 });
			createUser(dao, "ben", new Integer[] { 5 });
			dao.create(Article.class, true);
			dao.create(ArticleCategory.class, true);
		}
	}

	private void createPermission(Dao dao, String name, String desc) {
		Permission p = new Permission();
		p.setName(name);
		p.setDescription(desc);
		dao.insert(p);
	}

	private void createRole(Dao dao, String name, String desc, Integer[] rPIDs) {
		Role role = new Role();
		role.setSystem(false);
		role.setDescription(desc);
		role.setName(name);
		List<Permission> list = dao.query(Permission.class,
				Cnd.where("id", "iN", rPIDs));
		role.setPermissions(list);
		role = dao.insert(role);
		dao.insertRelation(role, "permissions");
	}

	private void createUser(Dao dao, String name, Integer[] ids) {
		RandomNumberGenerator rng = new SecureRandomNumberGenerator();
		String salt = rng.nextBytes().toBase64();
		String hashedPasswordBase64 = new Sha256Hash("123", salt, 1024)
				.toBase64();
		User user = new User();
		user.setAccountEnabled(true);
		user.setAccountExpired(false);
		user.setAccountLocked(false);
		user.setCredentialsExpired(false);
		user.setDepartment("你太懒惰了");
		user.setEmail("5382211@qq.com");
		user.setLoginDate(Times.now());
		user.setCreateDate(Times.now());
		user.setLoginFailureCount(0);
		user.setLoginIP("127.0.0.1");
		user.setModifyDate(Times.now());
		user.setName(name);
		user.setPassword(hashedPasswordBase64);
		user.setSalt(salt);
		user.setLockedDate(Times.now());
		user.setUsername(name);
		List<Role> roles = dao.query(Role.class, Cnd.where("id", "iN", ids));
		user.setRoles(roles);
		user = dao.insert(user);
		dao.insertRelation(user, "roles");
	}

	@Override
	public void destroy(NutConfig config) {
	}
}
