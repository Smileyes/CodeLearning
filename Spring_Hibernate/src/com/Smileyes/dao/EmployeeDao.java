package com.Smileyes.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.Smileyes.entity.Employee;

/*
 * 用户Dao
 * 
 * @author Smileyes
 *
 */
public class EmployeeDao {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/*
	 * 保存
	 */
	public void save(Employee employee) {
		sessionFactory.getCurrentSession().save(employee);
	}
}
