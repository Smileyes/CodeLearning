package com.Smileyes.a_static;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * 测试静态代理的实现情况
 * 实现同一接口，代理类包含被代理目标对象
 * @author Smileyes
 *
 */
public class TestProxy {
	private ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext(
			"com/Smileyes/a_static/bean.xml");

	@Test
	public void save() {
		IUserDao userDao = (IUserDao) ac.getBean("userDaoProxy");
		userDao.save();
		System.out.println(userDao.getClass());
	}
}
