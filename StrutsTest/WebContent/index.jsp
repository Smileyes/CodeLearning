<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.Smileyes.entity.*" isELIgnored="false"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
</head>
<body>
欢迎登录，用户${user.name}.<br/>

pageContext: ${pageContextScope.user.name}<br/>
request: ${requestScope.user.name}<br/>
session: ${sessionScope.user.name}<br/>
application: ${applicationScope.user.name}<br/>
</body>
</html>