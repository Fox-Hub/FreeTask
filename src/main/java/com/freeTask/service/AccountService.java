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
	
	@Transactional
	public List<Account> findAll() {
		return accountRepository.findAll();
	}

	@Transactional
	public Account find(String username) {
		return accountRepository.findById(username).get();
	}
	
	@Transactional
	public List<Account> getAccountListType(String type){
		return accountRepository.findByType(type);
	}
	
	@Transactional
	public List<Account> getAccountListUsername(String username){
		return accountRepository.findByUsername(username);
	}
	
	@Transactional
	public List<Account> getAccountListUsernameAndType(String username, String type){
		return accountRepository.findByUsernameAndType(username, type);
	}
	
	@Transactional
	public List<Account> getAccountListUsernameAndActiveTrue(String username){
		return accountRepository.findByUsernameAndActiveTrue(username);
	}
	
	@Transactional
	public List<Account> getAccountListUsernameAndActiveFalse(String username){
		return accountRepository.findByUsernameAndActiveFalse(username);
	}
	
	@Transactional
	public List<Account> getAccountListTypeAndActiveTrue(String type){
		return accountRepository.findByTypeAndActiveTrue(type);
	}
	
	@Transactional
	public List<Account> getAccountListTypeAndActiveFalse(String type){
		return accountRepository.findByTypeAndActiveFalse(type);
	}
	
	@Transactional
	public List<Account> getAccountListActiveTrue(){
		return accountRepository.findByActiveTrue();
	}
	
	@Transactional
	public List<Account> getAccountListActiveFalse(){
		return accountRepository.findByActiveFalse();
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