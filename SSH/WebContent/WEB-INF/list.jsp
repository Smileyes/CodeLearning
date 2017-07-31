<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style type="text/css">
td {
	border-style: solid;
	border-collapse: collapse
}
</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工列表</title>
</head>
<body>
	<s:property value="#request.deadInfo" />
	<table align="center"
		style="border-style: dotted; border-collapse: collapse">
		<thead align="center">
			<tr>
				<td>编号</td>
				<td>姓名</td>
				<td>所属部门</td>
				<td>操作</td>
			</tr>
		</thead>
		<s:if test="#request.list!= null">
			<s:iterator var="emp" value="#request.list" status="sta">
				<tr align="center">
					<td><s:property value="#sta.count" /></td>
					<td><s:property value="#emp.name" /></td>
					<td><s:property value="#emp.dept.name" /></td>
					<s:url id="detailUrl" action="emp_viewUpdate">
						<s:param name="id" value="#emp.id"></s:param>
					</s:url>
					<s:url id="deleteUrl" action="emp_remove">
						<s:param name="id" value="#emp.id"></s:param>
					</s:url>
					<s:param name="id" value="#emp.id" />
					<td><s:a href="%{detailUrl}">修改</s:a> <s:a href="%{deleteUrl}">删除</s:a></td>
				</tr>
			</s:iterator>
		</s:if>
		<s:else>
			<tr style="border-style: dotted; border-collapse: collapse">
				<td colspan="4"
					style="border-style: solid; border-collapse: collapse">抱歉，没有员工信息</td>
			</tr>
		</s:else>
	</table>
</body>
</html>