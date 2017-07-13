package com.Smileyes.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Smileyes.frame.bean.Action;
import com.Smileyes.frame.bean.ActionManager;
import com.Smileyes.frame.bean.Result;

/**
 * 总响应Servlet 项目唯一的servlet类
 */
public class ActionServlet extends HttpServlet {
	public ActionManager manager = new ActionManager();;

	public void init() throws ServletException {
		// 在启动时，即完成对myStruts.xml的读取
		/**/
		System.out.println("myStruts.xml读取完毕");

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("连接成功");
		// 获得uri
		String uri = request.getRequestURI();
		uri = uri.substring(uri.lastIndexOf("/") + 1, uri.indexOf(".action"));
		// 获得uri对应的Action
		Action action = manager.getAction(uri);
		// 获得Aciton的类名与方法名
		String className = action.getClassName();
		String method = action.getMethod();
		// 新建对象，执行方法
		try {
			Class<?> clazz = Class.forName(className);
			Object obj = clazz.newInstance();
			Method m = clazz.getDeclaredMethod(method, HttpServletRequest.class,
					HttpServletResponse.class);
			String actionFlag = (String) m.invoke(obj, request, response);
			Result result = action.getResults().get(actionFlag);
			String page = result.getPage();
			/*if (result != null && "redirect".equals(result.getType())) {
				String path=request.getServletContext().getContextPath();
				response.sendRedirect(path+page);
			} else {*/
				request.getRequestDispatcher(page).forward(request, response);
			/*}*/
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
