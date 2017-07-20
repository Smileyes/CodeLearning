<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>列表</title>
</head>
<body>
	<div align="center" style="">员工列表</div>
	<table align="center">
		<thead>
			<tr>
				<td>编号</td>
				<td>名称</td>
				<td>性别</td>
				<td>入职时间</td>
				<td>操作</td>
			</tr>
		</thead>
		<s:iterator var="emp" value="#request.list" status="sta">
			<tr>
				<td><s:property value="#sta.count" /></td>
				<td><s:property value="#emp.name" /></td>
				<td><s:property value="%{#emp.gender==1?'男':'女'}" /></td>
				<td><s:property value="#emp.workDate" /></td>
				<td><s:a value="emp_viewUpdate" method="post">
						<s:param name="id" value="#emp.id"></s:param>
				修改</s:a></td>
			</tr>

		</s:iterator>
	</table>
</body>
</html>