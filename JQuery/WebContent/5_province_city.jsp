<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>省份与城市</title>
</head>
<body>
	<select id="province" style="width: 80px;">
		<option>选择省份</option>
	</select>
	<select id="city" style="width: 80px;">
		<option>选择城市</option>
	</select>
</body>

<!--  省份 -->
<script type="text/javascript">
	$(showProvince());
	function showProvince() {
		var url = "proCity?time=" + new Date().getTime();
		$.get(url, {}, function(backData) {
			var $pros = $(backData).find("province");
			var $pro = $("#province");
			$pros.each(function() {
				var $option = $("<option></option>");
				$option.text($(this).text());
				$pro.append($option);
			});
		});
	}
</script>
<!-- 城市 -->
<script type="text/javascript">
	$("#province").change(function() {
		//获得选择的省份信息
		var province = $("#province option:selected").text();
		$("#city option:gt(0)").remove();
		if ("选择省份" != province) {
			$.ajax({
				type :"POST",
				url : "proCity?time" + new Date().getTime(),
				data : {
					"province" : province
				},
				success : function(data) {
					var $city = $("#city");
					$(data).find("city").each(function() {
						var $option = $("<option></option>").text($(this).text());
						$city.append($option);
					});
				}
			}

			)
		}else{
			$("#city").children().length=1;
		}
	});
</script>
</html>