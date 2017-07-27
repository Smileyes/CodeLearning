package com.Smileyes.a_bean;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
	@Test
	public void test() {
		// ClassPathXmlApplicationContext implements ApplicationContext
		// ApplicationContext extends BeanFactory
		// 得到IOC对象
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext(
				"com/Smileyes/a_bean/applicationContext.xml");
		System.out.println("----------1----------");
		User user1 = (User) ac.getBean("user");
		System.out.println("----------2----------");
		User user2 = (User) ac.getBean("user");
		System.out.println("----------3----------");
		ac.close();
		ac.destroy();
	}

}
