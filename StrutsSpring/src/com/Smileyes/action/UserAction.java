package com.Smileyes.action;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.Smileyes.entity.User;
import com.Smileyes.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller("userAction")
public class UserAction extends ActionSupport {
	@Resource(name = "userService")
	private UserService userService;

	public String execute() throws Exception {
		User user = userService.get();
		Map<String, Object> request = ActionContext
				.getContext().getContextMap();
		request.put("user", user);
		return SUCCESS;
	}

}
