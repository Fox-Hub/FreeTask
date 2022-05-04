package com.freeTask.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.freeTask.entity.Account;

public interface AccountRepository extends JpaRepository<Account, String>{

}
