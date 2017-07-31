package com.Smileyes.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.Smileyes.entity.Employee;

public class EmployeeDao extends BaseDao<Employee> {

	/*
	 * 判断用户名和密码是否匹配
	 */
	public Employee find(Employee employee) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Employee where name=? and password=?");
		query.setParameter(0, employee.getName());
		query.setParameter(1, employee.getPassword());
		List<Employee> list = query.list();
		if ((list != null) && (list.size() != 0)) {
			return list.get(0);
		} else {
			return null;
		}
	}

}
