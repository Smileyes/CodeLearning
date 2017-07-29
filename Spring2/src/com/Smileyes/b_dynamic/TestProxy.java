package com.Smileyes.b_dynamic;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * 测试动态代理(JDK代理)的实现情况
 * 要求被代理目标对象实现接口
 * @author Smileyes
 *
 */
public class TestProxy {

	@Test
	public void save() {
		IUserDao userDao = new UserDao();
		IUserDao proxy = (IUserDao) ProxyFactory.getProxyInstance(userDao);
		proxy.save();
		System.out.println(proxy.getClass());
	}
}
