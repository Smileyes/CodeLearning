<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
</head>
<body>
	<form
		action="${pageContext.servletContext.contextPath}/register"
		method="post">
		用户名：<input type="text" name="user.name"> <br /> 密&nbsp;&nbsp;&nbsp;码：<input
			type="password" name="user.password">  <br/><input type="submit" value="注册">
	</form>
</body>
</html>