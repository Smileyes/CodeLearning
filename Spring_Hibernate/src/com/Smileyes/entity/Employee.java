package com.Smileyes.entity;

/*
 * 员工类
 * 
 * @author Smileyes
 *
 */
public class Employee {
	private int id;
	private String name;
	private Dept dept;

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

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

}
