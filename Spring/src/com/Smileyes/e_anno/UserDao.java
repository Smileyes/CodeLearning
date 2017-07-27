package com.Smileyes.e_anno;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

//持久层
@Repository("userDao")
public class UserDao {
	@Resource(name = "user")
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
