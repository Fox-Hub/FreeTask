package com.freeTask.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.freeTask.service.TwitterService;

@Controller
public class HomeController {

	@Autowired
	private TwitterService twitterService;

	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/UserMgm")
	public String UserMgm() {
		return "tile/UserMgm";
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
