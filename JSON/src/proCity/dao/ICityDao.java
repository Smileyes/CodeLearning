package proCity.dao;

import java.util.List;

import proCity.bean.City;

public interface ICityDao {

	City find(String cityName);

	List<City> getCities(int id);
}
