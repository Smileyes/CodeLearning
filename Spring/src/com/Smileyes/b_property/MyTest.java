package com.Smileyes.b_property;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
	private ApplicationContext ac = new ClassPathXmlApplicationContext(
			"com/Smileyes/b_property/bean.xml");

	@Test

	// 借助xml文件，配置对象与注入依赖关系
	/*
	 * 1.采用set方法：actiom/service/中应该要有相应的下级对象及其setter方法
	 */
	public void setTest() {
		UserAction action = (UserAction) ac
				.getBean("userAction");
		User user = action.excute();
		System.out.println(user);
	}
}
