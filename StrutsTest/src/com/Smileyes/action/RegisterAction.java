package com.Smileyes.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Smileyes.entity.User;
import com.Smileyes.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/*
 * 用于处理注册的请求
 * */
public class RegisterAction extends ActionSupport {
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserService service = new UserService();

	public String register() {
		service.add(user);
		return "success";
	}
}
