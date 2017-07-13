import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Demo1 extends HttpServlet {
	private Object String;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		System.out.println("Method:" + request.getMethod() + " URI:"
				+ request.getRequestURI() + " HTTP:" + request.getProtocol());
		Enumeration<String> names = request.getHeaderNames();
		while (names.hasMoreElements()) {
			String name = names.nextElement();
			System.out.println(name + ":" + request.getHeader(name));
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
	/*	doGet(request, response);*/
		InputStream in = request.getInputStream();
		int len = 0;
		byte[] buf = new byte[1024];
		while ((len = in.read(buf)) != -1) {
			String str = new String(buf, 0, len);
			System.out.print(str);
		}
	}
}
