package com.Smileyes.dao;

import java.util.List;

/*
 * 基本Dao接口
 * 
 * @author Smileyes
 *
 */
public interface IBaseDao<T> {
	/*
	 * 获得所有
	 */
	public List<T> getAll();

	/*
	 * 主键查询
	 */
	public T findById(int id);

	/*
	 * 添加
	 */
	public void add(T t);

	/*
	 * 修改
	 */
	public void update(T t);

	/*
	 * 主键删除
	 */
	public void delete(int id);

	/*
	 * 名称模糊查询
	 */
	public List<T> findByName(String name);

}
