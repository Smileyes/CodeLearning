package com.Smileyes.h_jdbc;

/*
 * 实体类
 * 
 * @author Smileyes
 *
 */
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

	public String toString() {
		return id + ":" + name;
	}
}
