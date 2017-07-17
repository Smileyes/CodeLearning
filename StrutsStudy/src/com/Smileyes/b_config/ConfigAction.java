package com.Smileyes.b_config;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

/*
 *设置、获取域对象的三种方式 
 */
public class ConfigAction extends BaseAction implements Action {

	public String execute() throws Exception {
		// 方式1:使用ServletActionContext类

		/*
		 * HttpServletRequest request = ServletActionContext.getRequest(); HttpSession
		 * session = request.getSession(); ServletContext application =
		 * ServletActionContext.getServletContext(); request.setAttribute("value",
		 * "RUQUEST"); session.setAttribute("value", "SESSION");
		 * application.setAttribute("value", "APPLICATION");
		 */

		// 方法二：使用ActionContext类
		/*
		 * ActionContext ac = ActionContext.getContext(); Map<String, Object> request2 =
		 * (Map<String, Object>) ac.get("request"); Map<String, Object> session2 =
		 * (Map<String, Object>) ac.get("session"); Map<String, Object> application2 =
		 * (Map<String, Object>) ac.get("application"); request2.put("value",
		 * "REQUEST"); session2.put("value", "SESSION"); application2.put("value",
		 * "APPLICATION");
		 */

		// 或者

		ActionContext ac = ActionContext.getContext();

		Map<String, Object> request3 = ac.getContextMap();
		Map<String, Object> session3 = ac.getSession();
		Map<String, Object> application3 = ac.getApplication();
		request3.put("value", "REQUEST");
		session3.put("value", "SESSION");
		application3.put("value", "APPLICATION");
		return Action.SUCCESS;
	}
//方法3：实现RequestAware、SessionAware、ApplicationAware接口
	public String execute2() throws Exception {
		this.getRequest().put("value", "REQUEST域对象");
		this.getSession().put("value", "SESSION域对象");
		this.getApplication().put("value", "APPLICATION域对象");
		return Action.SUCCESS;
	}
}
