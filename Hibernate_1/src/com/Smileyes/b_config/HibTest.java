package com.Smileyes.b_config;

import java.util.EnumSet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.spi.MetadataImplementor;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.schema.TargetType;
import org.junit.Test;

public class HibTest {
	@Test
	public void testDo() {
		// 获得
		Configuration config = new Configuration();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
		SessionFactory sf = config.buildSessionFactory(serviceRegistry);
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();

		User user = new User(1, "张三", 20);
		session.save(user);
		tr.commit();
		session.close();
	}
}
