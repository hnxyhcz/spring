package com.hnxyhcz.aop.service.impl;

import com.hnxyhcz.aop.entity.People;
import com.hnxyhcz.aop.service.StudentService;

public class StudentServiceImpl implements StudentService{

	@Override
	public void addStudent(People people) {
		System.out.println("添加学生成功！");
		// 测试异常通知:除数不能为0
		double d = 1/0;
	}
	
}
