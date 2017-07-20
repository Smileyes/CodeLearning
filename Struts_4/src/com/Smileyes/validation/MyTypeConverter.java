package com.Smileyes.validation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

/*
 *自定义日期格式转换器 
 */
public class MyTypeConverter extends StrutsTypeConverter {
	/*
	 * 将String转换成Date格式
	 * 
	 */
	private SimpleDateFormat[] sdfs = { new SimpleDateFormat("yyyy-MM-dd"),
			new SimpleDateFormat("yyyyMMdd"), new SimpleDateFormat("yyyy年MM月dd"),
			new SimpleDateFormat("yyyy.MM.dd") };

	public Object convertFromString(Map context, String[] values, Class toClass) {
		if (values == null || values.length == 0 || Date.class != toClass) {
			return null;
		}
		for (SimpleDateFormat sdf : sdfs) {
			try {
				return sdf.parse(values[0]);
			} catch (ParseException e) {
				continue;
			}
		}
		return null;
	}

	public String convertToString(Map context, Object o) {
		if (o == null) {
			return null;
		}
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(o);
	}

}
