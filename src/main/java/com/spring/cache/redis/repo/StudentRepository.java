package com.spring.cache.redis.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.cache.redis.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
