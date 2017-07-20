<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
</head>
<body>
	<s:form action="/user_register" method="post">
		用户名:<s:textfield name="user.name"></s:textfield>
		<s:fielderror fieldName="user.name"></s:fielderror>
		<br>		
		密&nbsp;&nbsp;&nbsp;码:<s:password name="user.password"></s:password>
		<s:fielderror fieldName="user.password"></s:fielderror>
		<br>
		生&nbsp;&nbsp;&nbsp;日:<s:textfield name="user.birth">
			<s:param name="value">
				<s:date name="user.birth" format="yyyy-MM-dd" />
			</s:param>
		</s:textfield> 
		<s:fielderror fieldName="user.birth"></s:fielderror>
		<br>
		邮&nbsp;&nbsp;&nbsp;箱:<s:textfield name="user.email"></s:textfield>
		<s:fielderror fieldName="user.email"></s:fielderror>
		<br>
		<s:submit value="注册"></s:submit>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<s:reset value="重置"></s:reset>
	</s:form>
</body>
</html>