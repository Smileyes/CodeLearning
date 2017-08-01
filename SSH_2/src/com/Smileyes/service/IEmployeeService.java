package com.Smileyes.service;

import java.util.List;

import com.Smileyes.entity.Employee;

/*
 * 员工服务类
 * 
 * @author Smileyes
 *list：显示列表
update：修改
delete：删除
fing：查找
add：添加
 */
public interface IEmployeeService {
	/*
	 * 列表查询
	 */
	public List<Employee> list();

	/*
	 * 修改
	 */
	public void update(Employee employee);

	/*
	 * 删除
	 */
	public void delete(int id);

	/*
	 * 主键查找
	 */
	public Employee find(int id);

	/*
	 * 添加员工
	 */
	public void add(Employee employee);

	/*
	 * 根据名称模糊查询
	 */
	List<Employee> findByName(String name);
}
