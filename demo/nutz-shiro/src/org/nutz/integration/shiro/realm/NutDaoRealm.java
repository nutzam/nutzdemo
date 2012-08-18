package org.nutz.integration.shiro.realm;

import java.util.List;

import net.wendal.nutz.service.RoleService;
import net.wendal.nutz.service.UserService;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.nutz.integration.Webs;
import org.nutz.integration.shiro.realm.bean.Role;
import org.nutz.integration.shiro.realm.bean.User;
import org.nutz.ioc.Ioc;
import org.nutz.lang.Lang;
import org.nutz.lang.Strings;

/**
 * 用NutDao来实现Shiro的Realm
 * <p/> 可以通过配置文件注入数据源
 * <p/> 在Web环境中也可以通过自动搜索来获取NutDao
 * @author wendal
 *
 */
public class NutDaoRealm extends AuthorizingRealm {
	
	private UserService userService;
	private RoleService roleService;
	
	private RoleService getRoleService()
	{
		if (roleService == null) {
			Ioc ioc = Webs.ioc();
			roleService = ioc.get(RoleService.class);
			return roleService;
		}
		return roleService;
	}
	
	private UserService getUserService()
	{
		if (userService == null) {
			Ioc ioc = Webs.ioc();
			userService = ioc.get(UserService.class);
			return userService;
		}
		return userService;
	}
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		String username = principalCollection.getPrimaryPrincipal().toString();
		User user = getUserService().fetchByName(username);
        if (user == null)
            return null;
        if (user.getAccountLocked()) 
          throw new LockedAccountException("Account [" + username + "] is locked.");
        SimpleAuthorizationInfo auth = new SimpleAuthorizationInfo();
        List<String> roleNameList = getUserService().getRoleNameList(user);
        auth.addRoles(roleNameList);
		for (Role role : user.getRoles()) {
			auth.addStringPermissions(getRoleService().getPermissionNameList(role));
		}
        return auth;
	}

	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
		User user = getUserService().fetchByName(upToken.getUsername());
        if (Lang.isEmpty(user))
            return null;
        if (user.getAccountLocked()) 
           throw new LockedAccountException("Account [" + upToken.getUsername() + "] is locked.");
        SimpleAuthenticationInfo account = new SimpleAuthenticationInfo(user.getName(), user.getPassword(), getName());
		if(!Strings.isEmpty(user.getSalt()))
		{
			ByteSource salt = ByteSource.Util.bytes(user.getSalt());
			account.setCredentialsSalt(salt);
		}
        return account;
	}
	
	/**
	 * 更新用户授权信息缓存.
	 */
	public void clearCachedAuthorizationInfo(String principal) {
		SimplePrincipalCollection principals = new SimplePrincipalCollection(principal, getName());
		clearCachedAuthorizationInfo(principals);
	}

	/**
	 * 清除所有用户授权信息缓存.
	 */
	public void clearAllCachedAuthorizationInfo() {
		Cache<Object, AuthorizationInfo> cache = getAuthorizationCache();
		if (cache != null) {
			for (Object key : cache.keys()) {
				cache.remove(key);
			}
		}
	}
}
