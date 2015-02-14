function testSuser() {
	// 用户名: 必填, 且长度不小于3;
	var user = sform.suser.value;
	var userSp = document.getElementById("suserSp");
	var span = document.getElementById("span");
	// var sname = document.all.sname.value;
	// 邮编校验
	// var regex = /[0-9]{6}/;//\d
	// 邮编校验
	// var regex = /^\d{6}$/;//\d
	// 6个大小写字母
	// var regex = /^[a-zA-Z]{6}$/;//\d
	// 邮箱验证 包括.或者两个.
	// var regex = /^\w+@\w+\.\w+\.?\w+$/;
	var regex = /^([a-zA-Z0-9]|[._]){3,15}$/;

	// alert(regex.test(sname));
	if (user != null && user != "") {
		if (regex.test(user)) {
			userSp.innerHTML = "<img src=\"front/image/agree_ok.gif\"/>";
			return true;
		} else {
			userSp.innerHTML = "<img src=\"front/image/agree_no.gif\"/>";
			span.innerHTML = "<font color=\"red\">用户名长度不合法，长度应该在3-15字符!</font>";
		}
	} else {
		userSp.innerHTML = "<img src=\"front/image/agree_no.gif\"/>";
		span.innerHTML = "<font color=\"red\">用户名不能为空!</font>";
	}
	return false;
}

function testSpass() {
	// 密码: 必填; 且长度不小于3;
	var pass = sform.spass.value;
	var passSp = document.getElementById("spassSp");
	var span = document.getElementById("span");
	var regex = /^(\w){3,15}$/;
	if (pass != null && pass != "") {
		if (regex.test(pass)) {
			passSp.innerHTML = "<img src=\"front/image/agree_ok.gif\"/>";
			return true;
		} else {
			passSp.innerHTML = "<img src=\"front/image/agree_no.gif\"/>";
			span.innerHTML = "<font color=\"red\">密码长度不合法，长度应该在3-15字符!</font>";
		}
	} else {
		passSp.innerHTML = "<img src=\"front/image/agree_no.gif\"/>";
		span.innerHTML = "<font color=\"red\">密码不能为空!</font>";
	}
	return false;
}




function checkSform() {
	var t = testSuser() && testSpass() ;
	// alert(t);
	return t;
}