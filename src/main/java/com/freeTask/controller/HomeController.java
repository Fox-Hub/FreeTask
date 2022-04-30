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
		return "tile/UserMgm";
	}

	@GetMapping("/Twitter")
	public String Twitter() {
		return "tile/Twitter";
	}

	@GetMapping("/YouTube")
	public String YouTube() {
		return "tile/YouTube";
	}

	@GetMapping("Chat")
	public String Chat() {
		return "tile/Chat";
	}

	@GetMapping("Setting")
	public String Setting() {
		return "tile/Setting";
	}

	@GetMapping("GitHub")
	public String GitHub() {
		return "tile/GitHub";
	}

}
