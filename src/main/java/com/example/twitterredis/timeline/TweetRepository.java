package com.example.twitterredis.timeline;


import java.util.List;
import java.util.Set;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.stereotype.Repository;

@Repository
public class TweetRepository {

  private static final String TIMELINE = "timeline:%s";
  private static final String TWEETS = "tweets:%s";

  private final RedisTemplate<String, Tweet> template;

  public TweetRepository(RedisTemplate<String, Tweet> template) {
    template.setValueSerializer(new Jackson2JsonRedisSerializer(Tweet.class));
    this.template = template;
  }

  public void post(Tweet tweet) {
    template.opsForList().leftPush(String.format(TWEETS, tweet.getAuthorId()), tweet);
  }

  public void materializeTimeline(Set<String> followers, Tweet tweet) {
    for (String followerId: followers) {
      template.opsForList().leftPush(String.format(TIMELINE, followerId), tweet);
    }
  }

  public List<Tweet> getByUserId(String userId, Pageable pageable) {
    return template.opsForList().range(String.format(TWEETS, userId), pageable.getOffset(), pageable.getOffset() + pageable.getPageSize());
  }

  public Long countTweetsFromUser(String userId) {
    return template.opsForList().size(String.format(TWEETS, userId));
  }

  public List<Tweet> getTimelineByUserId(String userId, PageRequest pageable) {
    return template.opsForList().range(String.format(TIMELINE, userId), pageable.getOffset(), pageable.getOffset() + pageable.getPageSize());
  }
  public Long countTweetsFromTimeline(String userId) {
    return template.opsForList().size(String.format(TIMELINE, userId));
  }
}
