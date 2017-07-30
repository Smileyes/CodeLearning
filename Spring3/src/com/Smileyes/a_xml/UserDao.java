package com.Smileyes.a_xml;

import org.springframework.jdbc.core.JdbcTemplate;

/*
 * UserDao类，进行数据的保存等操作
 * 
 * @author Smileyes
 *
 */
public class UserDao {
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/*
	 * 保存用户
	 */
	public void save(User user) {
		String sql = "insert into user (name) values(?)";
		jdbcTemplate.update(sql, user.getName());
	}
}
