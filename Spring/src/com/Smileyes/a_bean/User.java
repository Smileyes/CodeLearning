package com.Smileyes.a_bean;

/*
 *用户类 
 */
public class User {
	private int id;
	private String name;

	public void init_user() {
		System.out.println("启动！！！");
	}

	public void destroy_user() {
		System.out.println("销毁！！！");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User(int id, String name) {
		this.id = id;
		this.name = name;
		System.out.println("调用了有参的构造器");
	}

	public User() {
		System.out.println("调用了无参的构造器");
	}

}
