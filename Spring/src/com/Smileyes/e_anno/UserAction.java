package com.Smileyes.e_anno;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

//控制层
@Controller("userAction")
public class UserAction {
	// 属性
	@Resource(name = "userService")
	private UserService userService;

	public UserAction() {
		System.out.println("Action对象建立");
	}

	public User excute() {
		if (userService == null) {
			System.out.println("2348646545645");
			return new User();
		}
		return this.userService.create();
	}

	public void setUserService(
			UserService userService) {
		this.userService = userService;
	}

}
