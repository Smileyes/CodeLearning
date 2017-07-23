package com.Smileyes.e_extends_2;

/*
 *猫类，继承自动物类 
 */
public class Cat extends Animal {
	private String hairColor;
	private String food;

	public String getHairColor() {
		return hairColor;
	}

	public void setHairColor(String hairColor) {
		this.hairColor = hairColor;
	}

	public String getFood() {
		return food;
	}

	public void setFood(String food) {
		this.food = food;
	}
}
