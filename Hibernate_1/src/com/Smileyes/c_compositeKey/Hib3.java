package com.Smileyes.c_compositeKey;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.Test;

import com.Smileyes.b_config.User;

public class Hib3 {
	@Test
	public void testDo() {
		// 获得
		Configuration config = new Configuration();
		SessionFactory sf = config.configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		People p1 = new People(new CompositeKeys("张三", "河北"), 20);
		People p2 = new People(new CompositeKeys("李四", "河南"), 22);
		session.save(p1);
		session.save(p2);
		tr.commit();
		session.close();
	}
}
