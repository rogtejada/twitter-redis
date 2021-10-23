package com.example.twitterredis.follow;

import java.util.Set;
import org.springframework.stereotype.Service;

@Service
public class FollowService {

  private FollowRepository repository;

  public FollowService(FollowRepository repository) {
    this.repository = repository;
  }

  public void follow(String targetId, String sourceId){
    repository.follow(targetId, sourceId);
  }

  public Set<String> getFollowers(String userId) {
    return repository.getFollowers(userId);
  }

  public Long getFollowersCount(String id) {
    return repository.getFollowersCount(id);
  }

  public Set<String> getFollowing(String id) {
    return repository.getFollowing(id);
  }

  public Long getFollowingCount(String id) {
    return repository.getFollowingCount(id);
  }
}
