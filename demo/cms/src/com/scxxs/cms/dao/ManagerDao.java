package com.scxxs.cms.dao;

import org.nutz.dao.Cnd;
import org.nutz.ioc.loader.annotation.IocBean;

import com.scxxs.cms.model.Manager;
/**
 * 管理员数据库访问
 * @author Administrator
 *
 */
@IocBean
public class ManagerDao extends BasicDao {
	/**
	 * 管理员登录
	 * @param username
	 * @param password
	 * @return
	 */
	public Manager login(String username,String password){

		Cnd condition = Cnd.where("username", "=", username)
							.and("password", "=", password);
		return  findByCondition(Manager.class,condition);
	}

}
