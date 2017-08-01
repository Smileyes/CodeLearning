package com.Smileyes.dao;

import java.util.List;

import com.Smileyes.entity.Dept;

/*
 * 部门dao接口
 * 
 * @author Smileyes
 *
 */
public interface IDeptDao {
	/*
	 * 获得所有
	 */
	List<Dept> getAll();

	/*
	 * 主键查询
	 */
	Dept findById(int id);
}
