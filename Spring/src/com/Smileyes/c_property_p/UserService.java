package com.Smileyes.c_property_p;

public class UserService {
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public User create() {
		return this.userDao.create();
	}
}
