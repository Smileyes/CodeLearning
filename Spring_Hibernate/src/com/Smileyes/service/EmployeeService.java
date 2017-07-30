package com.Smileyes.service;

import com.Smileyes.dao.EmployeeDao;
import com.Smileyes.entity.Employee;

/*
 * Employee服务类
 * 
 * @author Smileyes
 *
 */
public class EmployeeService {
	private EmployeeDao employeeDao;

	/*
	 * 保存
	 */
	public void save(Employee employee) {
		employeeDao.save(employee);
	}

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

}
