package com.hnxyhcz.aop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hnxyhcz.aop.entity.People;
import com.hnxyhcz.aop.service.StudentService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:/spring-aop.xml")
public class SpringT extends AbstractJUnit4SpringContextTests {
	
	@Autowired
	public StudentService studentService;
	
	@Autowired
	public People zhangsan;

	
	@Test
	public void test() {
		studentService.addStudent(zhangsan);
	}
}
