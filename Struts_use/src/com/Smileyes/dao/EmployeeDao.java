package com.Smileyes.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.Smileyes.entity.Employee;
import com.Smileyes.utils.JdbcUtils;

public class EmployeeDao {
	private QueryRunner qr = JdbcUtils.getQr();

	// 获得所有员工信息
	public List<Employee> getAll() {
		String sql = "select * from  employee";
		try {
			return qr.query(sql, new BeanListHandler<Employee>(Employee.class));
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// 添加员工
	public void add(Employee employee) {
		String sql = "insert into employee (name,gender,workDate) values(?,?,?)";
		try {
			qr.update(sql, employee.getName(), employee.getGender(), employee.getWorkDate());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// 通过id查找
	public Employee findById(int id) {
		String sql = "select * from  employee where id=?";
		try {
			return qr.query(sql, new BeanHandler<Employee>(Employee.class), id);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// 修改员工信息
	public void update(Employee employee) {
		String sql = "update employee set name=?,gender=?,workDate=? where id=?";
		try {
			qr.update(sql, employee.getName(), employee.getGender(), employee.getWorkDate(),
					employee.getId());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
