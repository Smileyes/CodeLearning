package com.Smileyes.service.impl;

import com.Smileyes.dao.IAdminDao;
import com.Smileyes.entity.Admin;
import com.Smileyes.service.IAdminService;

/*
 * Admin服务类
 * 
 * @author Smileyes
 *
 */
public class AdminService implements IAdminService {
	private IAdminDao adminDao;

	public void setAdminDao(IAdminDao adminDao) {
		this.adminDao = adminDao;
	}

	public Admin login(Admin admin) {
		return this.adminDao.find(admin);
	}

	public void changeStatus(Admin admin) {
		this.adminDao.change(admin);
	}

}
