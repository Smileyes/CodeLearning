package com.Smileyes.a_first.service;

import java.util.List;

import com.Smileyes.a_first.dao.EmployeeDao;
import com.Smileyes.a_first.entity.Employee;

public class EmployeeService {
	public EmployeeDao dao = new EmployeeDao();

	// 增加
	public void add(Employee employee) {
		this.dao.add(employee);
	}

	// 删除
	public void remove(Employee employee) {
		this.dao.remove(employee);
	}

	// 修改
	public void update(Employee employee) {
		this.dao.update(employee);

	}

	// 查询
	public Employee findById(int id) {
		return this.dao.findById(id);
	}

	// 查询全部
	public List<Employee> getAll() {
		return this.dao.getAll();
	}

}
