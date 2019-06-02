package com.spring.cache.redis.repo;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.redis.core.ListOperations;
import org.springframework.stereotype.Repository;

import com.spring.cache.redis.model.Student;

@Repository
public class StudentRedisRepo {

	@Resource(name = "redisTemplate")
	private ListOperations<String, Student> opsForList;
	
	public List<Student> getStudentsOfSchool(String schoolName){
		return opsForList.range(schoolName, 0, 10);
	}
	
	public void saveSchoolStudents(List<Student> students, String schoolName) {
		System.out.println(opsForList.leftPushAll(schoolName, students));
	}

}
