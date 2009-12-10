package org.nutz.demo.petstore.mvc.module;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.nutz.demo.petstore.domain.Account;
import org.nutz.demo.petstore.service.AccountService;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Fail;
import org.nutz.mvc.annotation.InjectName;
import org.nutz.mvc.annotation.Ok;

@InjectName("accountModule")
@At("/mvc/account")
@Fail("json")
public class AccountModule {
	private AccountService accountService;
	@At
	@Ok("jsp:jsp.account.showallaccounts1")
	public List<Account> showAllAccounts1(){
		return accountService.getAllAccounts();
	}
	@At
	@Ok("jsp:jsp.account.showallaccounts")
	public void showAllAccounts(HttpServletRequest request){
		request.setAttribute("accounts", accountService.getAllAccounts());
	}
}
