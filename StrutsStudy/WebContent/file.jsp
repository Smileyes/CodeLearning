<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文件上传</title>
</head>
<body>
	<form action="${pageContext.servletContext.contextPath}/upload"
		method="post" enctype="multipart/form-data">
		<input type="file" name="upFile"> <br /> <input type="submit"
			value="上传">

	</form>
	<br />
	<span> <a href="${pageContext.servletContext.contextPath}/list">列表</a>
	</span>
</body>
</html>