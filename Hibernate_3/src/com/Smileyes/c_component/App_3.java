package com.Smileyes.c_component;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

/*
 * 主键映射
 * 车包括车轮 
 * 最终生成一个表
 */
public class App_3 {
	private SessionFactory sf = new Configuration().configure().addClass(Car.class)
			.buildSessionFactory();

	@Test
	public void save() {
		Car car = new Car();
		Wheel wheel = new Wheel();
		wheel.setNum(4);
		wheel.setTypeName("华电牌轮胎");
		car.setName("宝马");
		car.setWheels(wheel);
		Session session = sf.openSession();
		session.save(car);
		session.beginTransaction().commit();
		session.close();
	}
}
