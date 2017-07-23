package com.Smileyes.a_one2one_1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

/*
 * 基于外键的一对一映射：IdCard的主键为cardNum，person_id为外键，且满足唯一 
 */
public class App1 {
	private static SessionFactory sf;
	static {
		sf = new Configuration().configure().addClass(Person.class).addClass(IdCard.class)
				.buildSessionFactory();
	}

	@Test
	public void get() {
		Person p = new Person();
		IdCard card = new IdCard();
		p.setName("小明");
		card.setCardNum("621785199509210236");
		card.setAddress("中国");
		card.setPerson(p);
		Session session = sf.openSession();
		/* session.save(p); */
		session.save(card);
		session.beginTransaction().commit();
		session.close();
	}
}
