/*学习Cookie的相关知识*/
package Hist;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieDemo2 extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		GregorianCalendar cal = new GregorianCalendar();
		String newTime = "" + cal.get(GregorianCalendar.YEAR) + "-"
				+ cal.get(GregorianCalendar.MONTH) + "-"
				+ cal.get(GregorianCalendar.DAY_OF_MONTH) + " "
				+ cal.get(GregorianCalendar.HOUR_OF_DAY) + ":"
				+ cal.get(GregorianCalendar.MINUTE) + ":"
				+ cal.get(GregorianCalendar.SECOND);
		Cookie[] cookies = request.getCookies();
		String mgs = null;
		String num;
		if (cookies == null) {
			mgs = "这是你首次登录,登录时间为： " + newTime;
			num = "2";
		} else {
			mgs = "这是你第" + cookies[0].getValue() + "次登录,登录时间为：" + newTime
					+ "\n上次登录时间为：" + cookies[1].getValue();
			num = new String()
					.valueOf((Integer.parseInt(cookies[0].getValue()) + 1));
		}
		Cookie timesCookie = new Cookie("times", num);
		Cookie timeCookie = new Cookie("time", newTime);
		response.addCookie(timesCookie);
		response.addCookie(timeCookie);
		response.getWriter().write(mgs);
	}
}
