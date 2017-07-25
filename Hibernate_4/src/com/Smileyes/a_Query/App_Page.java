package com.Smileyes.a_Query;

import java.util.List;

import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.junit.Test;

/*
 分页
 */
public class App_Page {
	private static SessionFactory sf = new Configuration().configure().addClass(Dept.class)
			.addClass(Employee.class).buildSessionFactory();

	@Test
	public void myTest() {
		Session session = sf.openSession();
		Query query = session.createQuery("from Employee");
		ScrollableResults scroll = query.scroll();// 滚动的结果集
		scroll.last();// 滚到最后一行
		int number = scroll.getRowNumber();
		query.setFirstResult(1);// 设置本页起点(记录从0开始计算)
		query.setMaxResults(3);// 设置本页记录数量
		List list = query.list();
		System.out.println(list);
	}
}
