package com.Smileyes.service.impl;

import java.util.List;

import com.Smileyes.dao.IDeptDao;
import com.Smileyes.entity.Dept;
import com.Smileyes.service.IDeptService;

public class DeptService implements IDeptService {
	private IDeptDao deptDao;

	public void setDeptDao(IDeptDao deptDao) {
		this.deptDao = deptDao;
	}

	public List<Dept> getAll() {
		return deptDao.getAll();
	}

	public Dept findById(int id) {
		return deptDao.findById(id);

	}

}
