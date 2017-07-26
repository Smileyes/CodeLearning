package com.Smileyes.service;

import java.util.List;

import com.Smileyes.dao.DeptDao;
import com.Smileyes.entity.Dept;

public class DeptService {
	private DeptDao dao = new DeptDao();

	/*
	 * 查找所有
	 */
	public List<Dept> getAll() {
		return this.dao.getAll();
	}

	/*
	 * 通过id查询
	 */
	public Dept findById(int id) {
		return this.dao.findById(id);
	}

	// 添加
	public void add(Dept dept) {
		this.dao.add(dept);
	}

	/*
	 * 修改对象
	 */
	public void update(Dept dept) {
		this.dao.update(dept);
	}

	/*
	 * 删除对象
	 */
	public void remove(Dept dept) {
		this.dao.remove(dept);
	}

	/*
	 * 删除指定id的对象
	 */
	public void remove(int id) {
		this.dao.remove(id);
	}

}
