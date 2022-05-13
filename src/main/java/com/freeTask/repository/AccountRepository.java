package com.freeTask.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.freeTask.entity.Account;

public interface AccountRepository extends JpaRepository<Account, String>{
	
	List<Account> findByUsername(String username);
	List<Account> findByUsernameAndType(String username, String type);
	List<Account> findByUsernameAndActiveTrue(String username);
	List<Account> findByUsernameAndActiveFalse(String username);
	
	List<Account> findByType(String type);
	List<Account> findByTypeAndActiveTrue(String type);
	List<Account> findByTypeAndActiveFalse(String type);
	
	List<Account> findByActiveTrue();
	List<Account> findByActiveFalse();
	
	List<Account> findByUsernameAndTypeAndActiveTrue(String username, String type);
	List<Account> findByUsernameAndTypeAndActiveFalse(String username, String type);

}
