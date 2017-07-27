package com.Smileyes.d_autowire;

public class UserService {
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
