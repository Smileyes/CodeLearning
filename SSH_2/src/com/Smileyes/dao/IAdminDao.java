package com.Smileyes.dao;

import com.Smileyes.entity.Admin;

/*
 * 管理员Dao接口
 * 
 * @author Smileyes
 *
 */
public interface IAdminDao {
	public Admin find(Admin admin);

	public void change(Admin admin);
}
