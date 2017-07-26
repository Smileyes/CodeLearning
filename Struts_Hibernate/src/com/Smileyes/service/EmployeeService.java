package com.Smileyes.service;

import java.util.List;

import com.Smileyes.dao.EmployeeDao;
import com.Smileyes.entity.Employee;

public class EmployeeService {
	private EmployeeDao dao = new EmployeeDao();

	/*
	 * 查找所有
	 */
	public List<Employee> getAll() {
		return this.dao.getAll();
	}

	/*
	 * 通过id查询
	 */
	public Employee findById(int id) {
		return this.dao.findById(id);
	}

	// 添加
	public void add(Employee employee) {
		this.dao.add(employee);
	}

	/*
	 * 修改对象
	 */
	public void update(Employee employee) {
		this.dao.update(employee);
	}

	/*
	 * 删除对象
	 */
	public void remove(Employee employee) {
		this.dao.remove(employee);
	}

	/*
	 * 删除指定id的对象
	 */
	public void remove(int id) {
		this.dao.remove(id);
	}

	/*
	 * 查找对象
	 */
	public Employee find(Employee employee) {
		return this.dao.find(employee);
	}
}
