package com.Smileyes.b_anno;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/*
 * UserDao类，进行数据的保存等操作
 * 
 * @author Smileyes
 *
 */
@Repository
public class UserDao {
	@Resource
	private JdbcTemplate jdbcTemplate;

	/*
	 * 保存用户
	 */
	@Transactional(readOnly = false, isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRES_NEW, rollbackForClassName = "UserDao")

	public void save(User user) {
		String sql = "insert into user (name) values(?)";
		jdbcTemplate.update(sql, user.getName());
	}
}
