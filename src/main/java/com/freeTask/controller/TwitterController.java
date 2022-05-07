package com.freeTask.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.freeTask.model.TwitterForm;
import com.freeTask.service.TwitterService;

@Controller
public class TwitterController {
	
	@Autowired
	private TwitterService twitterService;
	
	@GetMapping("/twitter/searchContent")
	public String tweetSearch(TwitterForm twitterForm, Model model) {
		MultiValueMap<String, String> tweetMap = new LinkedMultiValueMap<String, String>();
		tweetMap.add("TestUser", "tttttttttttttttttttttttttttttttt");
		tweetMap.add("TestUser2", "tttttttttttttttttttttttttttttttt");
		tweetMap.add("TestUser3", "tttttttttttttttttttttttttttttttt");
		tweetMap.add("TestUser4", "tttttttttttttttttttttttttttttttt");
		tweetMap.add("TestUser5", "tttttttttttttttttttttttttttttttt");
		tweetMap.add("TestUser6", "tttttttttttttttttttttttttttttttt");
		tweetMap.add("TestUser7", "tttttttttttttttttttttttttttttttt");
		tweetMap.add("TestUser8", "tttttttttttttttttttttttttttttttt");
		tweetMap.add("TestUser9", "tttttttttttttttttttttttttttttttt");
		tweetMap.add("TestUser10", "tttttttttttttttttttttttttttttttt");
		tweetMap.add("TestUser11", "tttttttttttttttttttttttttttttttt");
		tweetMap.add("TestUser12", "tttttttttttttttttttttttttttttttt");
		tweetMap.add("TestUser13", "tttttttttttttttttttttttttttttttt");
		tweetMap.add("TestUser14", "tttttttttttttttttttttttttttttttt");
		tweetMap.add("TestUser15", "tttttttttttttttttttttttttttttttt");
		
//		Map<String, String> tweetMap = new HashMap<String, String>();
//		List<Status> tweetList = twitterService.getTwieet(twitterForm.getKeyWord());
//		for(Status status : tweetList) {
//			tweetMap.add(status.getUser().getName(), status.getText());
//		}
		
		if(!tweetMap.isEmpty())
			model.addAttribute("tweetMap", tweetMap);
		
		return "tile/twitter";
	}
	
	@GetMapping("/twitter/searchUser")
	public String userSearch(TwitterForm twitterForm) {
		System.out.println(twitterForm.getUserName());
		
		return "tile/twitter";
	}
	
	@PostMapping("/twitter")
	public String tweet(TwitterForm twitterForm) {
		System.out.println(twitterForm.getTweetContent());
		twitterService.tweet(twitterForm.getTweetContent());
		
		return "redirect:/twitter";
	}

}
