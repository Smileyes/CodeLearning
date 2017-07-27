package com.Smileyes.e_anno;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

//服务层
@Service("userService")
public class UserService {
	// 属性
	@Resource(name= "userDao")

	private UserDao userDao;

	public User create() {
		System.out.println("service");
		return this.userDao.create();
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public UserService() {
		System.out.println("userService对象建立");
	}
}
