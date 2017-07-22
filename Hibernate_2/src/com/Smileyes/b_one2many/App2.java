package com.Smileyes.b_one2many;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.junit.After;
import org.junit.Test;

/*
 *测试一对多与多对一 
 *一个部门Dept有多个员工Employee
 */
public class App2 {
	private static SessionFactory sf = new Configuration().configure().buildSessionFactory();

	@Test
	// 保存
	public void save() {

		Dept dept = new Dept(1, "人事部");
		Employee emp1 = new Employee(1, " 王夫之");
		Employee emp2 = new Employee(2, " 王阳明");
		/*
		// 从部门方向进行关系维护
		//Hibernate: insert into Employee (empName, deptId, empIt) values (?, ?, ?)
		//Hibernate: insert into Employee (empName, deptId, empIt) values (?, ?, ?)
		//Hibernate: insert into Dept (deptName, deptIt) values (?, ?)
		//Hibernate: update Employee set deptId=? where empIt=?
		//Hibernate: update Employee set deptId=? where empIt=?
			
		Set<Employee> set = new HashSet<Employee>();
		set.add(emp1);
		set.add(emp2);
		dept.setEmps(set);
		Session session = sf.openSession();
		session.save(emp1);
		session.save(emp2);
		session.save(dept);*/
		
		// 从员工方向进行维护:从多的方向进行维护，可以省去update语句，从而提高效率
		//Hibernate: insert into Dept (deptName, deptIt) values (?, ?)
		//Hibernate: insert into Employee (empName, deptId, empIt) values (?, ?, ?)
		//Hibernate: insert into Employee (empName, deptId, empIt) values (?, ?, ?)
		emp1.setDept(dept);
		emp2.setDept(dept);
		Session session = sf.openSession();
		/*session.save(dept); 采用级联保存、更新，这段代码可不写*/
		session.save(emp1);
		session.save(emp2);
		session.beginTransaction().commit();
		session.close();
	}

	@After
	// 获取
	public void get() {
		Session session = sf.openSession();
		Dept dept = session.get(Dept.class, 1);
		System.out.println(dept.getName());
		System.out.println(dept.getEmps());
	}
}
