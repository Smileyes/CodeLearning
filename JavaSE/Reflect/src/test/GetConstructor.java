package test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class GetConstructor {

	public static void main(String[] args) {
		Class clazz = null;
		System.out.println("First:");
		try {
			clazz = Class.forName("test.People");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Constructor[] c1 = clazz.getConstructors();
		for (Constructor cs : c1) {
			System.out.println(cs);
		}
		
		/*通过构造方法新建对象*/
		try {
			People p1 = (People)clazz.newInstance();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		}
		
		
		System.out.println("Second:");
		try {
			Constructor c2 = clazz.getDeclaredConstructor(String.class);  //获取指定的私有构造方法
			System.out.println(c2);
			try {
				People p2;
				c2.setAccessible(true);                 			//开放访问权限
				p2 = (People)c2.newInstance("小白");  //选择指定的私有构造方法进行新建对象
				} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}

	}
}
