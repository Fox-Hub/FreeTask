package com.freeTask.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.freeTask.model.SignIn;

@Controller
public class NavigationBarController {
	
	@ModelAttribute("SignIn")
	public SignIn setupSignIn() {
		return new SignIn();
	}
}
