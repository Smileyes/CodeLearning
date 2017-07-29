package com.Smileyes.d_myAop;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * 测试自定AOP，采用Cglib代理的实现情况
 * 被代理的目标对象实现了某个同一接口
 * @author Smileyes
 *
 */
public class TestProxy {
	private ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext(
			"com/Smileyes/d_myAop/bean.xml");

	@Test
	public void save() {
		ProxyFactory pf = (ProxyFactory) ac.getBean("userDaoProxy");
		UserDao proxy = (UserDao) pf.getProxyInstance();
		proxy.save();
		System.out.println(proxy.getClass());
	}
}
