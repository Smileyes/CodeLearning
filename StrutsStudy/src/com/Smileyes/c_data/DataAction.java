package com.Smileyes.c_data;

import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;

/*
 *数据的封装与类型转换 
 */
public class DataAction extends ActionSupport {
	private String name;
	private int age;
	private Date birth;

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String execute() throws Exception {
		System.out.println(birth);
		return "success";
	}
}
