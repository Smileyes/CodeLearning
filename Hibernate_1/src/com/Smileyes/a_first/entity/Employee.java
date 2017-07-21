package com.Smileyes.a_first.entity;

import java.util.Date;

/*
 1.员工实体类
 @param Id：员工id；
 @param gender：员工性别：1男0女；
 @param woekDate：员工入职时间
 */
public class Employee {

	private int id;
	private int gender;
	private Date WorkDate;
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int Gender) {
		this.gender = gender;
	}

	public Date getWorkDate() {
		return WorkDate;
	}

	public void setWorkDate(Date WorkDate) {
		this.WorkDate = WorkDate;
	}

	public Employee(int id, String name, int gender, Date WorkDate) {
		this.id = id;
		this.gender = gender;
		this.WorkDate = WorkDate;
		this.name = name;
	}

	public Employee() {
		super();
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("id=" + id);
		sb.append("    姓名=" + name);
		sb.append("    性别=");
		sb.append(gender == 1 ? "男" : "女");
		sb.append("    入职时间=");
		sb.append(WorkDate);
		sb.append("\n");
		return sb.toString();
	}
}
