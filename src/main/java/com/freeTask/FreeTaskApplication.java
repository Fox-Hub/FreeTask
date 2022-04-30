package com.freeTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.dao.DuplicateKeyException;

import com.freeTask.service.AccountService;

@SpringBootApplication
public class FreeTaskApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(FreeTaskApplication.class, args);
	}
	
	@Autowired(required = false)
    private AccountService accountService;
    
    @Override
    public void run(String... args) throws Exception {
        // インスタンスがDIされていない（テスト時）は実行しない
        if (accountService == null) {
            return;
        }
        
        String adminUsername = "admin";
        String adminPassword = "admin";
        
        try {
            accountService.createAdministratorAccount(adminUsername, adminPassword, true);
        } catch (DuplicateKeyException e) {
        }
    }

}
