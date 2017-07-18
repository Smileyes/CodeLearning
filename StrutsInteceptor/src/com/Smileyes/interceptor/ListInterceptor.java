package com.Smileyes.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class ListInterceptor extends AbstractInterceptor {

	/*
	 * 当用户访Action的list方法时，查询用户是否已经登录（session） 登录 ：继续执行 没登录：跳转到登录页面
	 */
	public String intercept(ActionInvocation invocation) throws Exception {
		ActionProxy proxy = invocation.getProxy();
		String methodName = proxy.getMethod();
		if ("list".equals(methodName)) {
			Map<String, Object> session = ActionContext.getContext().getSession();
			Object obj = session.get("login");
			if (obj == null) {
				return "failed";
			} else {
				return invocation.invoke();
			}
		} else {
			return invocation.invoke();
		}
	}

}
