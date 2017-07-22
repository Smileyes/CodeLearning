package com.Smileyes.c_many2many;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Test;

/*
 * 多对多：
 * 一个老师教多个学生
 * 一个学生有多个老师 
 */
public class App3 {
	private static SessionFactory sf = new Configuration().configure().buildSessionFactory();

	@Test
	public void save() {
		Teacher teacher1 = new Teacher("鬼谷子");//1、2、3
		Teacher teacher2 = new Teacher("孔子");//1、2、4

		Student student1 = new Student("苏秦");
		Student student2 = new Student("张仪");
		Student student3 = new Student("孙膑");
		Student student4 = new Student("颜渊");

		Set<Student> students1 = new HashSet<Student>();
		students1.add(student1);
		students1.add(student2);
		students1.add(student3);
		Set<Student> students2 = new HashSet<Student>();
		students2.add(student1);
		students2.add(student2);
		students2.add(student4);

		teacher1.setStudents(students1);
		teacher2.setStudents(students2);

		Session session = sf.openSession();
		session.save(teacher1);
		session.save(teacher2);
		session.beginTransaction().commit();
		session.close();

	}

	@After
	public void get() {
		Teacher teacher = sf.openSession().get(Teacher.class, 2);
		System.out.println(teacher.getT_name());
		System.out.println(teacher.getStudents());

	}
}
