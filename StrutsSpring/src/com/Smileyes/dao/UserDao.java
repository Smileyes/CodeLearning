package com.Smileyes.dao;

import org.springframework.stereotype.Repository;

import com.Smileyes.entity.User;

@Repository("userDao")
public class UserDao {
	public User get() {
		return new User(100, "张三");
	}
}
