package com.Smileyes.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import com.Smileyes.dao.IBaseDao;
import com.Smileyes.entity.Employee;

public class BaseDao<T> implements IBaseDao<T> {
	private Class clazz;
	private String tableName;
	private SessionFactory sessionFactory;

	/*
	 * 确定对应的类与表
	 */
	public BaseDao() {
		Type type = this.getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) type;
		Type[] types = pt.getActualTypeArguments();
		clazz = (Class) types[0];
		tableName = clazz.getSimpleName();
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List<T> getAll() {

		return sessionFactory.getCurrentSession().//
				createQuery("from " + tableName).list();
	}

	public T findById(int id) {
		return (T) sessionFactory.getCurrentSession()//
				.get(clazz, id);
	}

	public void add(T t) {
		sessionFactory.getCurrentSession().save(t);
	}

	public void update(T t) {
		sessionFactory.getCurrentSession().update(t);
	}

	public void delete(int id) {
		sessionFactory.getCurrentSession()
				.createQuery("delete from " + tableName + " where id = ?")//
				.setParameter(0, id).executeUpdate();
	}

	public List<T> findByName(String name) {
		return sessionFactory.getCurrentSession()//
				.createQuery("from " + tableName + " where name like ?")//
				.setParameter(0, "%" + name + "%").list();
	}

}
