package com.Smileyes.validation;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport {
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	// 注册
	public String register() throws Exception {
		return SUCCESS;
	}

	/*
	 * // 数据校验方法 public void validate() { System.out.println("全局validate方法执行了"); if
	 * (user == null || "".equals(user.getName())) { super.addFieldError("userName",
	 * "用户名未填写"); }
	 * 
	 * }
	 */

	/*
	 * // 数据校验方法 public void validateRegister() {
	 * System.out.println("局部validate方法执行了"); if (user == null ||
	 * "".equals(user.getName())) { super.addFieldError("userName", "用户名未填写"); } }
	 */

	// 列表
	public String list() throws Exception {
		return "list";
	}

}
