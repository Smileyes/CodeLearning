package com.Smileyes.ognl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/*
 *迭代标签 
 */
public class ActionDemo3 extends ActionSupport {

	public String execute() throws Exception {
		// List对象
		List<User> list = new ArrayList<User>();
		list.add(new User(1, "赵大"));
		list.add(new User(2, "钱二"));
		list.add(new User(3, "孙三"));
		list.add(new User(4, "李四"));
		Map<String, Object> request = ActionContext.getContext().getContextMap();
		request.put("list", list);
		// Map对象
		HashMap<String, User> map = new HashMap<String, User>();
		map.put("5", new User(5, "周五"));
		map.put("6", new User(6, "吴六"));
		map.put("7", new User(7, "郑七"));
		map.put("8", new User(8, "王八"));
		request.put("map", map);
		// map和list都是非根元素
		return "list";

	}

}
