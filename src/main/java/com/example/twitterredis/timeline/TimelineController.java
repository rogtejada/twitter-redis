package com.example.twitterredis.timeline;

import com.example.twitterredis.PageFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/timeline")
public class TimelineController {

  private TweetService tweetService;

  public TimelineController(TweetService tweetService) {
    this.tweetService = tweetService;
  }

  @GetMapping("/{userId}")
  public Page<Tweet> getTimelineByUserId(@PathVariable String userId, PageFilter pageRequest) {
    return tweetService.getTimelineByUserId(userId, PageRequest.of(pageRequest.getPageNumber(), pageRequest.getPageSize()));
  }
}
