package com.Smileyes.action;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.Smileyes.entity.Admin;
import com.Smileyes.service.IAdminService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AdminAction extends ActionSupport
		implements ModelDriven<Admin>, RequestAware, SessionAware {
	private Map<String, Object> session;
	private Map<String, Object> request;
	private Admin admin = new Admin();
	private IAdminService adminService;

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public void setAdminService(IAdminService adminService) {
		this.adminService = adminService;
	}

	public String login() {
		admin = this.adminService.login(admin);
		if (admin != null) {
			this.adminService.changeStatus(admin);
			session.put("loginInfo", admin);
			return "goToList";
		}
		return "loginFailed";
	}

	public String exit() {
		this.adminService.changeStatus(admin);
		session.clear();
		return "login";
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

	public Admin getModel() {
		return admin;
	}

}
