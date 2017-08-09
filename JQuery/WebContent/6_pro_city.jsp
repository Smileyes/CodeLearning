<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>省份-城市-区域</title>
</head>
<body>
	<!-- 地址选择 -->
	<div align="center">
		<select id="provinceId">
			<option>选择省份</option>
		</select> <select id="cityId" disabled="true">
			<option>选择城市</option>
		</select> <select id="areaId" disabled="true">
			<option>选择地区</option>
		</select>
	</div>
</body>
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	var $area = $("#areaId");
	// 初始化时省份(GET)
	var $pro = $("#provinceId");
	$(showProvince());
	function showProvince() {
		var url = "find_province.action?time=" + new Date().getTime();
		$.get(url, {}, function(backData) {
			var list = backData.result;
			for (var i = 0; i < list.length; i++) {
				var $option = $("<option></option>").text(list[i]);
				$pro.append($option);
			}
		});
	}
</script>
<script type="text/javascript">
	//城市
	var $city = $("#cityId");
	$pro.change(function() {
		//清楚地区信息
		$area.find("option:gt(0)").remove();
		$area.prop("disabled", "true");
		//清楚城市信息
		$city.find("option:gt(0)").remove();
		var $select = $pro.find("option:selected");
		if ($select.text() != "选择省份") {
			$city.removeAttr("disabled");
			var url = "find_city.action?time=" + new Date().getTime();
			var sendData = {
				"sourceName" : $select.text()
			};
			$.post(url, sendData, function(backData) {
				var list = backData.result;
				for (var i = 0; i < list.length; i++) {
					var $option = $("<option></option>").text(list[i]);
					$city.append($option);
				}
			});
		} else {
			$city.prop("disabled", "true");
		}
	});
</script>

<script type="text/javascript">
	//地区
	var $area = $("#areaId");
	$city.change(function() {
		$area.find("option:gt(0)").remove();
		var $select = $city.find("option:selected");
		if ($select.text() != "选择城市") {
			$area.removeAttr("disabled");
			var url = "find_area.action?time=" + new Date().getTime();
			var sendData = {
				"sourceName" : $select.text()
			};
			$.post(url, sendData, function(backData) {
				var list = backData.result;
				for (var i = 0; i < list.length; i++) {
					var $option = $("<option></option>").text(list[i]);
					$area.append($option);
				}
			});
		} else {
			$area.prop("disabled", "true");
		}
	});
</script>
</html>