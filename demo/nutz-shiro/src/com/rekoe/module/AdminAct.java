package com.rekoe.module;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.nutz.dao.Cnd;
import org.nutz.dao.Condition;
import org.nutz.integration.shiro.realm.bean.Role;
import org.nutz.integration.shiro.realm.bean.User;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.Lang;
import org.nutz.lang.Strings;
import org.nutz.lang.Times;
import org.nutz.mvc.Mvcs;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.Param;

import com.rekoe.service.RoleService;
import com.rekoe.service.UserService;

@IocBean
@At("/admin")
public class AdminAct {

	@Inject
	private UserService userService;

	@Inject
	private RoleService roleService;

	@At
	@Ok("fm:admin.menu_admin")
	@RequiresAuthentication
	public void index() {
	}

	@At("menu/content")
	@Ok("fm:admin.menu_content")
	@RequiresAuthentication
	public void content() {
	}

	@At
	@Ok("fm:admin.admin_list")
	@RequiresAuthentication
	public Object list(Integer pageNumber) {
		if (Lang.isEmpty(pageNumber)) {
			pageNumber = 1;
		}
		return userService.getUserListByPager(pageNumber, 20);
	}

	@At
	@Ok("fm:admin.admin_input")
	@RequiresAuthentication
	public Object p_add() {
		Mvcs.getReq().setAttribute("isAddAction", true);
		Mvcs.getReq().setAttribute("isEditAction", false);
		List<Role> allRoleList = roleService.query(null, null);
		Mvcs.getReq().setAttribute("allRoleList", allRoleList);
		return allRoleList;
	}

	@At
	@Ok("fm:admin.admin_input")
	@RequiresAuthentication
	public User p_edit(long id) {
		Mvcs.getReq().setAttribute("isAddAction", false);
		Mvcs.getReq().setAttribute("isEditAction", true);
		List<Role> allRoleList = roleService.query(null, null);
		Mvcs.getReq().setAttribute("allRoleList", allRoleList);
		return userService.view(id);
	}

	@At("/admin/delete")
	@Ok("json")
	@RequiresAuthentication
	public boolean delete(Integer[] ids) {
		Condition c = Cnd.where("id", "iN", ids);
		userService.clear(c);
		return true;
	}

	@At
	@Ok(">>:${obj == null ? '/admin/list' : '/admin/p_edit'}?id=${p.id}")
	// @Ok(">>:/admin/list")
	@RequiresAuthentication
	public Object update(@Param("::user.") User user, @Param("id") Long id,
			Integer[] roleIDs) {
		User $user = userService.fetch(Cnd.where("id", "=", id));
		if (!Lang.isEmpty($user)) {
			if ($user.getId() == id.intValue()) {
				List<Role> roleList = roleService.query(
						Cnd.where("id", "iN", roleIDs), null);
				user.setRoles(roleList);
				$user.setEmail(user.getEmail());
				$user.setDepartment(user.getDepartment());
				$user.setAccountEnabled(user.getAccountEnabled());
				if (!Strings.isBlank(user.getPassword())) {
					RandomNumberGenerator rng = new SecureRandomNumberGenerator();
					String salt = rng.nextBytes().toBase64();
					String hashedPasswordBase64 = new Sha256Hash(
							user.getPassword(), salt, 1024).toBase64();
					$user.setSalt(salt);
					$user.setPassword(hashedPasswordBase64);
				}
				userService.update($user);
				userService.dao().insertRelation($user, "roles");
			} else {
				return null;
			}
		}
		return $user;
	}

	@At
	@Ok(">>:${obj==true? '/admin/list' : '/admin/p_add'}")
	public boolean save(@Param("::user.") User user, Integer[] roleIDs) {
		User $user = userService.fetchByName(user.getUsername());
		if (Lang.isEmpty($user)) {
			List<Role> roleList = roleService.query(
					Cnd.where("id", "iN", roleIDs), null);
			user.setRoles(roleList);
			RandomNumberGenerator rng = new SecureRandomNumberGenerator();
			String salt = rng.nextBytes().toBase64();
			String hashedPasswordBase64 = new Sha256Hash(user.getPassword(),
					salt, 1024).toBase64();
			user.setSalt(salt);
			user.setDepartment("没有留下任何信息");
			user.setPassword(hashedPasswordBase64);
			user.setAccountExpired(false);
			user.setAccountLocked(false);
			user.setCredentialsExpired(false);
			user.setLoginDate(Times.now());
			user.setLoginFailureCount(0);
			user.setModifyDate(Times.now());
			user.setName(user.getUsername());
			user.setCreateDate(Times.now());
			user.setLoginIP(Mvcs.getReq().getRemoteAddr());
			userService.insert(user);
			userService.dao().insertRelation(user, "roles");
			return true;
		}
		return false;
	}

	@At
	public boolean checkUsername(String username) {
		User user = userService.fetchByName(username);
		return Lang.isEmpty(user);
	}
}
