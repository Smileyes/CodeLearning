package com.Smileyes.d_extends_1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.Smileyes.c_component.Car;
import com.Smileyes.c_component.Wheel;

/*
 *简单继承映射 
 */
public class App_4 {
	private SessionFactory sf = new Configuration().configure().addClass(Cat.class)
			.buildSessionFactory();

	@Test
	public void save() {
		Cat cat = new Cat();
		cat.setName("猫");
		cat.setHairColor("灰色");
		cat.setFood("小鱼");
		Session session = sf.openSession();
		session.save(cat);
		session.beginTransaction().commit();
		session.close();
	}
}
