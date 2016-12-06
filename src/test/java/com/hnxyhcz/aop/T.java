package com.hnxyhcz.aop;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hnxyhcz.aop.entity.People;
import com.hnxyhcz.aop.service.StudentService;

public class T {
	
	@Autowired
	private static ApplicationContext ctx;
	
	@Before
	public void setUp() throws Exception {
		ctx = new ClassPathXmlApplicationContext("classpath*:/spring-aop.xml");
	}

	@Test
	public void test() {
		People zhangsan = (People) ctx.getBean("zhangsan");
		System.out.println(zhangsan);
		StudentService studentService = (StudentService) ctx.getBean("studentService");
		studentService.addStudent(zhangsan);
	}
}
