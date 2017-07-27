package com.Smileyes.e_anno;

import org.springframework.stereotype.Component;

//多功能标签，可以代替之前的Controller、Service和Reposity中的任意一个
@Component("user")
public class User {
	private int id;
	private String name;

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
		System.out.println("user对象建立:有参");
	}

	public User() {
		System.out.println("user对象建立");

	}

	public String toString() {

		return id + ":" + name;
	}
}
