package com.Smileyes.b_config;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

public class BaseAction implements RequestAware, SessionAware, ApplicationAware {
	private Map<String, Object> request;
	private Map<String, Object> session;
	private Map<String, Object> application;

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public Map<String, Object> getRequest() {
		return request;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public Map<String, Object> getApplication() {
		return application;
	}

	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

	public void setApplication(Map<String, Object> application) {
		this.application = application;
	}

}
