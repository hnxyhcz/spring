package com.hnxyhcz.transaction.service.impl;

import org.springframework.transaction.annotation.Transactional;

import com.hnxyhcz.transaction.dao.BankDao;
import com.hnxyhcz.transaction.service.BankService;

/**
 * 声明式事务管理 ：使用@Transactional注解配置
 * @author Administrator
 *
 */
@Transactional
public class BankServiceImpl3 implements BankService {
	
	private BankDao bankDao;
	
	public void setBankDao(BankDao bankDao) {
		this.bankDao = bankDao;
	}
	
	@Override
	public void transferAccount(final int money, final int userIdA, final int userIdB) {
		bankDao.outMoney(money, userIdA);
		bankDao.inMoney(money, userIdB);
	}
	
}
