package com.Smileyes.d_autowire;

public class UserAction {
	private UserService userService;

	public UserAction() {
		System.out.println("Action对象建立");
	}

	public User excute() {
		return this.userService.create();
	}

	public void setUserService(
			UserService userService) {
		this.userService = userService;
	}

}
