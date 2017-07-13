import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Demo4 extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("image/jpeg;charset=utf-8");
		response.setHeader("Content-Disposition",
				"attachment;filename=ClariS.jpg");
		InputStream in = new FileInputStream(new File(
				"F:/WorkSpace/HTTP/WebRoot/images/ClariS.JPG"));
		byte[] buf = new byte[1024];
		int len = 0;
		while ((len = in.read(buf)) != -1) {
			response.getOutputStream().write(buf, 0, len);
		}
	}

}
