package com.nutz.demo.petstore.service;

import com.nutz.demo.petstore.dao.AccountDao;
import com.nutz.demo.petstore.domain.Account;

public class AccountService {
	private AccountDao accountDao;
	public AccountDao getAccountDao() {
		return accountDao;
	}
	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}
	public void addAccount(Account account){
		accountDao.insertAccount(account);
	}
}
