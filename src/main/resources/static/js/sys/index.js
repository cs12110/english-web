$(function() {
    adminLoginCheck();
    customerLoginCheck();
    getCurrentExam();
    displayCustomerInfo();
});

function adminLoginCheck() {
    $.ajax({
        url: "/admin/loginCheck",
        type: "post",
        data: {

        },
        dataType: "json",
        success: function(data) {
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
        url: "/customer/loginCheck",
        type: "post",
        data: {

        },
        dataType: "json",
        success: function(data) {
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
        url: "/admin/deleteAll",
        type: "post",
        data: {
        },
        dataType: "json",
        success: function(data) {
            if (data.status == 1) {
                sysTips("删除成功", 3);
                $("#sysTips").modal();
            } else {
                sysTips("请联系管理员");
            }
        }
    })
}

function adminLogin() {
    var user = {
        "userName": "",
        "password": ""
    }

    user.userName = $("#loginName").val();
    user.password = $("#loginPassword").val();

    if ('' == user.userName) {
        $("#tips").text("请输入账号");
        $("#sysTips").modal();
        sysTips("请输入账号");
        return;
    }

    if ('' == user.password) {
        sysTips("请输入密码");
        return;
    }

    $.ajax({
        url: "/admin/login",
        data: user,
        dataType: "json",
        success: function(data) {
            if (data.status != 1) {
                sysTips(data.message);
            } else {
                sysTips("登录成功", 3);
                displayAdminArea();
                $("#adminLogin").modal('hide');
            }
        }
    })
}

function logout() {
    $.ajax({
        url: "/admin/logout",
        data: {},
        dataType: "json",
        success: function(data) {
            if (data.status != 1) {
                sysTips(data.message);
            } else {
                sysTips("退出成功",3);
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
        url: "/customer/logout",
        data: {},
        dataType: "json",
        success: function(data) {
            if (data.status != 1) {
                sysTips(data.message, 3);
                window.location.reload();
            } else {
                sysTips("退出成功", 3);
                hiddeAdminArea();
                window.location.reload();
            }
        }
    })
}

function displayCustomerInfo(){
	$.ajax({
		url:"/customer/current/",
		data:{
			
		},
		dataType:"json",
		success:function(data){
			if(data.status==1){
				var ctm = data.data;
				$("#infoArea").text("学号: "+ctm.code);
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
        url: "/progress/current",
        data: {},
        dataType: "json",
        success: function(data) {
            if (data.status == 1) {
                var progress = data.data;
                $("input[name=progress][value=" + progress.paper + "]").prop(
                    "checked", true);
                $("#examArea").text("试题: "+progress.name);
            } else {
                sysTips(data.message);
            }
        }
    })
}

function updateProgress() {
    var paper = $("input[name=progress]:checked").val();
    $.ajax({
        url: "/progress/update",
        data: {
            "paper": paper
        },
        dataType: "json",
        success: function(data) {
            if (data.status == 1) {
                sysTips("更新成功", 3);
                $("#progress").modal('hide');
            } else {
                sysTips(data.message, 3);
            }
        }
    });
}


/**
 * 系统提示
 * @param {*} msg 信息
 * @param {*} second  弹出停留秒数
 */
function sysTips(msg, second) {
    $("#sys-alert").modal();
    $("#sys-tips").text(msg);
    if (second != undefined && second > 0) {
        setTimeout(() => {
            $("#sys-alert").modal('hide');
        }, second * 1000);
    }
}


function computeScore(){
	var code = $("input[name=customerCode]").val();
	if(code==undefined || code.trim()==""){
		sysTips("请输入学号",2);
		return;
	}
	window.location.href='/admin/export?code='+code;
}