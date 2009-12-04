package org.nutz.demo.petstore.service;

import org.nutz.demo.petstore.domain.Account;
import org.nutz.service.NameEntityService;

public class AccountServiceImpl extends NameEntityService<Account> implements AccountService {
	@Override
	public void addAccount(Account account) {
		this.dao().insert(account);
	}

	@Override
	public Account getAccountByUserid(String userid) {
		return this.dao().fetch(Account.class, userid);
	}
}
