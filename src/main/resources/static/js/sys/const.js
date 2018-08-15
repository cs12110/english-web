/**
 * websocket调用地址
 */
var websocketServerUrl = "ws://10.10.2.73:9900/websocket";

/**
 * 获取格式化的当前时间
 * 
 * 日期格式: yyyy-MM-dd HH:mm:ss
 */
function getFormatDate() {
	var date = new Date();
	var seperator1 = "-";
	var seperator2 = ":";

	var month = fixDate(date.getMonth() + 1);
	var day = fixDate(date.getDate());
	var hour = fixDate(date.getHours());
	var minute = fixDate(date.getMinutes());
	var second = fixDate(date.getSeconds());

	return date.getFullYear() + seperator1 + month + seperator1 + day + " "
			+ hour + seperator2 + minute + seperator2 + second;
}

/**
 * 将[1-9]之间的月份或天前面添加0
 * 
 * @param num
 *            月份或天数
 * @returns String
 */
function fixDate(num) {
	if (num > 10) {
		return num;
	}
	return "0" + num;
}