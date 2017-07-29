package com.Smileyes.h_jdbc;

import java.util.Map;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	private ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext(
			"com/Smileyes/h_jdbc/bean.xml");

	@Test
	public void save() {

		UserDao dao = (UserDao) ac.getBean("userDao");
		/*
		 * // 添加 User user = (User) ac.getBean("user"); user.setName("小张");
		 * dao.save(user);
		 */

		// 查找某个
	/*	Map<String, Object> map = dao.findById(1);
		System.out.println(map);*/

		System.out.println(dao.getAll());
	}
}
