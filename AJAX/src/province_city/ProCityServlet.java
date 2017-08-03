package province_city;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ProCityServlet extends HttpServlet {

	public ProCityServlet() throws SQLException {
	}

	/*
	 * 省份:GET
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ComboPooledDataSource ds = new ComboPooledDataSource();
		QueryRunner qr = new QueryRunner(ds);
		String method = request.getParameter("method");
		String sql = "select * from province order by convert(name using gbk) collate gbk_chinese_ci ";
		List<Province> list = null;
		try {
			list = qr.query(sql, new BeanListHandler<Province>(Province.class));
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			ds.close();
		}
		StringBuffer xmlList = new StringBuffer("<root>");
		for (Province p : list) {
			xmlList.append("<province proId='" + p.getId() + "'>");
			xmlList.append(p.getName());
			xmlList.append("</province>");
		}
		xmlList.append("</root>");
		System.out.println(xmlList.toString());
		response.setContentType("text/xml;charset=utf-8");
		PrintWriter pt = response.getWriter();
		pt.write(xmlList.toString());
		pt.flush();
		pt.close();

	}

	/*
	 * 城市：POST
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/xml;charset=utf-8");
		ComboPooledDataSource ds = new ComboPooledDataSource();
		QueryRunner qr = new QueryRunner(ds);
		String proName = request.getParameter("province");
		String sql1 = "select * from province where name=?";
		Province province = null;
		try {
			province = qr.query(sql1, new BeanHandler<Province>(Province.class),
					proName);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		String sql = "select * from city where pro_id=? order by convert(name using gbk) collate gbk_chinese_ci ";
		List<City> list = null;
		try {
			list = qr.query(sql, new BeanListHandler<City>(City.class),
					province.getId());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			ds.close();
		}
		StringBuffer xmlList = new StringBuffer("<province>");
		for (City c : list) {
			xmlList.append("<city>");
			xmlList.append(c.getName());
			xmlList.append("</city>");
		}
		xmlList.append("</province>");
		PrintWriter pt = response.getWriter();
		pt.write(xmlList.toString());
		pt.flush();
		pt.close();
	}

}
