package sql;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aj.org.objectweb.asm.Type;

/**
 * 计算税务
 */
public class TaxServlet extends HttpServlet {

	private CallableStatement cstmt;
	private Connection conn;

	/*
	 * 存储过程
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String salary = request.getParameter("salary");
		try {
			conn = JdbcUtil.getConnection();
			String sql = "call pro_taxCal(?,?)";
			cstmt = conn.prepareCall(sql);
			cstmt.setDouble(1, Double.parseDouble(salary));
			cstmt.registerOutParameter(2, Type.DOUBLE);
			cstmt.execute();
			double num = cstmt.getDouble(2);
			PrintWriter pt = response.getWriter();
			pt.write(num + "元");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.closeStatement(cstmt);
			JdbcUtil.closeConnection(conn);
		}

	}

	/*
	 * 存储函数
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String salary = request.getParameter("salary");
		try {
			conn = JdbcUtil.getConnection();
			String sql = "{?=call fun_taxCal(?)}";
			cstmt = conn.prepareCall(sql);
			cstmt.registerOutParameter(1, Type.DOUBLE);
			cstmt.setDouble(2, Double.parseDouble(salary));
			cstmt.execute();
			double num = cstmt.getDouble(1);
			PrintWriter pt = response.getWriter();
			pt.write(num + "元");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.closeStatement(cstmt);
			JdbcUtil.closeConnection(conn);
		}

	}

}
