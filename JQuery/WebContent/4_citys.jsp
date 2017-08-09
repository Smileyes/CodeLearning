<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>城市列表解析XML</title>
<!-- var $xml = $(xml).find("city"); -->
</head>
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<body>
	<table border="1" align="center" width="60%">
		<thead>
			<tr>
				<td>序号</td>
				<td>城市</td>
			</tr>
		</thead>
	</table>
	<input type="button" value="显示列表">
</body>
<!-- 居中样式 -->
<script type="text/javascript">
	$(initAlign());
	function initAlign() {
		$("table").css("borderStyle", "solid").css("borderColor", "black").css(
				"borderCollapse", "seprate");
		myAlign();
		$("input:button").css("position", "absolute").css("left", "644");
	}
	function myAlign() {
		$("tr").css("borderStyle", "solid").css("borderColor", "black").css(
				"borderCollapse", "seprate").css("textAlign", "center");
	}
</script>
<script type="text/javascript">
	$(":button").click(function() {
		var url = "city.xml?time=" + new Date().getTime();
		$.get(url, {}, function(xml) {
			var $xml = $(xml).find("city");
			var i = 1;
			var $table = $("table");
			$xml.each(function() {
				var $tr = $("<tr></tr>");
				var $td1 = $("<td></td>");
				$td1.text(i++);
				var $td2 = $("<td></td>");
				$td2.text($(this).text());
				$tr.append($td1).append($td2);
				$table.append($tr);
				myAlign();
			});
		});
	});
</script>
</html>