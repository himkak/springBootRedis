package com.spring.cache.redis.model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "SEQ_GEN", sequenceName = "SEQ_USER", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GEN")
	private int id;
	private String name;
	private int age;

	private void writeObject(ObjectOutputStream oos) throws Exception {
		oos.defaultWriteObject();
		oos.writeObject(toString());
	}

	private void readObject(ObjectInputStream ois) throws Exception {
		ois.defaultReadObject();
		String objStr = (String) ois.readObject();
		ObjectMapper objMapper = new ObjectMapper();
		try {
			Student s = objMapper.readValue(objStr, Student.class);
			id = s.id;
			name = s.name;
			age = s.age;
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
	}

	/*
	 * @Override public String toString() { return "Student [id=" + id + ", name=" +
	 * name + ", age=" + age + "]"; }
	 */

}
