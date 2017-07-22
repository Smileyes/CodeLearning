package com.Smileyes.c_many2many;

import java.util.Set;

/*
 *学生类 
 */
public class Student {
	private int s_id;
	private String s_name;
	private Set<Teacher> teachers;

	public Student(String s_name) {
		super();
		this.s_name = s_name;
	}

	public int getS_id() {
		return s_id;
	}

	public void setS_id(int s_id) {
		this.s_id = s_id;
	}

	public String getS_name() {
		return s_name;
	}

	public void setS_name(String s_name) {
		this.s_name = s_name;
	}

	public Set<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(Set<Teacher> teachers) {
		this.teachers = teachers;
	}

	public Student() {
		super();
	}

	public String toString() {
		return s_id + ":" + s_name;
	}
}
