package com.Smileyes.interceptor;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.Smileyes.utils.HibernateSessionFactory;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/*
 *自定义Session拦截器：
 * 用于获取Hibernate的session和提交变化
 */
public class SessionInterceptor extends AbstractInterceptor {

	public String intercept(ActionInvocation invocation) throws Exception {
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction tr = session.beginTransaction();
			return invocation.invoke();
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		} finally {
			HibernateSessionFactory.getSession().getTransaction().commit();// 提交事务
		}
	}

}
