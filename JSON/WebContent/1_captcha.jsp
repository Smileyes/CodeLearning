<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>验证码</title>
<link rel="image/x-icon" type="shortcut icon" href="head.ico">
</head>
<body>
	验证码：
	<input type="text" id="codeId" maxlength="4">
	<span id="result"></span>
	<br>
	<img src="image.jsp" id="code" onclick="refresh()">
</body>
<script type="text/javascript" src="ajax.js"></script>
<script type="text/javascript">
	// 验证码
	function refresh() {
		var code = document.getElementById("code");
		code.src = "image.jsp?time=" + new Date().getTime();
	}
	// 	检查输入
	document.getElementById("codeId").oninput = function() {
		this.value = this.value.replace(/[\u4e00-\u9fa5]|\s/g, '');
		var code = this.value;
		if (code.length == 4) {
			var ajax = createAJAX();
			var method = "POST";
			var url = "code?time=" + new Date().getTime();
			var content = "CHECKNUM=" + code;
			ajax.open(method, url);
			ajax.setRequestHeader("content-type",
					"application/x-www-form-urlencoded");
			ajax.send(content);
			ajax.onreadystatechange = function() {
				if (ajax.readyState == 4) {
					if (ajax.status == 200) {
						var result = ajax.responseText;
						if (result == "image/Error.gif") {
							refresh();
						}
						var img = document.createElement("img");
						img.src = result;
						img.width = 15;
						img.height = 15;
						document.getElementById("result").appendChild(img);
					}
				}
			}
		} else {
			document.getElementById("result").innerHTML = "";
		}
	}
</script>
</html>