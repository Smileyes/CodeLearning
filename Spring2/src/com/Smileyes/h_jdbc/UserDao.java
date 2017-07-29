package com.Smileyes.h_jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/*
 * Dao
 * 
 * @author Smileyes
 *
 */
@Repository
public class UserDao {
	/*
	 * @Resource private DataSource dataSource;
	 */
	@Resource
	private JdbcTemplate jdbcTemplate;

	/*
	 * 添加用户
	 */
	public void save(User user) {
		String sql = "insert into user (name) values (?)";
		jdbcTemplate.update(sql, user.getName());
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public Map<String, Object> findById(int id) {
		String sql = "select * from user where id = ?";
		return jdbcTemplate.queryForMap(sql, id);// 只能返回一条记录

	}

	public List<User> getAll() {
		String sql = "select * from user";
		return jdbcTemplate.query(sql, new RowMapper<User>() {
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user = new User();
				user.setId(Integer.parseInt(rs.getString("id")));
				user.setName(rs.getString("name"));
				return user;
			}
		});
	}
}
