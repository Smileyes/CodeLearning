package com.Smileyes.a_mapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Test;

/*
 *测试集合映射是否配置成功 
 */
public class App1 {
	private static SessionFactory sf = new Configuration().configure().addClass(Customer.class)
			.buildSessionFactory();

	// 保存
	@Test
	public void save() {
		Session session = sf.openSession();

		Customer cust = new Customer();
		cust.setId(1);// 设置顾客id
		cust.setName("小明");
		// 设置顾客姓名
		/*// 建立顾客购买商品的Set列表
		Set<String> set = new HashSet<String>();
		set.add("西瓜");
		set.add("");
		cust.setGoods(set);*/
		
		/*
		//商品集合为List
		List<String> list = new ArrayList<String>();
		list.add("西瓜");
		list.add("冬瓜");
		list.add("南瓜");
		cust.setGoods(list);*/
		
		//商品列表为Map
		Map<Integer,String> map = new HashMap<Integer,String>();
		map.put(1, "花生");
		map.put(2, "莲子");
		map.put(3, "桂圆");
		cust.setGoods(map);
		// 保存顾客
		session.saveOrUpdate(cust);
		session.beginTransaction().commit();// 提交
		session.close();
	}
	@After
	public void get() {
		Customer cust = sf.openSession().get(Customer.class, 1);
		System.out.println(cust.getName());
		System.out.println(cust.getGoods());
	}
}
