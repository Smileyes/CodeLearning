/*��ʡ������������Է�װ��������
 * �������õ���PtyDescriptor(��������������)���Ӷ���ö����get��set������
 */

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class NeiXing {

	public static void main(String[] args) {
		int id = 110;
		String name = "С��";
		Person p = null;
		Class clazz = Person.class;
		try {
			p = (Person) clazz.newInstance();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		}
		// �½���������������
		PropertyDescriptor pd = null;
		try {
			pd = new PropertyDescriptor("name", Person.class);
		} catch (IntrospectionException e) {
			e.printStackTrace();
		}
		// ��ȡ��id����set����,����������

		try {
			Method m = pd.getWriteMethod();
			m.invoke(p, name);
			System.out.println(pd.getReadMethod().invoke(p,null));
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} 

	}
}
