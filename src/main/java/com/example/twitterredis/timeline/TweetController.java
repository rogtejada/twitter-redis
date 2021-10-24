package com.example.twitterredis.timeline;


import com.example.twitterredis.PageFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/tweet")
public class TweetController {

  private final TweetService service;

  public TweetController(TweetService service) {
    this.service = service;
  }

  @PostMapping
  public Tweet post(@RequestBody Tweet tweet) {
    return service.post(tweet);
  }

  @GetMapping("/{userId}")
  public Page<Tweet> getByUserId(@PathVariable String userId, PageFilter pageRequest) {
    return service.getByUserId(userId, PageRequest.of(pageRequest.getPageNumber(), pageRequest.getPageSize()));
  }

}
