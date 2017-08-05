package code;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CodeAction extends ActionSupport {

	public String execute() throws Exception {
		Map<String, Object> session = ActionContext.getContext().getSession();
		String trueCode = (String) session.get("CHECKNUM");
		HttpServletRequest request = ServletActionContext.getRequest();
		String code = request.getParameter("CHECKNUM");
		String result = "image/Error.gif";
		if (trueCode.equals(code)) {
			result = "image/Right.gif";
		}
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter pt = response.getWriter();
		pt.write(result);
		pt.flush();
		pt.close();
		return null;
	}

}
