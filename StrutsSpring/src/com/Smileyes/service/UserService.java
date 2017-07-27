package com.Smileyes.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.Smileyes.dao.UserDao;
import com.Smileyes.entity.User;

@Service("userService")
public class UserService {
	@Resource(name = "userDao")
	private UserDao userDao;

	public User get() {
		return userDao.get();
	}
}
