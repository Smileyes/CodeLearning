package Session;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Session1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		List<People> list = new ArrayList<People>();
		for (int i = 1; i < 6; i++) {
			list.add(new People(i, "Student" + i));
		}
		session.setAttribute("name", list);
		/*
		 * session.setMaxInactiveInterval(5); //设置Session有效时间
		 */
		Cookie cookie = new Cookie("JSESSIONID", session.getId());
		cookie.setMaxAge(30);
		response.addCookie(cookie);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
