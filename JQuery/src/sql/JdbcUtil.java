package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * 采用传统的方式获取连接
 * 
 * @author Smileyes
 *
 */
public class JdbcUtil {
	private static String driver = "com.mysql.jdbc.Driver";
	private static String name = "Smileyes";
	private static String password = "123456";
	private static String url = "jdbc:mysql://127.0.0.1:3306/study?useUnicode=true&characterEncoding=utf8&useSSL=false";
	static {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/*
	 * 获取连接
	 */
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, name, password);
	}
	/*
	 * 关闭连接
	 */

	public static void closeConnection(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}

	/*
	 * 关闭数据
	 */
	public static void closeStatement(Statement statement) {
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}

	}

	/*
	 * 关闭结果集
	 */
	public static void closeResultSet(ResultSet resultSet) {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}

	}
}
