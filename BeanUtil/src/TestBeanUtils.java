import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

public class TestBeanUtils {

	public static void main(String[] args) {
		String id = "110";
		String name = "Ð¡»Æ";
		String birthday = "1994-08-13";
		Person p = new Person();
		try {
			BeanUtils.setProperty(p, "id", id);
			BeanUtils.setProperty(p, "name", name);
			ConvertUtils.register(new Converter() {
				public Date convert(Class type, Object value) {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					Date d = null;
					try {
						d = sdf.parse((String) value);
					} catch (ParseException e) {
						e.printStackTrace();
					}
					return d;
				}
			}, Date.class);
			BeanUtils.setProperty(p, "birthday", birthday);
			System.out.println(p);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
}