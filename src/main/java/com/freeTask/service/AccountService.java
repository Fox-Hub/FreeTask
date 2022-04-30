package com.freeTask.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freeTask.entity.Account;
import com.freeTask.repository.AccountRepository;

@Service
public class AccountService {
	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private SpringUserService springUserService;

	public List<Account> getAccountList() {
		return accountRepository.findAll();
	}

	public Account find(String username) {
		return accountRepository.findById(username).get();
	}

	@Transactional
	public Account createAdministratorAccount(String username, String password, boolean active) {
		springUserService.createSpringUser(username, password, "ADMIN", active);

		Account account = new Account();
		account.setUsername(username);
		account.setType("admin");
		account.setActive(active);
		accountRepository.save(account);
		return account;
	}

	@Transactional
	public Account createUserAccount(String username, String password, boolean active) {
		springUserService.createSpringUser(username, password, "USER", active);

		Account account = new Account();
		account.setUsername(username);
		account.setType("user");
		account.setActive(active);
		accountRepository.save(account);
		return account;
	}

	@Transactional
	public void updateAccount(String username, String password, boolean active) {
		springUserService.updateSpringUser(username, password, active);

		Account account = accountRepository.findById(username).get();
		account.setActive(active);
		accountRepository.save(account);
	}
}