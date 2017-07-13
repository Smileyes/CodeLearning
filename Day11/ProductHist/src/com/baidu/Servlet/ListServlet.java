package com.baidu.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.baidu.dao.ProductDao;
import com.baidu.entity.Product;

public class ListServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String html = "";
		ProductDao dao = new ProductDao();
		html += "<!DOCTYPE html>";
		html += "<html>";
		html += "<head>";
		html += "   <title>商品列表</title>";
		html += "  <meta charset='utf-8' type='text/html'>";
		html += "</head>";
		html += "<body>";
		html += "<h1 align='center'/><font color='#FE0000'>商品列表</font>";
		html += "<table align='center' border='1' border-collapse='collapse'>";
		html += "<tr>";
		html += "<td>编号</td>";
		html += "<td>商品名称</td>";
		html += "<td>型号</td>";
		html += "<td>价格</td>";
		html += "</tr>";
		for (Product p : dao.list) {
			html += "<tr>";
			html += "<td>" + p.id + "</td>";
			html += "<td >" + "<a href='/ProductHist/DetailServlet?id=" + p.id
					+ "'>" + p.name + "</td>";
			html += "<td>" + p.type + "</td>";
			html += "<td>" + p.price + "</td>";
			html += "</tr>";
		}
		html += "</table>";
		html += "<div> 您最近浏览的商品为</div>";
		Cookie[] cookie = request.getCookies();
		if (cookie != null) {
			for (Cookie ck : cookie) {
				if ("id".equals(ck.getName())) {
					String[] products = ck.getValue().split(",");
					for (String pName : products) {
						Product p = dao.findById(pName);
						html += p.toString() + "<br/>";
					}
					response.addCookie(ck);
				}
			}
		}
		html += "</body>";
		html += "</html>";

		response.getWriter().write(html);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
