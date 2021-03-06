package com.example.test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
@EnableRedisRepositories(basePackages = "com.example.repository")
public class TestRedisConfigs {

	@Bean
	JedisConnectionFactory jedisConnectionFactory() {
		return new JedisConnectionFactory();
	}

    @Bean
    RedisTemplate<Object, Object> redisTemplate() {
        final RedisTemplate<Object, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(jedisConnectionFactory());
        template.setKeySerializer(new StringRedisSerializer());
        template.setHashValueSerializer(new GenericToStringSerializer<Object>(Object.class));
        template.setValueSerializer(new GenericToStringSerializer<Object>(Object.class));
        return template;
    }
}
