package com.spring.cache.redis.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.spring.cache.redis.model.StudentSerializer;

@Configuration
public class RedisConfiguration {
	
	@Autowired
	LettuceConnectionFactory connfactory;

	@Bean
	public RedisTemplate<String, Object> redisTemplate() {
		final RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String, Object>();
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		redisTemplate.setValueSerializer(new StudentSerializer());
		redisTemplate.setConnectionFactory(connfactory);
		return redisTemplate;
	}
}
