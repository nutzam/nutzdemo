package org.nutz.demo.petstore.service;

import java.util.List;

import org.nutz.demo.petstore.domain.Account;


public interface AccountService{
	public void addAccount(Account account);
	public Account getAccountByUserid(String userid);
	public List<Account> getAllAccounts();
	public void updateAccount(Account account);
	public void deleteAccountByUserid(String userid);
}
