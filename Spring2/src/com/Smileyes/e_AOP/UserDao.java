package com.Smileyes.e_AOP;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

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
