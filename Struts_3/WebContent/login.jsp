<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel='icon'
	href='${pageContext.servletContext.contextPath}/head.ico'
	type=‘image/x-ico’ />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:text name="title" /></title>
</head>
<body>
	<s:text name="userName" />
	:
	<input type="text">
	<br>
	<s:text name="userPwd" />
	:
	<input type="password">
	<br>
	<input type="submit" value="<s:text name='login'/> ">
</body>
</html>