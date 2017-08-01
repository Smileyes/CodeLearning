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
	border-color: red;
	text-align: center;
}

table {
	border-collapse: collapse;
	border-color: red;
	width: 80%;
	margin: 0 auto;
}
</style>
<script type="text/javascript">
	var isFirst = true;
	function show() {
		if (isFirst)
			var search = document.getElementById("search");
		search.value = "";
		isFirst = false;
	}
	function add() {
		window.open("emp_viewAdd", "_self");
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工列表</title>
</head>
<body>
	<!--登录部分 -->
	<div align="center">
		<s:if test="#session.loginInfo!=null">
			管理员<s:property value="#session.loginInfo.name" />已登录,<s:a
				href="adm_exit?id=%{#session.loginInfo.id}">退出</s:a>
		</s:if>
		<s:else>
			<a href="login.jsp">请登录</a>
		</s:else>
		<p />
		<!--列表部分 -->
		<table>
			<thead>
				<tr>
					<td>序号</td>
					<td>编号</td>
					<td>姓名</td>
					<td>薪水(&yen;)</td>
					<td>部门</td>
					<td>操作</td>
				</tr>
				<s:if test="%{#request.empList != null}">
					<s:iterator var="emp" value="#request.empList" status="sta">
						<tr>
							<td><s:property value="#sta.count" /></td>
							<td><s:property value="#emp.id" /></td>
							<td><s:property value="#emp.name" /></td>
							<td><s:property value="#emp.salary" /></td>
							<td><s:property value="#emp.dept.name" /></td>
							<!--判断是否登录 -->
							<s:if test="#session.loginInfo!=null">
								<td><s:a href="emp_viewUpdate?id=%{#emp.id}">修改</s:a> <s:a
										href="emp_delete?id=%{#emp.id}">删除</s:a></td>
							</s:if>
							<s:else>
								<td><s:a href="emp_detail?id=%{#emp.id}">查看详情</s:a></td>
							</s:else>

						</tr>
					</s:iterator>
				</s:if>
				<s:else>
					<tr role="2">
						<td colspan="5">对不起，不存在你想要的数据</td>
						<td><input type="button"
							onclick="javascript:history.back(-1)" value="返回"></td>
					</tr>
				</s:else>
			</thead>
		</table>
		<br />
		<!-- 查询部分 -->
		<form action="emp_search" method="post">
			<s:if test="%{#request.searchInfo != null}">
				<input type="text" title="请输入员工名称" value="${searchInfo}"
					onclick="show()" id="search" name="name">
				<input type="submit" value="查询">
			</s:if>
			<s:else>
				<input type="text" title="请输入员工名称" value="请输入员工名称" onclick="show()"
					id="search" name="name">
				<input type="submit" value="查询">
			</s:else>
		</form>
	</div>
	<div style="position: absolute; right: 320px; bottom: 295px;">
		<s:if test="#session.loginInfo!=null">
			<input type="button" onclick="add()" value="添加员工">
		</s:if>
	</div>
</body>
</html>