package com.Smileyes.util;

import org.apache.commons.dbutils.QueryRunner;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcUtil {
	private static ComboPooledDataSource ds = new ComboPooledDataSource();
	private static QueryRunner qr = new QueryRunner(ds);

	public static QueryRunner getQr() {
		return qr;
	}

	public static ComboPooledDataSource getDs() {
		return ds;
	}
}
