function testSuser() {
	// 用户名: 必填, 且长度不小于3;
	var user = sform.suser.value;
	var userSp = document.getElementById("suserSp");
	// var sname = document.all.sname.value;
	// 邮编校验
	// var regex = /[0-9]{6}/;//\d
	// 邮编校验
	// var regex = /^\d{6}$/;//\d
	// 6个大小写字母
	// var regex = /^[a-zA-Z]{6}$/;//\d
	// 邮箱验证 包括.或者两个.
	// var regex = /^\w+@\w+\.\w+\.?\w+$/;
	var regex = /^([a-zA-Z0-9]|[._]){3,12}$/;

	// alert(regex.test(sname));
	if (user != null && user != "") {
		if (regex.test(user)) {
			userSp.innerHTML = "<img src=\"front/image/agree_ok.gif\"/><font color=\"green\">用户名合法</font>";
			return true;
		} else {
			userSp.innerHTML = "<img src=\"front/image/agree_no.gif\"/><font color=\"red\">用户名长度不合法，长度应该在3-12字符!</font>";
		}
	} else {
		userSp.innerHTML = "<img src=\"front/image/agree_no.gif\"/><font color=\"red\">用户名不能为空!</font>";
	}
	return false;
}

function testSpass() {
	// 密码: 必填; 且长度不小于3;
	var pass = sform.spass.value;
	var passSp = document.getElementById("spassSp");
	var regex = /^(\w){6,16}$/;
	if (pass != null && pass != "") {
		if (regex.test(pass)) {
			passSp.innerHTML = "<img src=\"front/image/agree_ok.gif\"/><font color=\"green\">密码合法</font>";
			return true;
		} else {
			passSp.innerHTML = "<img src=\"front/image/agree_no.gif\"/><font color=\"red\">密码长度不合法，长度应该在6-16字符!</font>";
		}
	} else {
		passSp.innerHTML = "<img src=\"front/image/agree_no.gif\"/><font color=\"red\">密码不能为空!</font>";
	}
	return false;
}

function testSrepass() {
	// 确认密码: 值要和 密码框的值 相同
	var pass = sform.spass.value;
	var repass = sform.srepass.value;
	var repassSp = document.getElementById("srepassSp");
	if (pass == repass) {

		repassSp.innerHTML = "<img src=\"front/image/agree_ok.gif\"/><font color=\"green\">确认密码正确</font>";
		return true;
	} else {
		repassSp.innerHTML = "<img src=\"front/image/agree_no.gif\"/><font color=\"red\">确认密码与密码不一致!</font>";
	}

	return false;
}

function testSname() {
	// 真实姓名 : 必填; 且长度不能大于 15

	var name = sform.sname.value.replace(/^\s+|\s+$/g,"");
	var nameSp = document.getElementById("snameSp");
//	regex = /^a{0,15}$/;
//	regex = /^([\u4e00-\u9fa5]+|([a-z]+\s?)+)$/;
	if (name != null && name != "") {
		if (name.length <= 15) {
			nameSp.innerHTML = "<img src=\"front/image/agree_ok.gif\"/><font color=\"green\">真实姓名合法</font>";
			return true;
		} else {
			nameSp.innerHTML = "<img src=\"front/image/agree_no.gif\"/><font color=\"red\">真实姓名长度不合法，长度不能大于15个字符!</font>";
		}
	} else {
		nameSp.innerHTML = "<img src=\"front/image/agree_no.gif\"/><font color=\"red\">真实姓名不能为空!</font>";
	}
	return false;
}

function testSdate() {
	// 出生日期: 必填
	var date = sform.sdate.value;
	var dateSp = document.getElementById("sdateSp");
	if (date != null && date != "") {

		dateSp.innerHTML = "<img src=\"front/image/agree_ok.gif\"/><font color=\"green\">出生日期合法</font>";
		return true;
	} else {
		dateSp.innerHTML = "<img src=\"front/image/agree_no.gif\"/><font color=\"red\">出生日期必填!</font>";
	}

	return false;
}

function testSemail() {
	// 电子邮箱: 必填
	var email = sform.semail.value;
	var emailSp = document.getElementById("semailSp");
	var regex = /^\w+@\w+\.\w+\.?\w+$/;
	if (email != null && email != "") {
		if (regex.test(email)) {
			emailSp.innerHTML = "<img src=\"front/image/agree_ok.gif\"/><font color=\"green\">电子邮箱合法</font>";
			return true;
		} else {
			emailSp.innerHTML = "<img src=\"front/image/agree_no.gif\"/><font color=\"red\">电子邮箱格式错误!</font>";
		}

	} else {
		emailSp.innerHTML = "<img src=\"front/image/agree_no.gif\"/><font color=\"red\">电子邮箱必填!</font>";
	}
	return false;

}

function testSnumber() {
	// 电话号码: 必填, 且是数字;

	var number = sform.snumber.value;
	var numberSp = document.getElementById("snumberSp");
	var regex = /^\d+$/;// \d
	if (number != null && number != "") {
		if (regex.test(number)) {
			numberSp.innerHTML = "<img src=\"front/image/agree_ok.gif\"/><font color=\"green\">电话号码合法</font>";
			return true;
		} else {
			numberSp.innerHTML = "<img src=\"front/image/agree_no.gif\"/><font color=\"red\">电话号码必须是数字!</font>";
		}
	} else {
		numberSp.innerHTML = "<img src=\"front/image/agree_no.gif\"/><font color=\"red\">电话号码不能为空!</font>";
	}
	return false;
}

function testSadress() {
	// 地址: 必填, 且长度不能大于100

	var adress = sform.sadress.value.replace(/^\s+|\s+$/g,"");
	var adressSp = document.getElementById("sadressSp");

	if (adress != null && adress != "") {
		if (adress.length <= 100) {
			adressSp.innerHTML = "<img src=\"front/image/agree_ok.gif\"/><font color=\"green\">地址合法</font>";
			return true;
		} else {
			adressSp.innerHTML = "<img src=\"front/image/agree_no.gif\"/><font color=\"red\">地址长度不合法，长度不能大于100个字符!</font>";
		}
	} else {
		adressSp.innerHTML = "<img src=\"front/image/agree_no.gif\"/><font color=\"red\">地址不能为空!</font>";
	}
	return false;
}

function testSpostcode() {
	// 邮编: 必填, 且是6位数字;

	var postcode = sform.spostcode.value;
	var postcodeSp = document.getElementById("spostcodeSp");
	var regex = /^\d{6}$/;// \d
	if (postcode != null && postcode != "") {
		if (regex.test(postcode)) {
			postcodeSp.innerHTML = "<img src=\"front/image/agree_ok.gif\"/><font color=\"green\">邮编合法</font>";
			return true;
		} else {
			postcodeSp.innerHTML = "<img src=\"front/image/agree_no.gif\"/><font color=\"red\">邮编必须为六位数字!</font>";
		}
	} else {
		postcodeSp.innerHTML = "<img src=\"front/image/agree_no.gif\"/><font color=\"red\">邮编不能为空!</font>";
	}
	return false;
}

function checkSform() {
	var t = testSuser() && testSpass() && testSrepass() && testSname()
			&& testSdate() && testSemail() && testSnumber() && testSadress()
			&& testSpostcode();
	// alert(t);
	return t;
}