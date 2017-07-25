package com.Smileyes.a_Query;
/*
 * 部门类 
 * 包含多个员工
 */

import java.util.Set;

public class Dept {
	private int id;
	private String name;
	private Set<Employee> emps;

	public String toString() {
		return "部门：" + id + "  名称:" + name;
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

	public Set<Employee> getEmps() {
		return emps;
	}

	public void setEmps(Set<Employee> emps) {
		this.emps = emps;
	}
}
