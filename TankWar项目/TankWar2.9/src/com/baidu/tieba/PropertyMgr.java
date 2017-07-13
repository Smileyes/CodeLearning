package com.baidu.tieba;

import java.io.IOException;
import java.util.Properties;

public class PropertyMgr {
	private static Properties p = new Properties();
	static {
		try {
			p.load(PropertyMgr.class.getClassLoader().getResourceAsStream(
					"config/tank.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getProperty(String key) {
		return p.getProperty(key);
	}

	private PropertyMgr() {
	};
}
