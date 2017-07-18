package com.Smileyes.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.Smileyes.dao.UserDao;
import com.Smileyes.entity.User;

public class UserService {
	private static UserDao dao = new UserDao();

	public List<User> getAll()  {
		return dao.getAll();
	}

	public User find(User user)  {
		return dao.find(user);
	}
}
