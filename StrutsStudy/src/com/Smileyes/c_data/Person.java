package com.Smileyes.c_data;

import java.util.Date;

/*
 * 人类~
 * @author Smileyes
 * */
public class Person {
	private String name;
	private int age;
	private Date birth;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}
}