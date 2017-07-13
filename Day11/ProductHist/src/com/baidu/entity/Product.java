package com.baidu.entity;

public class Product {
	public String id;
	public String name;
	public String type;
	public String price;

	public Product(String id, String name, String type, String price) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.price = price;
	}

	public String toString() {
		return  "名称：" + name + "&nbsp;&nbsp;&nbsp;型号:" + type + "&nbsp;&nbsp;&nbsp;价格:" + price;
	}

}
