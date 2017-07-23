package com.Smileyes.e_extends_2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.Smileyes.c_component.Car;
import com.Smileyes.c_component.Wheel;

/*
 *多个继承：
 *将每个子类对应一个表，父类则不建表
 *采用union-subclass标签 
 */
public class App_4 {
	private SessionFactory sf = new Configuration().configure().addClass(Animal.class)
			.buildSessionFactory();

	@Test
	public void save() {
		Cat cat = new Cat();
		cat.setName("猫");
		cat.setHairColor("灰色");
		cat.setFood("小鱼");
/*		cat.setId(1);*/
		Monkey monkey = new Monkey();
		monkey.setName("猴");
		monkey.setLength(98.7);
		monkey.setFruit("香蕉");
	/*	monkey.setId(2);*/
		Session session = sf.openSession();
		session.save(cat);
		session.save(monkey);
		session.beginTransaction().commit();
		session.close();
	}
}
