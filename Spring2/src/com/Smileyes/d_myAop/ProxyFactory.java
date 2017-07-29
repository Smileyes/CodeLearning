package com.Smileyes.d_myAop;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/*
 * 实现子类代理(Cglib代理)的工厂类
 * 
 * @author Smileyes
 *
 */
public class ProxyFactory implements MethodInterceptor {
	private Object target;
	private Aop aop;

	public ProxyFactory(Object target, Aop aop) {
		this.target = target;
		this.aop = aop;
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
		aop.begin();
		Object returnValue = method.invoke(target, args);
		aop.end();
		return returnValue;
	}

}
