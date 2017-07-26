package com.Smileyes.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.Smileyes.entity.Dept;
import com.Smileyes.entity.Employee;
import com.Smileyes.service.DeptService;
import com.Smileyes.service.EmployeeService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * @author Smileyes
 *
 */
public class LoginAction extends ActionSupport implements ModelDriven<Employee> {
	private DeptService deptService = new DeptService();
	private EmployeeService service = new EmployeeService();
	private Employee employee = new Employee();

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String login() {
		boolean noLogin = true;// noLoign为true，表示无法登录
		if (employee.getId() != 0) {
			noLogin = false;
		} else {
			employee = this.service.find(employee);
			if (employee != null) {
				noLogin = false;
			}
		}
		if (noLogin) {
			return "error";
		} else {
			Map<String, Object> request = ServletActionContext.getContext().getContextMap();
			request.put("list", this.service.getAll());// 保存列表
			Map<String, Object> session = ServletActionContext.getContext().getSession();
			if (!session.containsKey("loginInfo")) {
				session.put("loginInfo", employee.getId());
			} else {
				session.replace("loginInfo", employee.getId());
			}
			return "list";
		}
	}

	public String register() {
		Dept dept = this.deptService.findById(employee.getDept().getId());
		employee.setDept(dept);
		this.service.add(employee);
		return this.login();
	}

	public String viewUpdate() {
		employee = this.service.findById(employee.getId());
		System.out.println(
				employee.getId() + "-" + employee.getName() + "-" + employee.getDept().getName());
		ValueStack vs = ActionContext.getContext().getValueStack();
		vs.pop();
		vs.push(employee);
		List<Dept> deptList = this.deptService.getAll();
		Map<String, Object> request = ServletActionContext.getContext().getContextMap();
		request.put("deptList", deptList);
		return "detail";
	}

	public String update() {
		Employee oldEmp = this.service.findById(employee.getId());// 旧的对象,这里用到了Hibernate的一级缓存
		oldEmp.setName(employee.getName());// 修改用户密码
		int oldDeptId = oldEmp.getDept().getId();// 旧部门id
		int deptId = employee.getDept().getId();// 新部门id
		if (oldDeptId != deptId) {// 部门发生变化
			Dept dept = this.deptService.findById(deptId);// 找到新部门
			oldEmp.setDept(dept);// 设置为新部门
		}
		employee = oldEmp;
		return this.login();
	}

	/*
	 * 注册之前
	 */
	public String beforeSign() {
		List<Dept> deptList = this.deptService.getAll();
		Map<String, Object> request = ServletActionContext.getContext().getContextMap();
		request.put("deptList", deptList);
		return "register";
	}

	public String remove() {
		Map<String, Object> session = ServletActionContext.getContext().getSession();
		Map<String, Object> request = ServletActionContext.getContext().getContextMap();
		Integer id = (Integer) session.get("loginInfo");
		if (employee.getId() != id) {
			this.service.remove(employee.getId());

			request.put("deadInfo", "删除成功！！！");
		} else {
			request.put("deadInfo", "请不要自杀！！！");
		}
		employee = this.service.findById(id);
		return login();
	}

	/*
	 * 模型驱动
	 */
	public Employee getModel() {
		return employee;
	}
}
