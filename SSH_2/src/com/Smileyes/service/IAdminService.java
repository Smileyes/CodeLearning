package com.Smileyes.service;

import com.Smileyes.entity.Admin;

/*
 * Admin服务接口
 * 
 * @author Smileyes
 *
 */
public interface IAdminService {
	/*
	 * 登录
	 */
	public Admin login(Admin admin);

	/*
	 * 改变登录状态
	 */
	public void changeStatus(Admin admin);
}
