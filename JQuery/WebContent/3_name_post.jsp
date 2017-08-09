<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户名检查POST方式</title>
</head>
<body>
	用户名【POST】：
	<input type="text" id="userName">
	<span id="testUserName"></span>
</body>
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	$("#userName").blur(function() {
		var name = $(this).val();
		if (name.length >= 3) {
			var url = "user?time=" + new Date().getTime();
			var sendData = {
				"userName" : name
			};
			$.post(url, sendData, function(backData) {
				$("#testUserName").text(backData);
			});
		} else {
			$("#testUserName").text("用户名长度应不少于3个字符");
		}
	});
</script>
</html>

