package com.example.twitterredis.follow;

import java.util.Set;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/following")
public class FollowingController {

  private final FollowService service;

  public FollowingController(FollowService service) {
    this.service = service;
  }

  @GetMapping("/{id}")
  public Set<String> getFollowing(@PathVariable String id) {
    return service.getFollowing(id);
  }

  @GetMapping("/{id}/count")
  public Long getFollowingCount(@PathVariable String id) {
    return service.getFollowingCount(id);
  }
}
