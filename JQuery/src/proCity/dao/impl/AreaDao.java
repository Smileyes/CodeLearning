package proCity.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import proCity.bean.Area;
import proCity.dao.IAreaDao;

@Repository

public class AreaDao implements IAreaDao {
	@Resource
	private SessionFactory sessionFactory;

	public List<Area> getAreas(int cityId) {
		return sessionFactory.getCurrentSession()//
				.createQuery("from Area where cityId=?")//
				.setParameter(0, cityId).list();
	}

}
