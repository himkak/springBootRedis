package com.spring.cache.redis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.cache.redis.model.Student;
import com.spring.cache.redis.repo.StudentRedisRepo;

@Service
public class SchoolService {

	/*
	 * @Autowired private StudentRepository studentRepo;
	 */
	@Autowired
	private StudentRedisRepo studentRepo;

	public void saveStudents(List<Student> student, String schoolName) {
		studentRepo.saveSchoolStudents(student, schoolName);
	}

	public List<Student> getStudents(String schoolName, int startIndex, int endIndex) {
		System.out.println("Called getStudents service");
		return studentRepo.getStudentsOfSchool(schoolName, startIndex, endIndex);
	}

}
