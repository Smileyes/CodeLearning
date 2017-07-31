package com.Smileyes.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/*
 * 基本Dao，定义dao的公有方法
 * 
 * @author Smileyes
 *
 */
public abstract class BaseDao<T> {
	protected SessionFactory sessionFactory;
	private Class<?> clazz;
	private String tableName;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

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
		Session session = sessionFactory.getCurrentSession();
		String sql = "from " + tableName;
		Query query = session.createQuery(sql);
		return query.list();
	}

	/*
	 * 通过id查询
	 */
	public T findById(int id) {
		Session session = sessionFactory.getCurrentSession();
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

	/**
	 * 查询对象
	 * 
	 * @param t
	 * @return
	 */
	public abstract T find(T t);

	// 添加
	public void add(T t) {
		sessionFactory.getCurrentSession().saveOrUpdate(t);
	}

	/*
	 * 修改对象
	 */
	public void update(T t) {
		sessionFactory.getCurrentSession().update(t);
	}

	/*
	 * 删除对象
	 */
	public void remove(T t) {
		sessionFactory.getCurrentSession().delete(t);
	}

	/*
	 * 删除指定id的对象
	 */
	public void remove(int id) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(this.findById(id));
	}
}
