package com.example.twitterredis.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@Getter
@Setter
@RedisHash("user")
public class User {

  @Id
  private String id;
  private String name;
  private String email;

}
