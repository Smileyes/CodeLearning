package com.Smileyes.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.Smileyes.utils.HibernateSessionFactory;

public abstract class BaseDao<T> {
	private Class clazz;
	private String tableName;

	public BaseDao() {
		Type type = this.getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) type;
		Type[] types = pt.getActualTypeArguments();
		clazz = (Class) types[0];
		tableName = clazz.getSimpleName();
	}

	/*
	 * 查找所有
	 */
	public List<T> getAll() {
		Session session = HibernateSessionFactory.getSession();
		String sql = "from " + tableName;
		Query query = session.createQuery(sql);
		return query.list();
	}

	/*
	 * 通过id查询
	 */
	public T findById(int id) {
		Session session = HibernateSessionFactory.getSession();
		String sql = "from " + tableName + " where id=?";
		Query query = session.createQuery(sql);
		query.setParameter(0, id);
		List list = query.list();
		if ((list != null) && (list.size() != 0)) {
			return (T) list.get(0);
		} else {
			return null;
		}
	}

	public abstract T find(T t);

	// 添加
	public void add(T t) {
		Session session = HibernateSessionFactory.getSession();
		session.saveOrUpdate(t);
	}

	/*
	 * 修改对象
	 */
	public void update(T t) {
		Session session = HibernateSessionFactory.getSession();
		session.update(t);
	}

	/*
	 * 删除对象
	 */
	public void remove(T t) {
		Session session = HibernateSessionFactory.getSession();
		session.delete(t);
	}

	/*
	 * 删除指定id的对象
	 */
	public void remove(int id) {
		T t = this.findById(id);
		if (t != null) {
			System.out.println("123456789");
			Session session = HibernateSessionFactory.getSession();
			session.delete(t);
		}
	}
}
