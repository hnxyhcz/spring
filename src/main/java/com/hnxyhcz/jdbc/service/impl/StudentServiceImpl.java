package com.hnxyhcz.jdbc.service.impl;

import java.util.List;

import com.hnxyhcz.jdbc.dao.StudentDao;
import com.hnxyhcz.jdbc.entity.Student;
import com.hnxyhcz.jdbc.service.StudentService;

public class StudentServiceImpl implements StudentService {

	private StudentDao studentDao;
	
	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	@Override
	public int addStudent(Student student) {
		int i = studentDao.addStudent(student);
		return i;
	}

	@Override
	public int updateStudent(Student student) {
		int i = studentDao.updateStudent(student);
		return i;
	}

	@Override
	public int deleteStudent(int id) {
		int i = studentDao.deleteStudent(id);
		return i;
	}

	@Override
	public List<Student> findStudent() {
		List<Student> list = studentDao.findStudent();
		return list;
	}

}
