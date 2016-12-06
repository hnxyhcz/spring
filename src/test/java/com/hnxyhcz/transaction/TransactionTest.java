package com.hnxyhcz.transaction;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hnxyhcz.transaction.service.BankService;

public class TransactionTest {

private static ApplicationContext ctx;
	
	@Before
	public void setUp() throws Exception {
		ctx = new ClassPathXmlApplicationContext("classpath*:/spring-transaction.xml");
	}

	/**
	 * 编程式事务管理
	 */
	@Test
	public void transferAccount1() {
		BankService bankService = (BankService) ctx.getBean("bankService1");
		bankService.transferAccount(50, 1, 2);
	}
	
	/**
	 * 声明式事务管理：使用xml配置
	 */
	@Test
	public void transferAccount2() {
		BankService bankService = (BankService) ctx.getBean("bankService2");
		bankService.transferAccount(50, 1, 2);
	}
	
	/**
	 * 声明式事务管理：使用注解
	 */
	@Test
	public void transferAccount3() {
		BankService bankService = (BankService) ctx.getBean("bankService3");
		bankService.transferAccount(50, 1, 2);
	}
}
