<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<link rel='icon' href='head.ico ' type=‘image/x-ico’ />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
</head>
<body>
	<s:form action="emp_login" method="post" theme="simple"
		style="margin-left:500px">
		用户名<s:textfield name="name" />
		<br>
		密&nbsp;&nbsp;&nbsp;码<s:textfield name="password" />
		<br>
		<s:submit value="登录" style="margin-left: 55px"></s:submit>
		<s:reset value="重置" style="margin-left: 30px"></s:reset>
	</s:form>
	<div style="margin-left: 500px">
		还没有帐号？
		<s:a href="emp_beforeSign">注册</s:a>
	</div>


</body>
</html>