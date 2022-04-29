package com.freeTask.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/UserMgm")
	public String UserMgm() {
		return "UserMgm";
	}

	@GetMapping("/Twitter")
	public String Twitter() {
		return "Twitter";
	}

	@GetMapping("/YouTube")
	public String YouTube() {
		return "YouTube";
	}

	@GetMapping("Chat")
	public String Chat() {
		return "Chat";
	}

	@GetMapping("Setting")
	public String Setting() {
		return "Setting";
	}

	@GetMapping("GitHub")
	public String GitHub() {
		return "GitHub";
	}

}
