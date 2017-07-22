package com.Smileyes.b_one2many;

import java.util.Set;

/*
 *部门表 
 */
public class Dept {
	private int id;
	private String name;
	private Set<Employee> emps;

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

	public Dept(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Dept() {
		super();
	}
}
