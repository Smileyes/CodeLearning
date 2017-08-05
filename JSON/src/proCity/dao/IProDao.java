package proCity.dao;

import java.util.List;

import proCity.bean.Province;

public interface IProDao {
	List<Province> getAll();

	Province find(String proName);
}
