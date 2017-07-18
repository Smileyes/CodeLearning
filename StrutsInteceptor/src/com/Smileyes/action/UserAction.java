package com.Smileyes.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.Smileyes.entity.User;
import com.Smileyes.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
	private UserService service = new UserService();
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String list() {
		List<User> list = service.getAll();
		ActionContext ac = ActionContext.getContext();
		Map<String, Object> request = ac.getContextMap();
		request.put("list", list);
		return "success";
	}

	public String login() {
		if (user == null) {
			return "failed";
		}
		User result = service.find(user);
		if (result == null) {
			// 登录失败
			return "failed";
		}
		// 登录成功
		ActionContext ac = ActionContext.getContext();
		Map<String, Object> session = ac.getSession();
		session.put("login", user.getUserName());
		List<User> list = service.getAll();
		Map<String, Object> request = ac.getContextMap();
		request.put("list", list);
		return "success";
	}
}
