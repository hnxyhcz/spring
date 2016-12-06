package com.hnxyhcz.ioc.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hnxyhcz.ioc.entity.People;

public class Test {

	private static ApplicationContext ctx;

	public static void main(String[] args) {
		ctx = new ClassPathXmlApplicationContext("classpath*:/spring-beans.xml");
		People people1 = (People) ctx.getBean("people1");
		System.out.println(people1);
		
		People people2 = (People) ctx.getBean("people2");
		System.out.println(people2);
		
		People people3 = (People) ctx.getBean("people3");
		System.out.println(people3);
		
		People people4 = (People) ctx.getBean("people4");
		System.out.println(people4);
	}
}
