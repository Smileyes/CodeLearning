package com.Smileyes.action;

import java.util.List;

import com.Smileyes.entity.Employee;
import com.Smileyes.service.EmployeeService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;

public class EmployeeAction extends ActionSupport implements ModelDriven<Employee> {
	public EmployeeService service = new EmployeeService();
	private Employee employee = new Employee();

	// 模型驱动
	public Employee getModel() {
		return employee;
	}

	// 添加
	public String add() throws Exception {
		service.add(employee);
		return list();
	}

	/*
	 * 显示员工列表
	 */
	public String list() throws Exception {
		List<Employee> list = service.getAll();
		ActionContext.getContext().getContextMap().put("list", list);
		return "list";
	}

	/*
	 * 查询员工信息
	 */
	public String viewUpdate() throws Exception {
		employee = service.findByID(employee.getId());
		// 数据回显技术
		ValueStack vs = ActionContext.getContext().getValueStack();
		vs.pop();
		vs.push(employee);
		return "viewUpdate";
	}

	public String update() throws Exception {
		service.update(employee);
		return "success";
	}
}
