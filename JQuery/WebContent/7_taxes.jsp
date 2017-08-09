<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>在线税务计算</title>
</head>
<body>
	你的收入为：
	<input type="text">元
	<br> 你需要缴的税金为
	<span></span>
	<br>存储过程:
	<button>计算</button>
	<br>存储函数:
	<button>计算</button>
</body>
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	$(":button:first").click(function() {
		var url = "tax?time=" + new Date().getTime();
		var salary = $(":text").val();
		var sendData = {
			"salary" : salary
		};
		$.get(url, sendData, function(backData) {
			$("span").text(backData);
		});
	});

	$(":button:last").click(function() {
		var url = "tax?time=" + new Date().getTime();
		var salary = $(":text").val();
		var sendData = {
			"salary" : salary
		};
		$.post(url, sendData, function(backData) {
			$("span").text(backData);
		});
	});
</script>

</html>