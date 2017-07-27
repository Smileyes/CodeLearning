package com.Smileyes.c_property_p;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
	private ApplicationContext ac = new ClassPathXmlApplicationContext(
			"com/Smileyes/c_property_p/bean.xml");

	@Test

	// 借助xml文件，配置对象与注入依赖关系
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
