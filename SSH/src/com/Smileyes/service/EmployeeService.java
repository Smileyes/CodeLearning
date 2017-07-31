package com.Smileyes.service;

import java.util.List;

import com.Smileyes.dao.EmployeeDao;
import com.Smileyes.entity.Employee;

public class EmployeeService {
	private EmployeeDao employeeDao;

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	/*
	 * 查找所有
	 */
	public List<Employee> getAll() {
		return this.employeeDao.getAll();
	}

	/*
	 * 通过id查询
	 */
	public Employee findById(int id) {
		return this.employeeDao.findById(id);
	}

	// 添加
	public void add(Employee employee) {
		this.employeeDao.add(employee);
	}

	/*
	 * 修改对象
	 */
	public void update(Employee employee) {
		this.employeeDao.update(employee);
	}

	/*
	 * 删除对象
	 */
	public void remove(Employee employee) {
		this.employeeDao.remove(employee);
	}

	/*
	 * 删除指定id的对象
	 */
	public void remove(int id) {
		this.employeeDao.remove(id);
	}

	/*
	 * 查找对象
	 */
	public Employee find(Employee employee) {
		return this.employeeDao.find(employee);
	}
}
