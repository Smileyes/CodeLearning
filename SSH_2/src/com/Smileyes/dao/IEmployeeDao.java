package com.Smileyes.dao;

import java.util.List;

import com.Smileyes.entity.Employee;

/*
 * EmployeeDao的接口
 *
 * @author Smileyes
 *
 */
public interface IEmployeeDao {
	/*
	 * 获得所有员工
	 */
	List<Employee> getAll();

	/*
	 * 主键查询
	 */
	Employee findById(int id);

	/*
	 * 添加员工
	 */
	void add(Employee employee);

	/*
	 * 修改员工
	 */
	void update(Employee employee);

	/*
	 * 根据主键删除员工
	 */
	void delete(int id);

	/*
	 * 根据名称模糊查询
	 */
	List<Employee> findByName(String name);
}
