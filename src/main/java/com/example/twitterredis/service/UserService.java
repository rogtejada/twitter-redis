package com.example.twitterredis.service;

import com.example.twitterredis.model.User;
import com.example.twitterredis.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public User save(User user) {
    return userRepository.save(user);
  }

  public User getById(String id) {
    return userRepository.findById(id).orElseThrow(() -> new RuntimeException("s"));
  }

}
