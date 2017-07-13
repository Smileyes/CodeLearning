/*内省：将对象的属性封装到数据中
 * 方法：用到了PtyDescriptor(对象属性描述器)，从而获得对象的get与set方法。
 */

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class NeiXing {

	public static void main(String[] args) {
		int id = 110;
		String name = "小白";
		Person p = null;
		Class clazz = Person.class;
		try {
			p = (Person) clazz.newInstance();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		}
		// 新建对象属性描述器
		PropertyDescriptor pd = null;
		try {
			pd = new PropertyDescriptor("name", Person.class);
		} catch (IntrospectionException e) {
			e.printStackTrace();
		}
		// 获取“id”的set方法,并设置属性

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
