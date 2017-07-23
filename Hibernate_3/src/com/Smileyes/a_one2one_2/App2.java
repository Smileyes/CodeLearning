package com.Smileyes.a_one2one_2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.Smileyes.a_one2one_1.IdCard;
import com.Smileyes.a_one2one_1.Person;

/*
 * 基于主键的一对一映射：person_id为外键，同时还是主键 
 */
public class App2 {
	private SessionFactory sf = new Configuration().configure().addClass(Person.class)
			.addClass(IdCard.class).buildSessionFactory();

	@Test
	public void get() {
		Person p = new Person();
		IdCard card = new IdCard();
		p.setName("小明");
		card.setCardNum("621785199509210236");
		card.setAddress("中国");
		card.setPerson(p);
		Session session = sf.openSession();
		session.save(card);
		/* session.save(p); */
		session.beginTransaction().commit();
		session.close();
	}
}
