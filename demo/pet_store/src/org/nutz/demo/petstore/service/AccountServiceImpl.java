package org.nutz.demo.petstore.service;

import java.util.List;

import org.nutz.dao.Chain;
import org.nutz.dao.Cnd;
import org.nutz.demo.petstore.domain.Account;
import org.nutz.demo.petstore.domain.Signon;
import org.nutz.service.NameEntityService;

public class AccountServiceImpl extends NameEntityService<Account> implements AccountService {
	
	public void addAccount(Account account) {
		this.dao().insertWith(account, "signon");
	}

	
	public Account getAccountByUserid(String userid) {
		return this.fetch(userid);
	}

	
	public List<Account> getAllAccounts() {
		return this.query(null, null);
	}

	
	public void updateAccount(Account account, String olduserid) {
		String newUserid=account.getUserid();
		if(newUserid.equals(olduserid)){
			this.dao().update(account);
			this.dao().update(account.getSignon());
		}else{
			account.setUserid(olduserid);
			this.update(Chain.make("userid", newUserid), Cnd.where("userid","=",olduserid));
			this.dao().update(Signon.class,Chain.make("password", account.getSignon().getPassword()).add("username", newUserid), Cnd.where("username","=",olduserid));
		}
	}
	
	public void deleteAccountByUserid(String userid) {
		this.delete(userid);
		this.dao().delete(Signon.class,userid);
	}

	
	public void updateAccount(Account account) {
		this.dao().update(account);
	}
}
