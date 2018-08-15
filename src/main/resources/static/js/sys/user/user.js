/**
 * 解决跨域请求问题
 */
function fetchJSONMap() {
	// fetchUp();
	byGet();
	byPut();
	byPost();
}


/**
 * jsonp解决跨域问题
 * 
 * @returns
 */
function jsonpReq(){
	$.ajax({
		url : 'http://127.0.0.1:9879/ajax/jsonMap',
		data : {
			param : "ask for map"
		},
		method : "post",
		dataType : "jsonp",
		jsonp : "callback",// 回调参数
		success : function(data) {
		}
	});
}

/**
 * 获取返回值处理方法
 * 
 * @param data
 *            返回值
 */
function callback(data) {
	console.log(data);
	console.log(data.project);
}


/**
 * Using fetch to visit service
 * 
 * @returns
 */
function fetchUp(){
	var url="http://127.0.0.1:9879/getAjax/123";
	var formData = new FormData();  
	formData.append("param","admin");  
	  
	fetch(url , {  
		 method: 'POST',  
		 headers: {},
		 body: formData
	}).then((response) => response.json() 
	).then((json) => {  
		alert(JSON.stringify(json));  
	}).catch((error) => {  
		console.log(error);  
	});  
}



/**
 * 测试Get接口
 * 
 * @returns
 */
function byGet(){
	var url="http://127.0.0.1:9879/ajax/getAjax/123";
	fetch(url , {  
		 method: 'GET'  
	}).then((response) => response.json() 
	).then((json) => {  
		alert(JSON.stringify(json));  
	}).catch((error) => {  
		console.log(error);  
	});
}



/**
 * 测试Put接口
 * 
 * @returns
 */
function byPut(){
	var url="http://127.0.0.1:9879/ajax/addAjax";
	var fd = new FormData();
	fd.append("name","白日梦想家");
	fd.append("date","2010");
	fd.append("score","8.9");
	
	fetch(url , {  
		 method: 'PUT',
		 body : fd
	}).then((response) => response.json() 
	).then((json) => {  
		alert(JSON.stringify(json));  
	}).catch((error) => {  
		console.log(error);  
	});
}

/**
 * 测试Put接口
 * 
 * @returns
 */
function byPost(){
	var url="http://127.0.0.1:9879/ajax/postAjax";
	var fd = new FormData();
	fd.append("name","白日梦想家");
	fd.append("date","2010");
	fd.append("score","8.9");
	
	fetch(url , {  
		 method: 'POST',
		 body: fd
	}).then((response) => response.json() 
	).then((json) => {  
		alert(JSON.stringify(json));  
	}).catch((error) => {  
		console.log(error);  
	});
}