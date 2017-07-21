package com.Smileyes.a_first.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.Smileyes.a_first.entity.Employee;
import com.Smileyes.a_first.util.HibUtil;

public class EmployeeDao implements IEmployee<Employee> {
	public Session session;

	// 增加
	public void add(Employee employee) {
		session = HibUtil.getSession();// 获得会话
		Transaction tr = session.beginTransaction();// 开始事务
		session.save(employee);// 保存
		tr.commit();// 提交
		session.close();// 关闭
	}

	// 删除
	public void remove(Employee employee) {
		session = HibUtil.getSession();// 获得会话
		Transaction tr = session.beginTransaction();// 开始事务
		session.remove(employee);// 删除
		tr.commit();// 提交
		session.close();// 关闭
	}

	// 修改
	public void update(Employee employee) {
		session = HibUtil.getSession();// 获得会话
		Transaction tr = session.beginTransaction();// 开始事务
		session.update(employee);// 修改
		tr.commit();// 提交
		session.close();// 关闭

	}

	// 查询
	public Employee findById(int id) {
		session = HibUtil.getSession();// 获得会话
		Employee employee = session.get(Employee.class, id);// 查询
		session.close();// 关闭
		return employee;
	}

	// 获得所有
	public List<Employee> getAll() {
		session = HibUtil.getSession();// 获得会话
		Query query = session.createQuery("from Employee");
		List<Employee> list = query.list();
		session.close();// 关闭
		return list;
	}

}
