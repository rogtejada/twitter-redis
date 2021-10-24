package com.example.twitterredis.timeline;

import com.example.twitterredis.follow.FollowService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TweetService {

  private final TweetRepository repository;
  private final FollowService followService;

  public TweetService(TweetRepository repository, FollowService service) {
    this.repository = repository;
    this.followService = service;
  }

  public Tweet post(Tweet tweet) {
    repository.post(tweet);
    repository.materializeTimeline(followService.getFollowers(tweet.getAuthorId()), tweet);
    return tweet;
  }

  public Page<Tweet> getByUserId(String userId, Pageable pageable) {
    return new PageImpl<>(repository.getByUserId(userId, pageable), pageable, repository.countTweetsFromUser(userId));
  }

  public Page<Tweet> getTimelineByUserId(String userId, PageRequest pageable) {
    return new PageImpl<>(repository.getTimelineByUserId(userId, pageable), pageable, repository.countTweetsFromTimeline(userId));
  }
}
