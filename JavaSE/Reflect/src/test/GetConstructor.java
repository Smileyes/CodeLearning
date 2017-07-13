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
		
		/*ͨ�����췽���½�����*/
		try {
			People p1 = (People)clazz.newInstance();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		}
		
		
		System.out.println("Second:");
		try {
			Constructor c2 = clazz.getDeclaredConstructor(String.class);  //��ȡָ����˽�й��췽��
			System.out.println(c2);
			try {
				People p2;
				c2.setAccessible(true);                 			//���ŷ���Ȩ��
				p2 = (People)c2.newInstance("С��");  //ѡ��ָ����˽�й��췽�������½�����
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
