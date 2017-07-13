package com.baidu.test;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import com.baidu.entity.Product;

public class ProductDaoTest {
	public static List<Product> list = new<Product> LinkedList();
	static {
		for (int i = 1; i < 7; i++) {
			list.add(new Product(i + "", "笔记本" + i, "CNH" + i, i * 1000 + ""));
		}
	}

	public Product findById(String id) {
		for (Product p : list) {
			if (id.equals(p.id))
				return p;
		}
		return null;
	}
	@Test
	public void show(){
		ProductDaoTest n=new ProductDaoTest();
		for(Product p:n.list){
			System.out.println(p);
		}
	}
}
