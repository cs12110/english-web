$(function() {
	loginCheck();
});

function loginCheck() {
	$.ajax({
		url : "/admin/loginCheck",
		type : "post",
		data : {

		},
		dataType : "json",
		success : function(data) {
			if (data.status == 1) {
				displayAdminArea();
			} else {
				hiddeAdminArea();
			}
		}
	})
}

function deleteAll() {
	$.ajax({
		url : "/admin/deleteAll",
		type : "post",
		data : {

		},
		dataType : "json",
		success : function(data) {
			if (data.status == 1) {
				alert("删除成功");
			} else {
				alert("请联系管理员");
			}
		}
	})
}

function adminLogin() {
	var user = {
		"userName" : "",
		"password" : ""
	}

	user.userName = $("#loginName").val();
	user.password = $("#loginPassword").val();

	if ('' == user.userName) {
		alert("请输入账号");
		return;
	}

	if ('' == user.password) {
		alert("请输入密码");
		return;
	}

	$.ajax({
		url : "/admin/login",
		data : user,
		dataType : "json",
		success : function(data) {
			if (data.status != 1) {
				alert(data.message);
			} else {
				alert("登录成功");
				displayAdminArea();
			}
		}
	})
}

function logout() {
	$.ajax({
		url : "/admin/logout",
		data : {},
		dataType : "json",
		success : function(data) {
			if (data.status != 1) {
				alert(data.message);
			} else {
				alert("退出成功");
				hiddeAdminArea();
			}
		}
	})
}

function displayAdminArea() {
	$(".power").show();
	$(".divider").show();
}

function hiddeAdminArea() {
	$(".power").hide();
	$(".divider").hide();
}
