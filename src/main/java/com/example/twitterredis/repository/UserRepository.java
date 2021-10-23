package com.example.twitterredis.repository;

import com.example.twitterredis.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {

}
