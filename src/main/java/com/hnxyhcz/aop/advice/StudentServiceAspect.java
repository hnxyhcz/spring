package com.hnxyhcz.aop.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

import com.hnxyhcz.aop.entity.People;


public class StudentServiceAspect {

	/**
	 * ǰ��֪ͨ
	 * @param jp
	 */
	public void doBefore(JoinPoint jp) {
		System.out.println("������" + jp.getTarget().getClass().getName());
		System.out.println("��������" + jp.getSignature().getName());
		// ��ȡ����
		System.out.println("ǰ��֪ͨ����ʼ���ѧ��:" + ((People)jp.getArgs()[0]).getName());
	}
	
	/**
	 * ����֪ͨ
	 * @param jp
	 */
	public void doAfter(JoinPoint jp) {
		System.out.println("����֪ͨ�����ѧ��" + ((People)jp.getArgs()[0]).getName() + "��ɣ�");
	}
	
	/**
	 * ����֪ͨ
	 * @param pjp
	 * @return
	 * @throws Throwable
	 */
	public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("����֪ͨ�����ѧ��ǰ");
		Object retVal = pjp.proceed();
		// retVal�Ƿ����ķ���ֵ
		System.out.println(retVal);
		System.out.println("����֪ͨ�����ѧ����");
		return retVal;
	}
	
	/**
	 * ����֪ͨ
	 */
	public void doAfterReturn() {
		System.out.println("����֪ͨ");
	}
	
	/**
	 * �쳣֪ͨ
	 */
	public void doAfterThrowing(JoinPoint pjp, Throwable ex) {
		System.out.println("�쳣֪ͨ:" + ex.getMessage());
	}
}
