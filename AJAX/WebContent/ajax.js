/**
 * 生成AJAX对象
 */
function createAJAX() {
	var ajax = null;
	try {
		ajax = new ActiveXObject("miscrosoft.xmlhttp");
	} catch (e) {
		try {
			ajax = new XMLHttpRequest();
		} catch (e) {
			alert("请使用Chrome或FireFox");
		}
	}
	return ajax;
}