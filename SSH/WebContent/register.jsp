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
	<s:form action="emp_register" method="post" theme="simple"
		style="margin-left:500px">
		<s:hidden name="employee.id" />
		用户名<s:textfield name="name" />
		<br>
		密&nbsp;&nbsp;&nbsp;码<s:textfield name="password" />
		<br>
		部&nbsp;&nbsp;门
		<s:select list="#request.deptList" listKey="id" listValue="name"
			headerKey="0" 
			name="dept.id" style="width:175px"></s:select>
		<br>
		<s:submit value="注册" style="margin-left:65px"></s:submit>
		<input type="button" name="Submit"
			onclick="javascript:history.back(-1);" value="返回">
	</s:form>
	<div style="margin-left: 500px">
		已经有帐号？
		<s:a href="login.jsp">登录</s:a>
	</div>
</body>
</html>