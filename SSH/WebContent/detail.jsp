<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.Smileyes.entity.*"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>详细信息</title>
</head>
<body>
	<s:form action="emp_update" method="post" theme="simple"
		style="margin-left:500px">
		<s:hidden name="id" />
		用户名<s:textfield name="name" />
		<br>
		部&nbsp;&nbsp;门
		<s:select list="#request.deptList" listKey="id" listValue="name"
			headerKey="0" headerValue="请选择" name="dept.id" style="width:175px"></s:select>
		<br>
		<s:submit value="修改" style="margin-left:75px"></s:submit>
		<input type="button" name="Submit"
			onclick="javascript:history.back(-1);" value="返回">
	</s:form>
</body>
</html>