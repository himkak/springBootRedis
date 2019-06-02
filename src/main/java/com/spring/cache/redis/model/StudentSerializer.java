package com.spring.cache.redis.model;

import java.io.IOException;

import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class StudentSerializer implements RedisSerializer<Student> {

	@Override
	public byte[] serialize(Student t) throws SerializationException {
		ObjectMapper objMapper = new ObjectMapper();
		try {
			return objMapper.writeValueAsString(t).getBytes();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Student deserialize(byte[] bytes) throws SerializationException {
		// TODO Auto-generated method stub
		ObjectMapper objMapper = new ObjectMapper();
		String val=new String(bytes);
		try {
			return objMapper.readValue(bytes, Student.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
