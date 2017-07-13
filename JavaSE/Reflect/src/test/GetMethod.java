package test;

import java.lang.reflect.*;

public class GetMethod {

	public static void main(String[] args) {
		Class clazz = null;
		try {
			clazz = Class.forName("test.People");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Method[] methods = clazz.getMethods(); // 获取所有public 方法（包括从父类继承的方法）
		for (Method m : methods) {
			System.out.println(m);
		}

		try {
			Method m = clazz.getDeclaredMethod("sleep", null);
			m.setAccessible(true);
			Constructor c = clazz.getConstructor(int.class,String.class);
			People p = (People)c.newInstance(15,"小名");
			m.invoke(p,null);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
	}

}
