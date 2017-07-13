package com.Smileyes.frame.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Smileyes.entity.User;
import com.Smileyes.service.UserService;
import com.Smileyes.utils.WebUtils;

/*
 * 用于处理注册的请求
 * */
public class RegisterAction {
	public UserService service = new UserService();

	public String register(HttpServletRequest request, HttpServletResponse response) {
		User user = WebUtils.copyToBean(request, User.class);
		service.add(user);
		return "success";
	}
}
