package com.Smileyes.c_component;

/*
 *车类 
 */
public class Car {
	private int id;
	private String name;
	private Wheel wheels;

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

	public Wheel getWheels() {
		return wheels;
	}

	public void setWheels(Wheel wheels) {
		this.wheels = wheels;
	}

}
