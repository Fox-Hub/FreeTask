package com.freeTask.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.freeTask.entity.Account;
import com.freeTask.service.AccountService;
import com.freeTask.service.TwitterService;

@Controller
public class HomeController {

	@Autowired
	private AccountService accountService;
	@Autowired
	private TwitterService twitterService;

	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/userMgm")
	public String UserMgm(Model model) {
		List<String> typeList = new ArrayList<String>();
		List<Account> accountList = new ArrayList<Account>();
		accountList = accountService.findAll();

		List<String> temp = new ArrayList<String>();
		accountList.stream().forEach(account -> temp.add(account.getType()));
		temp.stream().distinct().forEach(type -> typeList.add(type));
		model.addAttribute("typeList", typeList);
		model.addAttribute("accountList", accountList);

		return "tile/userMgm";
	}

	@GetMapping("/twitter")
	public String Twitter(Model model) {
		MultiValueMap<String, String> tweetMap = new LinkedMultiValueMap<String, String>();
		tweetMap.add("TestUser", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		tweetMap.add("TestUser2", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		tweetMap.add("TestUser3", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		tweetMap.add("TestUser4", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		tweetMap.add("TestUser5", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		tweetMap.add("TestUser6", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		tweetMap.add("TestUser7", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		tweetMap.add("TestUser8", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		tweetMap.add("TestUser9", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		tweetMap.add("TestUser10", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		tweetMap.add("TestUser11", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		tweetMap.add("TestUser12", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		tweetMap.add("TestUser13", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		tweetMap.add("TestUser14", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		tweetMap.add("TestUser15", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");

//		Map<String, String> tweetMap = new HashMap<String, String>();
//		List<Status> tweetList = twitterService.getTwieet(twitterForm.getKeyWord());
//		for(Status status : tweetList) {
//			tweetMap.add(status.getUser().getName(), status.getText());
//		}

		if (!tweetMap.isEmpty())
			model.addAttribute("tweetMap", tweetMap);

		return "tile/twitter";
	}

	@GetMapping("/youTube")
	public String YouTube() {
		return "tile/youTube";
	}

	@GetMapping("Chat")
	public String Chat() {
		return "tile/Chat";
	}

	@GetMapping("Setting")
	public String Setting() {
		return "tile/Setting";
	}

}
