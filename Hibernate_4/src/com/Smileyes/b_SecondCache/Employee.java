package com.Smileyes.b_SecondCache;

/*
 *员工类 
 *包含所属部门的对象 
 */
public class Employee {
	private int id;
	private String name;
	private Dept dept;

	public int getId() {
		return id;
	}

	public String toString() {
		return "ID：" + id + "  姓名:" + name;
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
