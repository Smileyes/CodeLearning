package com.Smileyes.e_anno;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
	private ApplicationContext ac = new ClassPathXmlApplicationContext(
			"com/Smileyes/e_anno/bean.xml");

	@Test

	// yong采用注解的方式
	/*
	 * 2.采用p命名空间法，与set方法类似，同那样要求actiom/service/中有相应的下级对象及其setter方法
	 */
	public void setTest() {
		System.out.println(
				"----------分界线----------");
		UserAction action = (UserAction) ac
				.getBean("userAction");
		User user = action.excute();
		System.out.println(user);
	}
}
