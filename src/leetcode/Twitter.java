package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Twitter {
	
	class Tweet {
		int userId;
		int tweetId;
		
		public Tweet(int userId, int tweetId) {
			this.userId = userId;
			this.tweetId = tweetId;
		}
	}
	
	HashMap<Integer, Integer> tweet = null;
	HashMap<Integer, HashSet<Integer>> followed = null;
	LinkedList<Tweet> tweetList = null;

	/** Initialize your data structure here. */
	public Twitter() {
		tweet = new HashMap<Integer, Integer>();
		followed = new HashMap<Integer, HashSet<Integer>>();
		tweetList = new LinkedList<Tweet>();
	}

	/** Compose a new tweet. */
	public void postTweet(int userId, int tweetId) {
		tweetList.add(0, new Tweet(userId, tweetId));
	}

	/**
	 * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in
	 * the news feed must be posted by users who the user followed or by the user
	 * herself. Tweets must be ordered from most recent to least recent.
	 */
	public List<Integer> getNewsFeed(int userId) {
		
		List<Integer> rl = new ArrayList<Integer>();
		
		Tweet tweet = null;
		HashSet<Integer> hs = followed.get(userId);
		int j = 0;
		for (int i = 0; i < tweetList.size() && j < 10; ++i) {
			tweet = tweetList.get(i);
			if (tweet.userId == userId || (hs != null && hs.contains(tweet.userId))) {
				rl.add(tweet.tweetId);
				j++;
			}
		}
		
		return rl;

	}

	/**
	 * Follower follows a followee. If the operation is invalid, it should be a
	 * no-op.
	 */
	public void follow(int followerId, int followeeId) {
		HashSet<Integer> fs = followed.get(followerId);
		if (fs == null) {
			fs = new HashSet<Integer>();
			fs.add(followeeId);
			followed.put(followerId, fs);
		} else {
			fs.add(followeeId);
		}
	}

	/**
	 * Follower unfollows a followee. If the operation is invalid, it should be a
	 * no-op.
	 */
	public void unfollow(int followerId, int followeeId) {
		HashSet<Integer> fs = followed.get(followerId);
		if (fs != null)
			fs.remove(followeeId);
	}
	/**
	 * Your Twitter object will be instantiated and called as such: 
	 * Twitter obj = new Twitter(); 
	 * obj.postTweet(userId,tweetId); 
	 * List<Integer> param_2 = obj.getNewsFeed(userId); 
	 * obj.follow(followerId,followeeId);
	 * obj.unfollow(followerId,followeeId);
	 */
}
