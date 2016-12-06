package com.hnxyhcz.jdbc.service;

import java.util.List;

import com.hnxyhcz.jdbc.entity.Student;

public interface StudentService {

	public int addStudent(Student student);
	
	public int updateStudent(Student student);
	
	public int deleteStudent(int id);
	
	public List<Student> findStudent();
}
