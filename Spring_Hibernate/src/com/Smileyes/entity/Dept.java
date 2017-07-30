package com.Smileyes.entity;

import java.util.Set;

/*
 * 部门类
 * 
 * @author Smileyes
 *
 */
public class Dept {
	private int id;
	private String name;
	private Set<Employee> employees;

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

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
}
