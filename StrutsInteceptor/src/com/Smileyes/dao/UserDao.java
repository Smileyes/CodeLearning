package com.Smileyes.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.Smileyes.entity.User;
import com.Smileyes.util.JdbcUtil;

public class UserDao {
	private static QueryRunner qr = JdbcUtil.getQr();

	public List<User> getAll() {
		String sql = "select * from user";
		try {
			return qr.query(sql, new BeanListHandler<User>(User.class));
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public User find(User user) {
		String sql = "select * from user where userName=? and userPwd=?";
		try {
			return qr.query(sql, new BeanHandler<User>(User.class), user.getUserName(),
					user.getUserPwd());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
}
