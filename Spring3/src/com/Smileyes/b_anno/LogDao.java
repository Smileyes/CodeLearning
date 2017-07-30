package com.Smileyes.b_anno;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class LogDao {
	@Resource
	private JdbcTemplate jdbcTemplate;

	@Transactional(readOnly = false, isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRES_NEW, rollbackForClassName = "UserDao")

	public void log(String log) {
		String sql = "insert into log values(?)";
		jdbcTemplate.update(sql, log);
	}
}
