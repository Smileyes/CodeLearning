package com.Smileyes.c_many2many;

import java.util.Set;

import org.jboss.logging.Param;

/*
 *教师类 
 */

public class Teacher {
	private int t_id;
	private String t_name;
	private Set<Student> students;

	public String toString() {
		return t_id + ":" + t_name;
	}

	public Teacher(String t_name) {
		super();
		this.t_name = t_name;
	}

	public Teacher() {
		super();
	}

	public Set<Student> getStudents() {
		return students;
	}

	public int getT_id() {
		return t_id;
	}

	public void setT_id(int t_id) {
		this.t_id = t_id;
	}

	public String getT_name() {
		return t_name;
	}

	public void setT_name(String t_name) {
		this.t_name = t_name;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

}
