package com.Smileyes.b_anno;

import org.springframework.stereotype.Component;

/*
 * 实体类User
 * 
 * @author Smileyes
 *
 */
@Component
public class User {
	private int id;
	private String name;

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

}
