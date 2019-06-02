package com.spring.cache.redis.repo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.spring.cache.redis.model.Student;

@Repository
public class StudentRedisRepo {

	@Resource(name = "redisTemplate")
	// private ListOperations<String, Student> opsForList;
	private RedisTemplate<String, Student> redisTemplate;

	public List<Student> getStudentsOfSchool(String schoolName, int startIndex, int endIndex) {
		List<Student> students = redisTemplate.opsForList().range(schoolName, startIndex, endIndex);
		redisTemplate.expire(schoolName, 50, TimeUnit.SECONDS);
		return students;
	}

	public void saveSchoolStudents(List<Student> students, String schoolName) {
		redisTemplate.opsForList().leftPushAll(schoolName, students);
		redisTemplate.expire(schoolName, 50, TimeUnit.SECONDS);
	}

}
