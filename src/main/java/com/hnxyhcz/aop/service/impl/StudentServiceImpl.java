package com.hnxyhcz.aop.service.impl;

import com.hnxyhcz.aop.entity.People;
import com.hnxyhcz.aop.service.StudentService;

public class StudentServiceImpl implements StudentService{

	@Override
	public void addStudent(People people) {
		System.out.println("���ѧ���ɹ���");
		// �����쳣֪ͨ:��������Ϊ0
		double d = 1/0;
	}
	
}
