package proCity.dao;

import java.util.List;

import proCity.bean.Area;
import proCity.bean.City;

public interface IAreaDao {

	List<Area> getAreas(int id);
}
