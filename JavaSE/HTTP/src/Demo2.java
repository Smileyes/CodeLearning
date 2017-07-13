/*获得表单参数*/
import java.io.IOException;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Demo2 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		getParameter(request);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		getParameter(request);
	}
	public void getParameter(HttpServletRequest request){

		Enumeration<String> enums=request.getParameterNames();
		while(enums.hasMoreElements()){
			String name = enums.nextElement();
			String []values=request.getParameterValues(name);
			System.out.print(name+":");
			for(String str:values){
				System.out.print(str+" ");
			}
			System.out.println();
		}
	}
}
