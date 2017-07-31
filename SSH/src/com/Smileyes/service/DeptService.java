package com.Smileyes.service;

import java.util.List;

import com.Smileyes.dao.DeptDao;
import com.Smileyes.entity.Dept;

public class DeptService {
	private DeptDao deptDao;

	public void setDeptDao(DeptDao deptDao) {
		this.deptDao = deptDao;
	}

	/*
	 * 查找所有
	 */
	public List<Dept> getAll() {
		return this.deptDao.getAll();
	}

	/*
	 * 通过id查询
	 */
	public Dept findById(int id) {
		return this.deptDao.findById(id);
	}

	// 添加
	public void add(Dept dept) {
		this.deptDao.add(dept);
	}

	/*
	 * 修改对象
	 */
	public void update(Dept dept) {
		this.deptDao.update(dept);
	}

	/*
	 * 删除对象
	 */
	public void remove(Dept dept) {
		this.deptDao.remove(dept);
	}

	/*
	 * 删除指定id的对象
	 */
	public void remove(int id) {
		this.deptDao.remove(id);
	}

}
