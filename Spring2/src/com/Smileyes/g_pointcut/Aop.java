package com.Smileyes.g_pointcut;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/*
 * 切面类
 * 
 * @author Smileyes
 *
 */
@Aspect() // 切面类
@Component() // 添加类到IOC容器
public class Aop {
	// 定义切入点表达式

	// @Pointcut(" execution(public * *(..))")//所有public方法
	// @Pointcut(" execution( * save(..))")//所有的save方法
	// @Pointcut(" execution( * com.Smileyes.g_pointcut.UserDao.*(..))")//某个类的所有方法
	/*
	 * @Pointcut(" execution( * com.Smileyes.g_pointcut..*.*(..))") 指定包极其子包内所有类的所有方法
	 */
	// @Pointcut(" execution( * com.Smileyes.g_pointcut.UserDao.*(..)) or execution(
	// * com.Smileyes.g_pointcut.OrderDao.*(..))") // 并集1
	@Pointcut(" execution( * com.Smileyes.g_pointcut.UserDao.*(..))|| execution( * com.Smileyes.g_pointcut.OrderDao.*(..))") // 并集2

	public void pointCut() {
	}

	// 前置通知,在目标方法之前执行
	@Before("pointCut()")
	public void begin() {
		System.out.println("------开始事务------");
	}

	// 后置通知，在目标方法之后执行，无论是否发生异常，都会执行
	@After("pointCut()")
	public void end() {
		System.out.println("------完成事务------");
	}

	// 返回后通知：出错则不执行
	@AfterReturning("pointCut()")
	public void afterReturning() {
		System.out.println("------afteReturning------");
	}

	@AfterThrowing("pointCut()")
	public void afterThrowing() {
		System.out.println("------afterThrowing------");
	}

	// 环绕通知：相当于Before+After
	@Around("pointCut()")
	public void around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("------环绕前------");
		pjp.proceed();
		System.out.println("------环绕后------");
	}
}
