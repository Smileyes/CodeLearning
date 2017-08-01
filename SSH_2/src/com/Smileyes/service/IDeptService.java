package com.Smileyes.service;

import java.util.List;

import com.Smileyes.entity.Dept;

/*
 * 部门service接口
 * 
 * @author Smileyes
 *
 */
public interface IDeptService {
	/*
	 * 获得所有部门
	 */
	List<Dept> getAll();

	/*
	 * 根据主键查询
	 */
	Dept findById(int id);
}
