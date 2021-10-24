package com.example.twitterredis.follow;

import java.util.Set;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/followers")
public class FollowersController {

  private final FollowService service;

  public FollowersController(FollowService service) {
    this.service = service;
  }

  @GetMapping("/{id}")
  public Set<String> getFollowers(@PathVariable String id) {
    return service.getFollowers(id);
  }

  @GetMapping("/{id}/count")
  public Long getFollowersCount(@PathVariable String id) {
    return service.getFollowersCount(id);
  }

}
