package com.freeTask.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SignInController {
	
	@GetMapping("/signOut")
	public String signOut() {
		return "signOut";
	}

}
