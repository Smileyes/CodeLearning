package com.Smileyes.a_static;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

/*
 * UserDao的静态代理类
 * 
 * @author Smileyes
 *
 */
@Component
public class UserDaoProxy implements IUserDao {
	@Resource
	private IUserDao target;

	public void setTarget(IUserDao target) {
		this.target = target;
	}

	public void save() {
		System.out.println("------开始事务------");
		target.save();
		System.out.println("------完成事务------");
	}

	public UserDaoProxy(IUserDao target) {
		this.target = target;
	}

}
