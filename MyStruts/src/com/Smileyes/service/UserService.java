package com.Smileyes.service;

import com.Smileyes.dao.UserDao;
import com.Smileyes.entity.User;

public class UserService {
	public UserDao dao = new UserDao();

	public boolean login(User user) {
		return dao.login(user);
	}

	public void add(User user) {

	}

}
