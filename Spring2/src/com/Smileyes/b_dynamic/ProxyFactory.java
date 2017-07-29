package com.Smileyes.b_dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

/*
 * 实现动态代理的工厂类
 * 
 * @author Smileyes
 *
 */
@Component
public class ProxyFactory {

	public static Object getProxyInstance(Object target) {
		return Proxy.newProxyInstance(target.getClass().getClassLoader(),
				target.getClass().getInterfaces(), new InvocationHandler() {
					public Object invoke(Object proxy, Method method, Object[] args)
							throws Throwable {
						System.out.println("------开始事务------");
						Object returnValue = method.invoke(target, args);
						System.out.println("------完成事务------");
						return returnValue;
					}

				});
	}

}
