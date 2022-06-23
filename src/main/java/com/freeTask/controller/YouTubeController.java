package com.freeTask.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.freeTask.model.YouTubeForm;
import com.freeTask.service.YouTubeService;
import com.google.api.services.youtube.model.SearchResult;

@Controller
public class YouTubeController {
	
	@Autowired
	private YouTubeService youTubeService;
	
	@GetMapping("youTube/searchVideo")
	public String getVideo(YouTubeForm youTubeForm, Model model) {
		System.out.println("searchWord = " + youTubeForm.getSearchKeyword());
		
		List<SearchResult> searchResultList = youTubeService.getVideo();
		if(!searchResultList.isEmpty()) {
			model.addAttribute("videoList", searchResultList);
		}
		
		return "redirect:/youTube";
	}

}
