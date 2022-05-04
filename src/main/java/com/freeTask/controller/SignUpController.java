package com.freeTask.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;

import com.freeTask.model.SignOut;
import com.freeTask.service.AccountService;

@Controller
public class SignUpController {
	
	@Autowired
	private AccountService accountService;
	
	@PostMapping("/signUp")
	public String signUp(@Valid SignOut signOut, BindingResult bindingResult, Model model) {
		
		if(bindingResult.hasErrors()) {
			model.addAttribute("errorFlag", true);
			model.addAttribute("errorMessage", "ユーザIDもしくはパスワードが違います。");
			return "signOut";
		}
		
		try {
		accountService.createUserAccount(signOut.getUsername(), signOut.getPassword(), true);
		}catch(Exception e) {
			model.addAttribute("errorFlag", true);
			model.addAttribute("errorMessage", "既にこのユーザーは存在します。");
			return "signOut";
		}
		
		return "index";
	}

}
