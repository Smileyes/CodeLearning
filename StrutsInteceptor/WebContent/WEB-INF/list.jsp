<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.Smileyes.entity.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户列表</title>
</head>
<body>
	<table style="margin: 0 auto">
		<thead>
			<tr align="center">
				<td>编号</td>
				<td>用户名</td>
				<td>密码</td>
			</tr>
		</thead>
		<c:forEach items="${list}" var="user" varStatus="varSta">
			<tr align="center">
				<td>${varSta.count}</td>
				<td>${user.userName}</td>
				<td>${user.userPwd}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>