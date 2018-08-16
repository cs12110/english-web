function saveCustomer() {
	var customer = new Object();
	customer.name = getValue("name");
	customer.code = getValue("code");
	customer.age = getValue("age");
	customer.engAge = getValue("engAge");
	customer.cet4 = getValue("cet4");
	customer.cet6 = getValue("cet6");
	customer.gender = $("input[name=gender]:checked").val();
	customer.major = getValue("major");

	console.log(customer);

	var result = check(customer);
	if (!result.success) {
		alert(result.message);
		return;
	}

	$.ajax({
		url : "/customer/save",
		type : "post",
		dataType : "json",
		data : customer,
		success : function(data) {
			if (data.status == 1) {
				alert("新增成功");
				$("#myModal").modal('hide');
			} else {
				alert("新增失败,请联系管理员");
			}
		}
	})

}

function check(ctm) {
	var result = {
		"success" : true,
		"message" : ""
	};

	if (ctm.code == undefined || ctm.code == "") {
		result.success = false;
		result.message = "学号为必填字段";
		return result;
	}

	var reg = new RegExp("^[0-9]{1,4}$");

	var age = ctm.age;
	if (age.trim() != "") {
		if (!reg.test(age)||age>=150) {
			result.success = false;
			result.message = "年龄必须为整数,且<=150";
			return result;
		}
	}

	var engAge = ctm.engAge;
	if (engAge.trim() != "") {
		if (!reg.test(engAge) || engAge > 150) {
			result.success = false;
			result.message = "英语学习年龄必须为整数,且<=150";
			return result;
		}
	}

	var cet4 = ctm.cet4;
	if (cet4.trim() != "") {
		if (!reg.test(cet4) || cet4 > 710) {
			result.success = false;
			result.message = "cet4分数必须为整数,且<=710";
			return result;
		}
	}

	var cet6 = ctm.cet6;
	if (cet6.trim() != "") {
		if (!reg.test(cet6) || cet6 > 710) {
			result.success = false;
			result.message = "cet6分数必须为整数,且<=710";
			return result;
		}
	}

	return result;
}

function getValue(inputId) {
	return $("#" + inputId).val();
}