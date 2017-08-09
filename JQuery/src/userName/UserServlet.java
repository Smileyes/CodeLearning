package userName;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Driver;

/**
 * Servlet implementation class UserServlet
 */
public class UserServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = request.getParameter("userName");
		System.out.println(userName);
		String result = "用户名可以注册";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1:3306/study";
			String user = "Smileyes";
			String password = "123456";
			Connection connection = DriverManager.getConnection(url, user, password);
			String sql = "select userName from user where userName=?";
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setString(1, userName.trim());
			ResultSet resultSet = prepareStatement.executeQuery();
			if (resultSet.next()) {
				result = "用户名已存在";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pt = response.getWriter();
		pt.write(result);
		pt.flush();
		pt.close();
	}

	/*
	 * POST
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = request.getParameter("userName");
		System.out.println(userName);
		String result = "用户名可以注册";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1:3306/study";
			String user = "Smileyes";
			String password = "123456";
			Connection connection = DriverManager.getConnection(url, user, password);
			String sql = "select userName from user where userName=?";
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setString(1, userName.trim());
			ResultSet resultSet = prepareStatement.executeQuery();
			if (resultSet.next()) {
				result = "用户名已存在";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(result);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pt = response.getWriter();
		pt.write(result);
		pt.flush();
		pt.close();
	}

}
