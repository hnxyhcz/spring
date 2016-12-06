package com.hnxyhcz.aop.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

import com.hnxyhcz.aop.entity.People;


public class StudentServiceAspect {

	/**
	 * 前置通知
	 * @param jp
	 */
	public void doBefore(JoinPoint jp) {
		System.out.println("类名：" + jp.getTarget().getClass().getName());
		System.out.println("方法名：" + jp.getSignature().getName());
		// 获取参数
		System.out.println("前置通知：开始添加学生:" + ((People)jp.getArgs()[0]).getName());
	}
	
	/**
	 * 后置通知
	 * @param jp
	 */
	public void doAfter(JoinPoint jp) {
		System.out.println("后置通知：添加学生" + ((People)jp.getArgs()[0]).getName() + "完成！");
	}
	
	/**
	 * 环绕通知
	 * @param pjp
	 * @return
	 * @throws Throwable
	 */
	public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("环绕通知：添加学生前");
		Object retVal = pjp.proceed();
		// retVal是方法的返回值
		System.out.println(retVal);
		System.out.println("环绕通知：添加学生后");
		return retVal;
	}
	
	/**
	 * 返回通知
	 */
	public void doAfterReturn() {
		System.out.println("返回通知");
	}
	
	/**
	 * 异常通知
	 */
	public void doAfterThrowing(JoinPoint pjp, Throwable ex) {
		System.out.println("异常通知:" + ex.getMessage());
	}
}
