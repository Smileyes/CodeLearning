package com.Smileyes.a_first.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/*
 *Hib的Util类，用于获取session会话对象 
 */
public class HibUtil {
	private static SessionFactory sf;
	static {
		Configuration configure = new Configuration();
		configure.configure();
		sf = configure.buildSessionFactory();
	}

	public static Session getSession() {
		return sf.openSession();
	}
}
