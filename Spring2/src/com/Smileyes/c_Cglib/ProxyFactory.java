package com.Smileyes.c_Cglib;

import java.lang.reflect.Method;

import javax.annotation.Resource;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.stereotype.Component;

/*
 * 实现子类代理(Cglib代理)的工厂类
 * 
 * @author Smileyes
 *
 */
public class ProxyFactory implements MethodInterceptor {
	private Object target;

	public ProxyFactory(Object target) {
		this.target = target;
	}

	public Object getProxyInstance() {
		// 创建工具类
		Enhancer enhancer = new Enhancer();
		// 设置父类
		enhancer.setSuperclass(target.getClass());
		// 设置回滚
		enhancer.setCallback(this);
		// 返回子类
		return enhancer.create();
	}

	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy)
			throws Throwable {
		System.out.println("------开始事务------");
		Object returnValue = method.invoke(target, args);
		System.out.println("------完成事务------");
		return returnValue;
	}

}
