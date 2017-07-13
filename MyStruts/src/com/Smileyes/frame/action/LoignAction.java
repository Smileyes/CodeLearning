package com.Smileyes.frame.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Smileyes.entity.User;
import com.Smileyes.service.UserService;
import com.Smileyes.utils.WebUtils;

/*
 *  用于处理登录的请求
 * */
public class LoignAction {
	public UserService service = new UserService();

	public String login(HttpServletRequest request, HttpServletResponse response) {
		User user = WebUtils.copyToBean(request, User.class);
		if (service.login(user)) {
			request.getSession().setAttribute("user",user);
			return "success";
		} else {
			return "failed";
		}
	}
}
