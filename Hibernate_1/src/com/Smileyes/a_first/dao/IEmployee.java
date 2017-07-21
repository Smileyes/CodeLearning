package com.Smileyes.a_first.dao;

import java.util.List;

/*
 * 员工CRUD接口
 */
public interface IEmployee<T> {
	public void add(T t);

	public void remove(T t);

	public void update(T t);

	public T findById(int id);

	public List<T> getAll();
}
