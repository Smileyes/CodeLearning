package com.Smileyes.d_myAop;

import org.springframework.stereotype.Component;

/*
 * 我的AOP类
 * 
 * @author Smileyes
 *
 */
@Component
public class Aop {
	public void begin() {
		System.out.println("------开始事务------");
	}

	public void end() {
		System.out.println("------完成事务------");
	}
}
