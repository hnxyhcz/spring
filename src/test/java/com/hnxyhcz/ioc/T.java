package com.hnxyhcz.ioc;


import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hnxyhcz.ioc.entity.People;
import com.hnxyhcz.ioc.entity.People2;

public class T {

	private static ApplicationContext ctx;
	
	@Before
	public void setUp() throws Exception {
		ctx = new ClassPathXmlApplicationContext("classpath*:/spring-beans.xml");
	}

	/**
	 * ע���������ֵ
	 */
	@Test
	public void test1() {
		People people1 = (People) ctx.getBean("people1");
		System.out.println(people1);
	}

	/**
	 * ע��bean
	 */
	@Test
	public void test2() {
		People people6 = (People) ctx.getBean("people6");
		System.out.println(people6);
	}
	
	/**
	 * ע���ڲ�bean
	 */
	@Test
	public void test3() {
		People people7 = (People) ctx.getBean("people7");
		System.out.println(people7);
	}
	
	/**
	 * ע���ڲ�null
	 */
	@Test
	public void test4() {
		People people8 = (People) ctx.getBean("people8");
		System.out.println(people8);
	}
	
	/**
	 * ע�뼯��
	 */
	@Test
	public void test5() {
		People people8 = (People) ctx.getBean("people9");
		System.out.println(people8);
	}
	
	/**
	 * ע�뼯��
	 */
	@Test
	public void test6() {
		People2 people8 = (People2) ctx.getBean("people21");
		System.out.println(people8);
	}
	
	
	/**
	 * ע�뼯��
	 */
	@Test
	public void test7() {
		People2 zhangsan = (People2) ctx.getBean("zhangsan");
		System.out.println(zhangsan);
		
		People2 lisi = (People2) ctx.getBean("lisi");
		System.out.println(lisi);
	}
}
