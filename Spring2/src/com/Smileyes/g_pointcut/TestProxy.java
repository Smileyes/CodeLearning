package com.Smileyes.g_pointcut;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * 测试AOP编程的方式
 * 采用注解的方式
 * 被代理目标对象实现接口
 * @author Smileyes
 *
 */
public class TestProxy {
	private ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext(
			"com/Smileyes/g_pointcut/bean.xml");

	@Test
	public void save() {
		IUserDao userDao = (IUserDao) ac.getBean("userDao");
		System.out.println(userDao.getClass());
		userDao.save();
	}

}
