package com.freeTask.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.freeTask.entity.Account;
import com.freeTask.service.AccountService;

@ControllerAdvice
public class CommonControllerAdvice {

	@Autowired
	private AccountService accountService;

	@ModelAttribute("account")
	public Account currentAccount() {
		SecurityContext context = SecurityContextHolder.getContext();
		Authentication auth = context.getAuthentication();
		Object principal = auth.getPrincipal();
		if (principal instanceof UserDetails) {
			UserDetails userDetails = (UserDetails) auth.getPrincipal();
			return accountService.find(userDetails.getUsername());
		} else {
			return null;
		}
	}

}
