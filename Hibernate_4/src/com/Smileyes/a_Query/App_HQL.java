package com.Smileyes.a_Query;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.junit.Test;

public class App_HQL {

	private static SessionFactory sf;
	static {
		sf = new Configuration().configure().addClass(Dept.class).addClass(Employee.class)
				.buildSessionFactory();
	}

	/*
	 * 数据查询
	 */
	
	public void get() {
		Session session = sf.openSession();

		// 1.主键查询
		/*
		 * Employee emp1 = session.get(Employee.class, 1);// 及时加载
		 * System.out.println("----------分界线----------"); System.out.println(emp1);
		 */
		/*
		 * Employee emp2 = session.load(Employee.class, 1);// 懒加载
		 * System.out.println("----------分界线----------"); System.out.println(emp2);
		 */

		/*
		 * HQL查询
		 */

		// 2.查询全部
		/*
		 * Query query = session.createQuery("from Employee");
		 * System.out.println(query.list());
		 */

		// 3.指定查询的列
		/*
		 * // Query query = session.createQuery("select name from Employee"); //Query
		 * query = session.createQuery("select name,dept from Employee"); Query query =
		 * session.createQuery("select e.name,e.dept from Employee"); List list =
		 * query.list(); System.out.println(query.list());
		 */

		// 4.条件查询
		/*
		 * Query query = session.createQuery("from Employee where id>?");//占位符
		 * query.setParameter(0, 1);//从0开始 query.setString(0, "1");//已废除
		 * System.out.println(query.list());
		 */

		/*
		 * Query query =
		 * session.createQuery("from Employee where id between :min and :max");// 命名参数
		 * query.setParameter("min", 2); query.setParameter("max", 5);
		 * System.out.println(query.list());
		 */

		// 5模糊查询
		/*
		 * Query query = session.createQuery("from Employee where name like ?");
		 * query.setParameter(0,"%王%"); System.out.println(query.list());
		 */

		/*
		 * // 6.聚合函数查询 Query query =
		 * session.createQuery("select count(*) from Employee");//统计总记录 Query query =
		 * session.createQuery("select count(1) from Employee");//统计总记录，效率更高 Query query
		 * = session.createQuery("select count(name) from Employee");//
		 * 查询id字段，忽略null值，效率比第一种要高 Long num = (Long) query.uniqueResult();// 记录的条数
		 * System.out.println(num);
		 */
		// 7.分组查询
		/*
		 * Query query =
		 * session.createQuery("select dept,count(*) from Employee e  group by e.dept");
		 * List list =
		 * query.list();//获得的结果为List<Object[]>类型的集合：Object[0]为Dept类型，Object[1]为Long类型。
		 * System.out.println(list);
		 */

		// 8.内连接查询
		/*
		 * Query query = session.createQuery("from Employee e  inner join e.dept"); List
		 * list =
		 * query.list();//获得的结果为List<Object[]>类型的集合：Object[0]为Employee类型，Object[1]
		 * 为Dept类型
		 */

		// 9.迫切内连接：把右边的数据存入左边fetch
		Query query = session.createQuery("from Employee e  inner join fetch e.dept");
		List list = query.list();// 获得的结果为List<Object[]>类型的集合：Object[0]为Employee类型，Object[1]为Dept类型
		System.out.println(list);

	}
	/*
	 *HQL优化，将SQL语句写在配置文件*.hbm.mxl中 
	 */
	@Test
	public void getAll() {
		Session session = sf.openSession();
		Query query = session.getNamedQuery("getAllQuery");
		query.setParameter(0, 1);
		List list = query.list();
		System.out.println(list);
	}

	/*
	 * 一对多保存
	 */
	public void save() {
		Session session = sf.openSession();
		Employee emp1 = new Employee();
		emp1.setName("张三");
		Dept dept1 = new Dept();
		dept1.setName("人事部");
		emp1.setDept(dept1);

		Employee emp2 = new Employee();
		emp2.setName("李四");
		Dept dept2 = new Dept();
		dept2.setName("后勤部");
		emp2.setDept(dept2);

		session.save(emp1);
		session.save(emp2);
		session.beginTransaction().commit();
		session.close();
	}
}
