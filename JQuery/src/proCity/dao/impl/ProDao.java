package proCity.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import proCity.bean.Province;
import proCity.dao.IProDao;

@Repository	
public class ProDao implements IProDao {
	@Resource
	private SessionFactory sessionFactory;

	public List<Province> getAll() {
		return sessionFactory.getCurrentSession().createQuery("from Province").list();
	}

	public Province find(String proName) {
		return (Province) sessionFactory.getCurrentSession()//
				.createQuery("from Province where name=?")//
				.setParameter(0, proName).list().get(0);
	}
}
