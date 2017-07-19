<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ognl</title>
</head>
<body>
	<s:debug></s:debug>
	根元素：
	<s:property value="user.name" />
	<s:property value="name" />
	<br /> 非根元素：
	<s:property value="#Test" />
	<s:property value="#request.Request_data" />
	<s:property value="#request.Request_data2" />
	&nbsp;&nbsp;&nbsp;
	<!-- 使用attr -->
	<s:property value="#attr.Session_data" />
	<s:property value="#attr.Session_data2" />
	&nbsp;&nbsp;&nbsp;
	<!--获取请求的参数数据-->
	<br> 请求的参数:
	<s:property value="#parameters.name" />
</body>
</html>