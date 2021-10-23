package com.example.twitterredis.users;

import java.util.List;
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

  public List<User> findAll() {
    return (List<User>) userRepository.findAll();
  }
}
