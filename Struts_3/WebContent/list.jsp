<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户列表</title>
</head>
<body>
	<table align="center">
		<thead>
			<tr>
				<td>编号</td>
				<td>名称</td>
				<td>奇偶性</td>
			</tr>
		</thead>
		<!-- List的迭代 -->
		<s:iterator var="user" value="#attr.list" status="sta">
			<tr>
				<td><s:property value="#user.id" /></td>
				<td><s:property value="#user.name" /></td>
				<td align="center"><s:property value="#sta.even?'偶':'奇'" /></td>
			</tr>
		</s:iterator>

		<tr>
			<!-- Map的迭代 -->
			<s:iterator var="user" value="#attr.map" status="sta">
				<tr>
					<td><s:property value="#user.key" /></td>
					<td><s:property value="#user.value.name" /></td>
					<td align="center"><s:property value="#sta.even?'偶':'奇'" /></td>
				</tr>
			</s:iterator>
		</tr>
	</table>
</body>
</html>