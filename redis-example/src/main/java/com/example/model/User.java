package com.example.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;


@Data
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@RedisHash("user")
public class User {
 
    private @Id Long id;
    private final String firstname; 
    private final String lastname;
    private final Integer age;
}