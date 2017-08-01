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
<title>修改员工信息</title>
</head>
<body>

	<form action="emp_update" method="post">
		<s:hidden name="id"></s:hidden>
		<table>
			<tr>
				<td>姓名</td>
				<td><s:textfield name="name" theme="simple" /></td>
			</tr>
			<tr>
				<td>薪水</td>
				<td><s:textfield name="salary" theme="simple" /></td>
			</tr>
			<tr>
				<td>部门</td>
				<td><s:select list="#request.deptList" headerKey="-1"
						headerValue="请选择部门" listKey="id" listValue="name" name="dept.id"
						theme="simple" value="dept.id"></s:select></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="修改"><input
					type="button" onclick="javascript:history.back(-1)" value="返回"
					style="margin-left: 50"></td>
			</tr>
		</table>
	</form>
</body>
</html>