<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文件列表</title>
</head>
<body>
	<table align="center">
		<thead align="center">
			<tr align="center">
				<td>序号</td>
				<td>文件名</td>
				<td>操作</td>
			</tr>
		</thead>

		<c:forEach items="${fileList}" var="file1" varStatus="varSta">
			<tr align="center">
				<td>${varSta.count}</td>
				<td>${file1}</td>
				<td><c:url var="url" value="down">
						<c:param name="fileName" value="${file1}" />
					</c:url> <a href="${url}">下载</a></td>
			</tr>
		</c:forEach>
	</table>
	<span style="margin-left: 630px;"> <a
		href="${pageContext.servletContext.contextPath}/file.jsp">上传</a></span>
</body>
</html>