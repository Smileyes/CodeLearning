package com.Smileyes.ognl;

import org.junit.Test;

import com.opensymphony.xwork2.ActionSupport;

import ognl.Ognl;
import ognl.OgnlContext;

public class ActionDemo1 extends ActionSupport {
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Test
	public void test() throws Exception {
		// 获取上下文对象
		OgnlContext context = new OgnlContext();

		// 非根元素
		// 存入数据
		context.put("cn", "China");
		context.put("user", new User(22, "Jack"));
		Object ognl = Ognl.parseExpression("#cn");
		Object value = Ognl.getValue(ognl, context, context.getRoot());
		System.out.println("非根元素：" + value);

		// 根元素
		User xyz = new User(100, "Tom");
		context.setRoot(xyz);
		Object ognl2 = Ognl.parseExpression("name");
		Object value2 = Ognl.getValue(ognl2, context, context.getRoot());
		System.out.println("根元素：" + value2);

		// 调用类的静态方法和属性
		Object ognl3 = Ognl.parseExpression("@Math@floor(10.6)");
		// Object ognl3 = Ognl.parseExpression("@@floor(10.6)");//省略Math
		// Object ognl3 = Ognl.parseExpression("@Math@PI");// 静态属性
		Object value3 = Ognl.getValue(ognl3, context, context.getRoot());
		System.out.println("静态方法：" + value3);
	}

}
