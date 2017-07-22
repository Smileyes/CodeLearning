package com.Smileyes.a_mapping;

import java.util.List;
import java.util.Map;

/*
 *顾客类 
 *@param id 编号
 *@param name 姓名
 *@param goods 购买的商品
 */
public class Customer {
	private int id;
	private String name;
	// private Set<String> goods;
	// private List<String> goods;
	private Map<Integer, String> goods;

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

	public Map<Integer, String> getGoods() {
		return goods;
	}

	public void setGoods(Map<Integer, String> goods) {
		this.goods = goods;
	}

}
