package com.Smileyes.f_AOP_xml;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * 测试AOP编程的方式
 * 采用XML的方式进行配置
 * 被代理目标对象实现接口
 * @author Smileyes
 *
 */
public class TestProxy {
	private ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext(
			"com/Smileyes/f_AOP_xml/bean.xml");

	@Test
	public void save() {
		IUserDao userDao = (IUserDao) ac.getBean("userDao");
		System.out.println(userDao.getClass());
		userDao.save();
	}

}
