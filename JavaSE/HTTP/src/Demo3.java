import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Demo3 extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		/* response.sendError(404); */
		/* response.sendError(500); */
		/*response.sendError(404, "出错！！！");*/
		response.setHeader("Server", "ABC");
		//重定向1：
		/*response.setStatus(302);
		ponse.setHeader("Location", "ad.html");*/
		//重定向2：
		response.sendRedirect("ad.html");
	}
}
