package com.example.twitterredis.follow;

import java.util.Set;
import org.springframework.web.bind.annotation.GetMapping;
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

  @GetMapping("/followers/{id}")
  public Set<String> getFollowers(@PathVariable String id) {
    return service.getFollowers(id);
  }

  @GetMapping("/followers/{id}/count")
  public Long getFollowersCount(@PathVariable String id) {
    return service.getFollowersCount(id);
  }

  @GetMapping("/following/{id}")
  public Set<String> getFollowing(@PathVariable String id) {
    return service.getFollowing(id);
  }

  @GetMapping("/following/{id}/count")
  public Long getFollowingCount(@PathVariable String id) {
    return service.getFollowingCount(id);
  }
}
