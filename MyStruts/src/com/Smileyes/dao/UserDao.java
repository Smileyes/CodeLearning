package com.Smileyes.dao;

import com.Smileyes.entity.User;

public class UserDao {

	public boolean login(User user) {
		if ("tom".equals(user.getName()) && "123".equals(user.getPassword())) {
			return true;
		} else {
			return false;
		}
	}
}
