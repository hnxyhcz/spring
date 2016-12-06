package com.hnxyhcz.transaction.service.impl;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.hnxyhcz.transaction.dao.BankDao;
import com.hnxyhcz.transaction.service.BankService;

/**
 * 编程式事务管理
 * @author Administrator
 *
 */
public class BankServiceImpl1 implements BankService {
	
	private BankDao bankDao;
	
	private TransactionTemplate transactionTemplate;
	
	public void setBankDao(BankDao bankDao) {
		this.bankDao = bankDao;
	}
	
	public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
		this.transactionTemplate = transactionTemplate;
	}

	@Override
	public void transferAccount(final int money, final int userIdA, final int userIdB) {
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {
			
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				bankDao.outMoney(money, userIdA);
				bankDao.inMoney(money, userIdB);
			}
		});
		
	}
	
}
