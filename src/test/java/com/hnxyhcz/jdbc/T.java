package com.hnxyhcz.jdbc;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hnxyhcz.jdbc.entity.Student;
import com.hnxyhcz.jdbc.service.StudentService;

@RunWith(SpringJUnit4ClassRunner.class)
public class T {

	private static ApplicationContext ctx;
	
	@Before
	public void setUp() throws Exception {
		ctx = new ClassPathXmlApplicationContext("classpath*:/spring-jdbc.xml");
	}

	@Test
	public void addStudent() {
		StudentService studentService = (StudentService) ctx.getBean("studentService");
		int i = studentService.addStudent(new Student("lisi", 18));
		if(i == 1) {
			System.out.println("添加成功！");
		}
	}
	
	@Test
	public void updateStudent() {
		StudentService studentService = (StudentService) ctx.getBean("studentService");
		int i = studentService.updateStudent(new Student(24, "xiaosan", 23));
		if(i == 1) {
			System.out.println("更新成功！");
		}
	}
	
	@Test
	public void deleteStudent() {
		StudentService studentService = (StudentService) ctx.getBean("studentService");
		int i = studentService.deleteStudent(1);
		if(i == 1) {
			System.out.println("删除成功！");
		}
	}
	
	@Test
	public void findStudent() {
		StudentService studentService = (StudentService) ctx.getBean("studentService");
		List<Student> list = studentService.findStudent();
		for(Student student : list) {
			System.out.println(student.toString());
		}
	}
}
