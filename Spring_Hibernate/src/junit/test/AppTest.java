package junit.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.Smileyes.entity.Dept;
import com.Smileyes.entity.Employee;
import com.Smileyes.service.EmployeeService;

/*
 * 测试Spring与Hibernate是否整合成功
 * 
 * @author Smileyes
 *
 */
public class AppTest {
	private ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

	@Test
	public void save() {
		EmployeeService employeeService = (EmployeeService) ac
				.getBean("emoloyeeService");
		Employee employee = new Employee();
		employee.setName("Tom");
		Dept dept = new Dept();
		dept.setName("HR");
		employee.setDept(dept);
		employeeService.save(employee);
	}
}
