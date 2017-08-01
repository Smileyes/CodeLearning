package com.Smileyes.dao.impl;

import org.hibernate.SessionFactory;

import com.Smileyes.dao.IAdminDao;
import com.Smileyes.entity.Admin;

public class AdminDao implements IAdminDao {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Admin find(Admin admin) {
		return (Admin) sessionFactory.getCurrentSession()
				.createQuery("from Admin where name=? and password=?")
				.setParameter(0, admin.getName())//
				.setParameter(1, admin.getPassword())//
				.uniqueResult();
	}

	public void change(Admin admin) {
		int status = admin.getStatus() == 0 ? 1 : 0;
		sessionFactory.getCurrentSession()
				.createQuery("update Admin set status=? where id=?")
				.setParameter(0, status)//
				.setParameter(1, admin.getId())//
				.executeUpdate();
	}

}
