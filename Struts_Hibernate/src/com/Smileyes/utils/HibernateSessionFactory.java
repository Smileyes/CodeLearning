package com.Smileyes.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/*
 *Session工厂类，用于生成session 
 */
public class HibernateSessionFactory {
	private static SessionFactory sf;
	static {
		sf = new Configuration().configure().buildSessionFactory();
	}

	public static Session getSession() {
		return sf.getCurrentSession();
	}
}
