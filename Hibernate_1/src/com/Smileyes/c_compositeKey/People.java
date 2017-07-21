package com.Smileyes.c_compositeKey;

public class People {
	private CompositeKeys compositeKeys;// 关联主键对象
	private int age;

	public People() {
	}

	public int getAge() {
		return age;
	}

	public People(CompositeKeys compositeKeys, int age) {
		super();
		this.compositeKeys = compositeKeys;
		this.age = age;
	}

	public CompositeKeys getCompositeKeys() {
		return compositeKeys;
	}

	public void setCompositeKeys(CompositeKeys compositeKeys) {
		this.compositeKeys = compositeKeys;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
