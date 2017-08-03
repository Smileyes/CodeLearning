<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<script type="text/javascript" src="ajax.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>省份与城市</title>
</head>
<body onload="showProvince()">
	<select id="province" style="width: 80px;">
		<option>选择省份</option>
	</select>
	<select id="city" style="width: 80px;">
		<option>选择城市</option>
	</select>
</body>

<!--  省份 -->
<script type="text/javascript">
	var proElement = document.getElementById("province");
	var ajax = createAJAX();
	function showProvince() {
		var method = "get";
		var url = "proCity?method=province&time=" + new Date().getTime();
		ajax.open(method, url);
		ajax.send(null);
		ajax.onreadystatechange = function() {
			if (ajax.readyState == 4) {
				if (ajax.status == 200) {
					var xmlElement = ajax.responseXML;
					var proArray = xmlElement.getElementsByTagName("province");
					var size = proArray.length;
					for (var i = 0; i < size; i++) {
						var optionElement = document.createElement("option");
						optionElement.innerHTML = proArray[i].firstChild.nodeValue;
						proElement.appendChild(optionElement);
					}
				}
			}
		}
	}
</script>
<!-- 城市 -->
<script type="text/javascript">
	document.getElementById("province").onchange = function() {
		//获得城市下拉框
		var cityElement = document.getElementById("city");
		//清楚原有的数据
		cityElement.options.length = 1;
		//所选择的省份序号
		var index = this.selectedIndex;
		//所选择的省份内容
		var selectedElement = this[index];
		var province = selectedElement.innerHTML;
		if ("选择省份" != province) {
			var ajax = createAJAX();
			var method = "POST";
			var url = "proCity?time=" + new Date().getTime();
			var content = "province=" + province;
			ajax.open(method, url);
			ajax.setRequestHeader("content-type",
					"application/x-www-form-urlencoded");
			ajax.send(content);
			ajax.onreadystatechange = function() {
				if (ajax.readyState == 4) {
					if (ajax.status == 200) {
						var cityXML = ajax.responseXML;
						var cityArray = cityXML.getElementsByTagName("city");
						var size = cityArray.length;
						for (var i = 0; i < size; i++) {
							var optionElement = document
									.createElement("option");
							optionElement.innerHTML = cityArray[i].firstChild.nodeValue;
							cityElement.appendChild(optionElement);
						}
					}
				}
			}
		}
	}
</script>
</html>