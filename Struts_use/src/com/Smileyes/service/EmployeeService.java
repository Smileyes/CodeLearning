package com.Smileyes.service;

import java.util.List;

import com.Smileyes.dao.EmployeeDao;
import com.Smileyes.entity.Employee;

public class EmployeeService {
	public EmployeeDao dao = new EmployeeDao();

	// 获得所有员工信息
	public List<Employee> getAll() {
		return dao.getAll();
	}

	// 添加员工
	public void add(Employee employee) {
		this.dao.add(employee);
	}

	// 查询员工信息
	public Employee findByID(int id) {
		return dao.findById(id);
	}

	// 修改员工信息
	public void update(Employee employee) {
		dao.update(employee);
	}

}
