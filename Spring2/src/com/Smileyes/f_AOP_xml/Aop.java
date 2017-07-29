package com.Smileyes.f_AOP_xml;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/*
 * 切面类
 * 
 * @author Smileyes
 *
 */
public class Aop {
	// 前置通知,在目标方法之前执行
	public void begin() {
		System.out.println("------开始事务------");
	}

	// 后置通知，在目标方法之后执行，无论是否发生异常，都会执行
	public void end() {
		System.out.println("------完成事务------");
	}

	// 返回后通知：出错则不执行
	public void afterReturning() {
		System.out.println("------afteReturning------");
	}

	public void afterThrowing() {
		System.out.println("------afterThrowing------");
	}

	// 环绕通知：相当于Before+After
	public void around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("------环绕前------");
		pjp.proceed();
		System.out.println("------环绕后------");
	}
}
