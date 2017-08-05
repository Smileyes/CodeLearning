<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>省份-城市-区域</title>
</head>
<body onload="showPronvince()">
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
<script type="text/javascript" src="ajax.js"></script>
<script type="text/javascript">
	var proEle = document.getElementById("provinceId");
	var cityEle = document.getElementById("cityId");
	var areaEle = document.getElementById("areaId");
	// 初始化时省份(GET)
	function showPronvince() {
		var ajax = createAJAX();
		var method = "GET";
		var url = "find_province?time=" + new Date().getTime();
		ajax.open(method, url);
		ajax.send(null);
		ajax.onreadystatechange = function() {
			if (ajax.readyState == 4) {
				if (ajax.status == 200) {
					var jsonJAVA = ajax.responseText;
					var jsonJS = eval("(" + jsonJAVA + ")");
					var list = jsonJS.result;
					for (var i = 0; i < list.length; i++) {
						var option = document.createElement("option");
						option.innerHTML = list[i];
						proEle.appendChild(option);
					}
				}
			}
		}
	}
</script>
<script type="text/javascript">
	//城市
	proEle.onchange = function() {
		//清除之前的城市与地区信息
		cityEle.options.length = 1;
		areaEle.options.length = 1;
		areaEle.disabled = true;
		//改变后的项目不是“选择省份”
		if (this.selectedIndex != 0) {
			cityEle.disabled = false;
			var ajax = createAJAX();
			var method = "POST";
			var url = "find_city?time=" + new Date().getTime();
			ajax.open(method, url);
			var content = "sourceName=" + this[this.selectedIndex].innerHTML;
			ajax.setRequestHeader("content-type",
					"application/x-www-form-urlencoded");
			ajax.send(content);
			ajax.onreadystatechange = function() {
				if (ajax.readyState == 4) {
					if (ajax.status == 200) {
						var jsonJAVA = ajax.responseText;
						var jsonJS = eval("(" + jsonJAVA + ")");
						var size = jsonJS.result.length;
						for (var i = 0; i < size; i++) {
							var option = document.createElement("option");
							option.innerHTML = jsonJS.result[i];
							cityEle.appendChild(option);
						}
					}
				}
			}
		} else {
			cityEle.disabled = true;
		}
	}
</script>
<script type="text/javascript">
	//地区
	cityEle.onchange = function() {
		//清除之前的地区信息
		areaEle.options.length = 1;
		//改变后的项目不是“选择城市”
		if (this.selectedIndex != 0) {
			areaEle.disabled = false;
			var ajax = createAJAX();
			var method = "POST";
			var url = "find_area?time=" + new Date().getTime();
			ajax.open(method, url);
			var content = "sourceName=" + this[this.selectedIndex].innerHTML;
			ajax.setRequestHeader("content-type",
					"application/x-www-form-urlencoded");
			ajax.send(content);
			ajax.onreadystatechange = function() {
				if (ajax.readyState == 4) {
					if (ajax.status == 200) {
						var jsonJAVA = ajax.responseText;
						var jsonJS = eval("(" + jsonJAVA + ")");
						var size = jsonJS.result.length;
						for (var i = 0; i < size; i++) {
							var option = document.createElement("option");
							option.innerHTML = jsonJS.result[i];
							areaEle.appendChild(option);
						}
					}
				}
			}
		} else {
			areaEle.disabled = true;
		}
	}
</script>
</html>