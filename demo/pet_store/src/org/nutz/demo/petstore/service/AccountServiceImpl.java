package org.nutz.demo.petstore.service;

import java.util.List;

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

	@Override
	public List<Account> getAllAccounts() {
		return this.dao().query(Account.class, null, null);
	}

	@Override
	public void updateAccount(Account account) {
		this.dao().update(account);
	}
	@Override
	public void deleteAccountByUserid(String userid) {
		this.dao().delete(Account.class, userid);
	}
}
