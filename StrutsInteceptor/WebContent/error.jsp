<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录出错</title>
</head>
<body>
	用户名与密码不匹配，请重新
	<a href="${pageContext.servletContext.contextPath }/login.jsp">登录</a>
	，或尝试
	<a href="#">找回密码</a>。
</body>
</html>