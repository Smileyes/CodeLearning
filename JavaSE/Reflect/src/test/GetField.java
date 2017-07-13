package test;

import java.lang.reflect.*;

public class GetField {

	public static void main(String[] args) {
		// ���������
		Class clazz = null;
		try {
			clazz = Class.forName("test.People");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		// ��ù��췽��
		Constructor c = null;
		try {
			c = clazz.getConstructor(int.class);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		// �½�����
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
		// ��ȡ��Ա����
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			System.out.println(field);
		}
		Field f = null;
		try {
			f = clazz.getField("name");
			f.set(p, "С��");
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
