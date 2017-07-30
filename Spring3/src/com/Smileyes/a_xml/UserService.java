package com.Smileyes.a_xml;

/*
 * UserService类
 * 
 * @author Smileyes
 *
 */
public class UserService {
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	/*
	 * 保存用户
	 */
	public void save(User user) {
		this.userDao.save(user);
		int id=1/0;
	}
}
