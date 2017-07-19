package com.Smileyes.ognl;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

import ognl.OgnlContext;

/*
 *ValueStack值栈对象 
 */
public class ActionDemo2 extends ActionSupport {
	private User user = new User(200, "Kitty");

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String test() throws Exception {
		// 1：通过request获得属性struts.valueStack
		HttpServletRequest request = ServletActionContext.getRequest();
		Object vs1 = request.getAttribute("struts.valueStack");
		// 2.通过AvtionContext对象获得
		ActionContext ac = ActionContext.getContext();
		ValueStack vs2 = ac.getValueStack();
		System.out.println(vs1 == vs2);
		// true 两种方式获得的ValueStack对象是相同的
		return SUCCESS;
	}

	@Override
	public String execute() throws Exception {
		// 获得ActionContext
		ActionContext ac = ActionContext.getContext();
		// 存入数据
		ac.put("Test", "Test");// Test=Test
		// 在context中为key=vlaue，例如，request_data=request_data
		ac.getContextMap().put("Request_data", "Request_data");

		// 以下5中存储皆为key={key=vlaue},例如:request={Request_data2=Request_data2,...}
		ac.getSession().put("Session_data", "Session_data");
		ac.getApplication().put("Application_data", "Application_data");

		// 另一种存储方式
		Map<String, Object> request = (Map<String, Object>) ac.get("request");
		request.put("Request_data2", "Request_data2");
		Map<String, Object> session = (Map<String, Object>) ac.get("session");
		session.put("Session_data2", "Session_data2");
		Map<String, Object> application = (Map<String, Object>) ac.get("application");
		application.put("Application_data2", "Application_data2");

		// 获得值栈对象
		ValueStack vs = ac.getValueStack();
		vs.getRoot().push(user);// 放入栈顶
		vs.set("user", new User(2, "Jerry"));// 以Map的方式存储
		return SUCCESS;
	}

}
