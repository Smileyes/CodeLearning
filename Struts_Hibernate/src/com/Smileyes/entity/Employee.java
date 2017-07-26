package com.Smileyes.entity;

/*
 * 员工类 
 * @Param  id:员工id
 * @Param  name:员工名称
 * @Param  dept:所属部门
 */

public class Employee {
	private int id;
	private String name;
	private String password;
	private Dept dept;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	public String toString() {
		return id + "-" + name + "-" + dept.getName();
	}

	public int hashCode() {
		return super.hashCode();
	}

	public boolean equals(Object obj) {
		if (obj instanceof Employee) {
			// 判断对象是否处于Employee类
			Employee emp = (Employee) obj;
			if (id == emp.getId()) {
				// ID相同，则表示两个员工为同一个人
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

}
