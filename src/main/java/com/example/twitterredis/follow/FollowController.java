package com.example.twitterredis.follow;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/follows")
public class FollowController {

  private final FollowService service;

  public FollowController(FollowService service) {
    this.service = service;
  }

  @PostMapping("/{targetUserId}/user/{sourceUserId}")
  public void follow(@PathVariable String targetUserId,@PathVariable String sourceUserId) {
    service.follow(targetUserId, sourceUserId);
  }

  @DeleteMapping("/{targetUserId}/user/{sourceUserId}")
  public void unfollow(@PathVariable String targetUserId,@PathVariable String sourceUserId) {
    service.unfollow(targetUserId, sourceUserId);
  }
}
