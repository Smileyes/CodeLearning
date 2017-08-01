package com.Smileyes.service.impl;

import java.util.List;

import com.Smileyes.dao.IEmployeeDao;
import com.Smileyes.entity.Employee;
import com.Smileyes.service.IEmployeeService;

public class EmployeeService implements IEmployeeService {
	private IEmployeeDao employeeDao;

	public IEmployeeDao getEmployeeDao() {
		return employeeDao;
	}

	public void setEmployeeDao(IEmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	public List<Employee> list() {
		return employeeDao.getAll();
	}

	public void update(Employee employee) {
		employeeDao.update(employee);
	}

	public void delete(int id) {
		employeeDao.delete(id);
	}

	public Employee find(int id) {
		return employeeDao.findById(id);
	}

	public void add(Employee employee) {
		employeeDao.add(employee);

	}

	public List<Employee> findByName(String name) {
		return this.employeeDao.findByName(name);
	}

}
