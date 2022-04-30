package com.freeTask.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;

import com.freeTask.entity.Users;
import com.freeTask.model.SignIn;
import com.freeTask.service.UsersService;

@Controller
public class SignInController {
	
	@Autowired
	private UsersService usersService;
	
	@PostMapping("/signIn")
	public String SingIn(@Valid SignIn signIn, BindingResult br, Model model) {
		Users user = usersService.getUser(signIn.getUserId(), signIn.getPassword());
		if(br.hasErrors() || user == null) {
			model.addAttribute("errorFlag", true);
			return "/signIn";
		}
		
		return "index";
	}

}
