package proCity.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import proCity.bean.City;
import proCity.dao.ICityDao;

@Repository
public class CityDao implements ICityDao {
	@Resource
	private SessionFactory sessionFactory;

	/*
	 * 寻找城市
	 */
	public City find(String cityName) {
		return (City) sessionFactory.getCurrentSession()//
				.createQuery("from City where name=?")//
				.setParameter(0, cityName).list().get(0);
	}

	/*
	 * 获得城市
	 */
	public List<City> getCities(int id) {
		List list = sessionFactory.getCurrentSession()//
				.createQuery("from City where proId=?")//
				.setParameter(0, id).list();
		return list;
	}
}
