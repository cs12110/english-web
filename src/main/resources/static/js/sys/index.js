$(function() {
	adminLoginCheck();
	customerLoginCheck();
});

function adminLoginCheck() {
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

function customerLoginCheck() {
	$.ajax({
		url : "/customer/loginCheck",
		type : "post",
		data : {

		},
		dataType : "json",
		success : function(data) {
			if (data.status == 1) {
				$("#handsup").hide();
				$("#after-all").show();
			} else {
				$("#handsup").show();
				$("#after-all").hide();
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
				$("#sysTips").modal();
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
		$("#tips").text("请输入账号");
		$("#sysTips").modal();
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
				$("#adminLogin").modal('hide');
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

function openInfoWindow() {
	$("#myModal").modal();
}

function customerLogout() {
	$.ajax({
		url : "/customer/logout",
		data : {},
		dataType : "json",
		success : function(data) {
			if (data.status != 1) {
				alert(data.message);
				window.location.reload();
			} else {
				alert("退出成功");
				hiddeAdminArea();
			}
		}
	})
}

/**
 * 获取当前的测试
 * 
 * @returns
 */
function getCurrentExam() {
	$.ajax({
		url : "/progress/current",
		data : {},
		dataType : "json",
		success : function(data) {
			if (data.status == 1) {
				var progress = data.data;
				$("input[name=progress][value=" + progress.paper + "]").prop(
						"checked", true);
			} else {
				alter(data.message);
			}
		}
	})
}

function updateProgress() {
	var paper = $("input[name=progress]:checked").val();
	$.ajax({
		url : "/progress/update",
		data : {
			"paper" : paper
		},
		dataType : "json",
		success : function(data) {
			if (data.status == 1) {
				alert("更新成功");
				$("#progress").modal('hide');
			}else{
				alert(data.message);
			}
		}
	});

	console.log(paper);
}