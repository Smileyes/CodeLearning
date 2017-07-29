package com.Smileyes.g_pointcut;

import org.springframework.stereotype.Component;

/*
 * 持久层工具类UserDao
 * 
 * @author Smileyes
 *
 */
@Component
public class UserDao implements IUserDao {
	/*
	 * 用于存储User对象
	 */
	public void save() {
		System.out.println("******执行业务代码中******");
	}
}
