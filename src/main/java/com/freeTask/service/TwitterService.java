package com.freeTask.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import twitter4j.Paging;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

@Service
public class TwitterService {

	private Twitter twitter;

	public List<Status> getTweet() {
		twitter = new TwitterFactory().getInstance();
		
		List<Status> tweetList = new ArrayList<>();

		Paging paging = new Paging();
		paging.setCount(10);

		try {
			tweetList = twitter.getHomeTimeline(paging);
		} catch (TwitterException e) {
			e.printStackTrace();
		}

		return tweetList;
	}

	public List<Status> getTwieet(String keyWord) {
		Twitter twitter = TwitterFactory.getSingleton();
		Query query = new Query(keyWord);
		List<Status> tweetList = new ArrayList<>();

		try {
			QueryResult result = twitter.search(query);
			tweetList = result.getTweets();
		} catch (TwitterException e) {
			e.printStackTrace();
		}
		
		return tweetList;
	}
	
	public void tweet(String content) {
		Twitter twitter = TwitterFactory.getSingleton();
		try {
			twitter.updateStatus(content);
		} catch (TwitterException e) {
			e.printStackTrace();
		}
	}
}
