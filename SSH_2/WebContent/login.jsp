<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.Smileyes.entity.*"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC ""-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<style type="text/css">
td, tr {
	border-style: dotted;
	border-style: solid;
	border-collapse: collapse;
	border-color: blue;
	text-align: center;
}

table {
	border-collapse: collapse;
	border-color: red;
	margin: 0 auto;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员登录</title>
</head>
<body>
	<form action="adm_login" method="post">
		<table>
			<tr>
				<td>用户名</td>
				<td><input type="text" name="name" value=""></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input type="text" name="password" value=""></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="登录"><input
					type="reset" value="清除" style="margin-left: 50"></td>
			</tr>
		</table>
	</form>
	<div style="margin-left: 600px;">
		以<a href="emp_list">游客</a>身份浏览
	</div>
</body>
</html>