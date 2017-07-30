package com.Smileyes.b_anno;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/*
 * UserService类
 * 
 * @author Smileyes
 *
 */
@Service
public class UserService {
	@Resource
	private UserDao userDao;
	@Resource
	private LogDao logDao;
	/*
	 * 保存用户
	 */
	private DataSource dataSource;

	
	public void save(User user) {
		this.logDao.log("输出日志");
		int i = 1 / 0;
		this.userDao.save(user);
	}

}
