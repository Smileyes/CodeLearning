package test;

import java.lang.reflect.*;

public class GetField {

	public static void main(String[] args) {
		// 获得类类型
		Class clazz = null;
		try {
			clazz = Class.forName("test.People");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		// 获得构造方法
		Constructor c = null;
		try {
			c = clazz.getConstructor(int.class);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		// 新建对象
		People p = null;
		try {
			p = (People) c.newInstance(15);
			System.out.println(p);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		// 获取成员变量
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			System.out.println(field);
		}
		Field f = null;
		try {
			f = clazz.getField("name");
			f.set(p, "小绿");
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		System.out.println(p);
	}

}
