package com.Smileyes.c_Cglib;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * 测试动态代理(JDK代理)的实现情况
 * 
 * @author Smileyes
 *
 */
public class TestProxy {

	@Test
	public void save() {
		UserDao target = new UserDao();
		UserDao proxy = (UserDao) new ProxyFactory(target).getProxyInstance();
		System.out.println(proxy.getClass());
		proxy.save();
	}
}
