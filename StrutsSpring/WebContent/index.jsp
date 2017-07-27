<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.Smileyes.entity.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<link href="head.ico" type="image/x-icon">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>访问成功</title>
</head>
<body>
	恭喜，Struts与Spring整合成功！！！
	<br>id：
	<s:property value="#request.user.id" />
	<br>名称：
	<s:property value="#request.user.name" />
</body>
</html>