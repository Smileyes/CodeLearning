package com.Smileyes.c_property_p;

public class UserAction {
	private UserService userService;

	public void setUserService(
			UserService userService) {
		this.userService = userService;
	}

	public UserAction() {
		System.out.println("Action对象建立");
	}

	public User excute() {
		return this.userService.create();
	}

}
