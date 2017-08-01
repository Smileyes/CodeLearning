package com.Smileyes.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.sql.Update;

import com.Smileyes.entity.Dept;
import com.Smileyes.entity.Employee;
import com.Smileyes.service.IDeptService;
import com.Smileyes.service.IEmployeeService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;

public class EmployeeAction extends ActionSupport
		implements ModelDriven<Employee>, RequestAware, SessionAware {
	private IEmployeeService employeeService;
	private Employee employee = new Employee();
	private IDeptService deptService;
	private Map<String, Object> request;
	private Map<String, Object> session;

	public void setEmployeeService(IEmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public void setDeptService(IDeptService deptService) {
		this.deptService = deptService;
	}

	/*
	 * 模型驱动
	 */
	public Employee getModel() {
		return employee;
	}

	/*
	 * 显示员工列表
	 */
	public String list() {
		if (employeeService != null) {
			List<Employee> list = employeeService.list();
			if (list == null || list.size() == 0) {
				list = null;
			}
			request.put("empList", list);
		}
		return "list";
	}

	/*
	 * 添加员工信息前
	 */
	public String viewAdd() {
		/*
		 * 获取部门信息
		 */
		request.put("deptList", deptService.getAll());
		return "add";
	}

	/*
	 * 添加员工信息
	 */
	public String add() {
		Dept dept = deptService.findById(employee.getDept().getId());
		employee.setDept(dept);
		employeeService.add(employee);
		return "goToList";
	}

	/*
	 * 修改员工信息前
	 */
	public String viewUpdate() {
		request.put("deptList", deptService.getAll());
		employee = employeeService.find(employee.getId());
		ValueStack vs = ActionContext.getContext().getValueStack();
		vs.pop();
		vs.push(employee);
		return "edit";
	}

	/*
	 * 修改员工信息
	 */
	public String update() {
		Dept dept = deptService.findById(employee.getDept().getId());
		employee.setDept(dept);
		this.employeeService.update(employee);
		return "goToList";
	}

	/*
	 * 删除员工信息
	 */
	public String delete() {
		this.employeeService.delete(employee.getId());
		return "goToList";
	}

	/*
	 * 查找员工
	 */
	public String search() {
		String name = employee.getName();
		List<Employee> list = employeeService.findByName(name);
		if (list == null || list.size() == 0) {
			list = null;
		}
		request.put("empList", list);
		request.put("searchInfo", name);
		return "list";
	}

	/*
	 * 查看详情
	 */
	public String detail() {
		employee = employeeService.find(employee.getId());
		ValueStack vs = ActionContext.getContext().getValueStack();
		vs.pop();
		vs.push(employee);
		return "detail";
	}

	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;

	}
}
