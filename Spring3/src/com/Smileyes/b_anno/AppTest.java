package com.Smileyes.b_anno;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * 采用注解的方式，进行声明式事务控制
 * 
 * @author Smileyes
 * 事务传播行为：REQUIRES_NEW与REQUIRED
 */
public class AppTest {

	@Test
	public void testTransaction() {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"com/Smileyes/b_anno/bean.xml");
		User user = (User) ac.getBean("user");
		user.setName("小明");
		UserService userService = (UserService) ac.getBean("userService");
		userService.save(user);
	}
}
