package com.Smileyes.action;

import com.Smileyes.entity.User;
import com.Smileyes.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

/*
 *  用于处理关于用户登录/注册的请求
 * */
public class UserAction extends ActionSupport {
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserService service = new UserService();

	// 处理用户登录
	public String login() {
		if (user != null) {
			System.out.println(user.getName() + ":" + user.getPassword());
		} else {

		}
		if (service.login(user)) {
			return "success";
		} else {
			return "failed";
		}
	}

	public String register() {
		service.add(user);
		return "success";
	}
}
