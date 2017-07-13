/*
 *Ŀ�ģ�ʵ�ֶ�̬����
 *ʹ�÷�������CMD����
 */

package test;

import java.io.*;
import java.lang.reflect.*;

public class DynamicLoader {

	public static void main(String[] args) {
		InputStreamReader classReader = new InputStreamReader(System.in);
		String s = "test.People";
		try {
			Class clazz = Class.forName(s);
			Constructor c = clazz.getConstructor(int.class, String.class);
			Human h = (Human) c.newInstance(13, "����");
			System.out.println(h);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

	}
}
