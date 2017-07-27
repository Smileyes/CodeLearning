package com.Smileyes.d_autowire;

public class UserDao {
	private User user;

	public User create() {

		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserDao() {
		System.out.println("userDao对象建立");
	}
}
