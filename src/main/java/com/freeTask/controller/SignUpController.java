package com.freeTask.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;

import com.freeTask.model.SignUp;
import com.freeTask.service.AccountService;

@Controller
public class SignUpController {

	@Autowired
	private AccountService accountService;

	@PostMapping("/signUp")
	public String signUp(@Valid SignUp signUp, BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			model.addAttribute("errorFlag", true);
			model.addAttribute("errorMessage", "ユーザIDもしくはパスワードが違います。");
			return "signUp";
		}

		try {
			accountService.createUserAccount(signUp.getUsername(), signUp.getPassword(), false);
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorFlag", true);
			model.addAttribute("errorMessage", "既にこのユーザーは存在します。");
			return "signUp";
		}
		
		return "index";
	}

}
