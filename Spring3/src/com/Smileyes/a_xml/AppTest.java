package com.Smileyes.a_xml;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * 采用xml的方式，进行声明式事务控制
 * 
 * @author Smileyes
 *
 */
public class AppTest {

	@Test
	public void testTransaction() {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"com/Smileyes/a_xml/bean.xml");
		User user = (User) ac.getBean("user");
		user.setName("小明");
		UserService userService = (UserService) ac.getBean("userService");
		userService.save(user);
	}
}
