package com.baidu.Servlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.baidu.dao.ProductDao;
import com.baidu.entity.Product;

public class DetailServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		Cookie[] cookie = request.getCookies();
		String id = request.getParameter("id");
		ProductDao dao = new ProductDao();
		Product p = dao.findById(id);
		Cookie pCookie = null;
		if (cookie != null) {
			for (Cookie ck : cookie) {
				if ("id".equals(ck.getName())) {
					String cV= ck.getValue();
					ck.setValue(setCookieValue(cV, id));
					pCookie = ck;
				}
			}
		} else {
			pCookie = new Cookie("id", id);
		}
		response.addCookie(pCookie);
		String html = "";
		html += "<!DOCTYPE html>";
		html += "<html>";
		html += "<head>";
		html += "   <title>商品详情</title>";
		html += "  <meta charset='utf-8' type='text/html'>";
		html += "</head>";
		html += "<body>";
		html += "<h1 align='center'/><font color='#024AFF'>商品详情</font>";
		html += "<table align='center' border='1' border-collapse='collapse'>";
		html += "<tr>";
		html += "<td>编号</td>";
		html += "<td>商品名称</td>";
		html += "<td>型号</td>";
		html += "<td>价格</td>";
		html += "</tr>";
		html += "<tr>";
		html += "<td>" + p.id + "</td>";
		html += "<td>" + p.name + "</td>";
		html += "<td>" + p.type + "</td>";
		html += "<td>" + p.price + "</td>";
		html += "</tr>";
		html += "</table>";
		html += "<div><a href='list'>返回首页</div>";
		html += "</body>";
		html += "</html>";
		response.getWriter().write(html);
	}

	private String setCookieValue(String cv, String id) {
		String [] cValue=cv.split(",");
		List<String> cookList = Arrays.<String> asList(cValue);
		LinkedList ckList = new LinkedList(cookList);
		if (ckList.contains(id)) {
			ckList.remove(id);
			ckList.addFirst(id);
		} else if (ckList.size() >= 3) {
			ckList.removeFirst();
			ckList.addFirst(id);
		} else {
			ckList.addFirst(id);
		}
		Object[] ids = ckList.toArray();
		String values = "";
		for (Object value : ids) {
			values += (String) value + ",";
		}
		System.out.println(values);
		return values;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
