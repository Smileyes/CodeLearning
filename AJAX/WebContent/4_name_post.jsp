<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户名检查POST方式</title>
</head>
<script type="text/javascript" src="ajax.js"></script>
<body>
	用户名【POST】：
	<input type="text" id="userName">
	<span id="testUserName"></span>
</body>
<script type="text/javascript">
	document.getElementById("userName").onblur = function() {
		var ajax = createAJAX();
		var name = this.value;
		if (name.length >= 3) {
			var method = "post";
			var url = "user?time=" + new Date().getTime();
			var content = "userName=" + name;
			ajax.open(method, url);
			ajax.setRequestHeader("content-type",
					"application/x-www-form-urlencoded");
			ajax.send(content);
			ajax.onreadystatechange = function() {
				if (ajax.readyState == 4) {
					if (ajax.status == 200) {
						document.getElementById("testUserName").innerHTML = ajax.responseText;
					}
				}
			}
		} else {
			document.getElementById("testUserName").innerHTML = "用户名长度应不少于3个字符";
		}
	}
</script>
</html>

