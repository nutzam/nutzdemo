package org.nutz.demo.petstore.test.service;

import java.util.List;

import org.junit.Test;
import org.nutz.demo.petstore.domain.Account;
import org.nutz.demo.petstore.service.AccountService;
import org.nutz.demo.petstore.test.DaoCase;
import static org.junit.Assert.*;

public class AccountServiceTest extends DaoCase{
	private AccountService service;
	protected void before() {
		service = ioc.get(AccountService.class, "accountService");
	}
	@Test
	public void InsertAccountTest(){
		Account account = new Account();
		account.setUserid("testInsertAccount");
		account.setEmail("test@test.com");
		account.setFirstName("testFirstName");
		account.setLastName("testLastName");
		account.setAddress1("testAddresss1");
		account.setCity("testCity");
		account.setState("testState");
		account.setZip("testZip");
		account.setCountry("testCountry");
		account.setPhone("testPhone");
		this.service.addAccount(account);
		Account accountAfterInsert= this.dao.fetch(Account.class, "testInsertAccount");
		assertNotNull(accountAfterInsert);
		this.dao.delete(accountAfterInsert);
	}
	@Test
	public void getAccountTest(){
		Account account = this.service.getAccountByUserid("ACID");
		assertNotNull(account);
	}
	@Test
	public void getAllAccountsTest(){
		List<Account> account = this.service.getAllAccounts();
		assertNotNull(account);
		assertEquals(2, account.size());
	}
	@Test
	public void updateAccountTest(){
		Account account = new Account();
		account.setUserid("testInsertAccount");
		account.setEmail("test@test.com");
		account.setFirstName("testFirstName");
		account.setLastName("testLastName");
		account.setAddress1("testAddresss1");
		account.setCity("testCity");
		account.setState("testState");
		account.setZip("testZip");
		account.setCountry("testCountry");
		account.setPhone("testPhone");
		this.service.addAccount(account);
		account.setEmail("afterupdate");
		this.service.updateAccount(account);
		Account accountAfterUpdate= this.dao.fetch(Account.class, "testInsertAccount");
		assertNotNull(accountAfterUpdate);
		assertEquals("afterupdate", accountAfterUpdate.getEmail());
		this.dao.delete(account);
	}
}
