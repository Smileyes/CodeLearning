package com.Smileyes.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/*
 *检查登录状态 
 */
public class LoginInterceptor extends AbstractInterceptor {

	public String intercept(ActionInvocation invocation) throws Exception {
		ActionProxy proxy = invocation.getProxy();
		String method = proxy.getMethod();
		if ("beforeLogin".equals(method) || "register".equals(method))
			return null;
		return null;
	}

}
