<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加员工</title>
</head>
<body>
	<s:form method="post" action="/emp_add" theme="simple">
		<!--防止表单重复提交 -->
		<s:token></s:token>
员工姓名：<s:textfield name="name"></s:textfield>
		<s:fielderror fieldName="name"></s:fielderror>
		<br>
员工性别：<s:radio name="gender" list="%{#{'1':'男','0':'女'}}" value="1"></s:radio>
		<br>
入职时间：<s:textfield name="workDate"></s:textfield>
		<s:fielderror fieldName="workDate"></s:fielderror>
		<br>

		<s:submit value="注册"></s:submit>
		<s:reset value="清空" style="margin-left:160px"></s:reset>
	</s:form>
</body>
</html>