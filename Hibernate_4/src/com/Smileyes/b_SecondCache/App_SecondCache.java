package com.Smileyes.b_SecondCache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.junit.Test;

/*
 *测试二级缓存 
 */
public class App_SecondCache {
	private static SessionFactory sf;
	static {
		sf = new Configuration().configure().buildSessionFactory();
	}

	/*
	 * 二级缓存
	 * select employee0_.id as id1_1_0_, employee0_.name as name2_1_0_,
	 * employee0_.deptId as deptId3_1_0_ from employee employee0_ where
	 * employee0_.id=? 
	 * 张三 
	 * ------分界线------ 
	 * 张三
	 */
	
	public void test() {
		Session session1 = sf.openSession();
		Employee emp1 = session1.get(Employee.class, 1);
		System.out.println(emp1.getName());
		
		System.out.println("------分界线------");
		session1.close();// 关闭第一个session
		Session session2 = sf.openSession();
		Employee emp2 = session2.get(Employee.class, 1);
		System.out.println(emp2.getName());
		

	}
	/*
	 *测试查询缓存 
	 *HQL查询
	 */
	@Test
	public void queryTest() {
		Session session1 = sf.openSession();		
		Query q1 = session1.createQuery("select name from Dept").setCacheable(true);
		q1.setCacheRegion("org.hibernate.cache.internal.StandardQueryCache");
		System.out.println(q1.list());
		System.out.println("------分界线------");
		session1.close();// 关闭第一个session
		Session session2 = sf.openSession();
		Query q2 = session2.createQuery("select name from Dept").setCacheable(true);
		q2.setCacheRegion("org.hibernate.cache.internal.StandardQueryCache");
		System.out.println(q2.list());
		

	}
}
