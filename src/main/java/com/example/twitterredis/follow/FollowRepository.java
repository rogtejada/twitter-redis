package com.example.twitterredis.follow;

import java.util.Set;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.support.collections.DefaultRedisSet;
import org.springframework.stereotype.Repository;

@Repository
public class FollowRepository {

  private static final String FOLLOWING = "following:%s";
  private static final String FOLLOWERS = "followers:%s";

  private final StringRedisTemplate template;

  public FollowRepository(StringRedisTemplate template) {
    this.template = template;
  }

  public void follow(String targetUserId, String sourceUserId) {
    new DefaultRedisSet<String>(String.format(FOLLOWING, sourceUserId), template).add(targetUserId);
    new DefaultRedisSet<String>(String.format(FOLLOWERS, targetUserId), template).add(sourceUserId);
  }

  public void unfollow(String targetUserId, String sourceUserId) {
    new DefaultRedisSet<String>(String.format(FOLLOWING, sourceUserId), template).remove(targetUserId);
    new DefaultRedisSet<String>(String.format(FOLLOWERS, targetUserId), template).remove(sourceUserId);
  }

  public Set<String> getFollowers(String userId) {
    return template.opsForSet().members(String.format(FOLLOWERS, userId));
  }

  public Long getFollowersCount(String id) {
    return template.opsForSet().size(String.format(FOLLOWERS, id));
  }

  public Set<String> getFollowing(String id) {
    return template.opsForSet().members(String.format(FOLLOWING, id));
  }

  public Long getFollowingCount(String id) {
    return template.opsForSet().size(String.format(FOLLOWING, id));
  }
}
