package com.hnxyhcz.transaction.service.impl;

import com.hnxyhcz.transaction.dao.BankDao;
import com.hnxyhcz.transaction.service.BankService;

/**
 * ����ʽ������� ��ʹ��xml���ã����ã�
 * @author Administrator
 *
 */
public class BankServiceImpl2 implements BankService {
	
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
