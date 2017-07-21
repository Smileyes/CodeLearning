package com.Smileyes.a_first;

import java.util.Date;

import org.junit.Test;

import com.Smileyes.a_first.entity.Employee;
import com.Smileyes.a_first.service.EmployeeService;

public class FirstHib {
	private EmployeeService service = new EmployeeService();

	@Test
	public void testCRUD() {
		Employee emp = new Employee(5, "小孩", 0, new Date());
		/*
		 * this.service.update(emp); // 修改 
		 * //update employee set name=?, gender=?,workDate=? where id=?
		 */
		
		/* this.service.add(emp);// 添加
		 * //insert into employee (name, gender, workDate) values (?, ?, ?)
		 */

		/*
		 * Employee emp2 = new Employee(7, "小二", 0, new Date());
		 * this.service.remove(emp2);//删除
		 *  //delete from employee where id=?
		 */

		/*
		 * System.out.println(this.service.findById(3)); //查询
		 * select employee0_.id as
		 * id1_0_0_, employee0_.name as name2_0_0_, employee0_.gender as
		 * gender3_0_0_,employee0_.workDate as workDate4_0_0_ from employee employee0_
		 * where employee0_.id=?
		 */
		System.out.println(this.service.getAll());

	}
}
