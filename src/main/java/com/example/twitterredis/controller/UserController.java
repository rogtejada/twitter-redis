package com.example.twitterredis.controller;

import com.example.twitterredis.model.User;
import com.example.twitterredis.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/users")
public class UserController {

  private UserService service;

  public UserController(UserService service) {
    this.service = service;
  }

  @PostMapping
  public User save(@RequestBody User user) {
    return service.save(user);
  }

  @GetMapping("{id}")
  public User get(@PathVariable String id) {
    return service.getById(id);
  }
}
