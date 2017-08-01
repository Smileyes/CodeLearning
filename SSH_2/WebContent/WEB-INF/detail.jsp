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
	width: 26%;
	margin: 0 auto;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改员工信息</title>
</head>
<body>

	<s:hidden name="id"></s:hidden>
	<table>
		<tr>
			<td>编号</td>
			<td><s:property value="id" /></td>
		</tr>
		<tr>
			<td>姓名</td>
			<td><s:property value="name" /></td>
		</tr>
		<tr>
			<td>薪水</td>
			<td><s:property value="salary" /></td>
		</tr>
		<tr>
			<td>部门</td>
			<td><s:property value="dept.name"></s:property></td>
		</tr>
		<tr>
			<td colspan="2"><input type="button"
				onclick="javascript:history.back(-1)" value="返回"></td>
		</tr>
	</table>
</body>
</html>