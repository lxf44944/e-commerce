
function testSname() {
	// 真实姓名 : 必填; 且长度不能大于 15

	var name = sform.sname.value;
	var nameSp = document.getElementById("snameSp");
	
	if (name != null && name != "") {
		if (name.length <= 10&&name.length>=2) {
			nameSp.innerHTML = "<img src=\"front/image/agree_ok.gif\"/><font color=\"green\">收货人姓名姓名合法</font>";
			return true;
		} else {
			nameSp.innerHTML = "<img src=\"front/image/agree_no.gif\"/><font color=\"red\">收货人姓名长度不合法，长度2-10个字符!</font>";
		}
	} else {
		nameSp.innerHTML = "<img src=\"front/image/agree_no.gif\"/><font color=\"red\">收货人姓名不能为空!</font>";
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
			emailSp.innerHTML = "<img src=\"front/image/agree_ok.gif\"/><font color=\"green\">收货人邮箱合法</font>";
			return true;
		} else {
			emailSp.innerHTML = "<img src=\"front/image/agree_no.gif\"/><font color=\"red\">收货人邮箱格式错误!</font>";
		}

	} else {
		emailSp.innerHTML = "<img src=\"front/image/agree_no.gif\"/><font color=\"red\">收货人邮箱必填!</font>";
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
			numberSp.innerHTML = "<img src=\"front/image/agree_ok.gif\"/><font color=\"green\">收货人电话合法</font>";
			return true;
		} else {
			numberSp.innerHTML = "<img src=\"front/image/agree_no.gif\"/><font color=\"red\">收货人电话必须是数字!</font>";
		}
	} else {
		numberSp.innerHTML = "<img src=\"front/image/agree_no.gif\"/><font color=\"red\">收货人电话不能为空!</font>";
	}
	return false;
}

function testSadress() {
	// 地址: 必填, 且长度不能大于100

	var adress = sform.sadress.value;
	var adressSp = document.getElementById("sadressSp");

	if (adress != null && adress != "") {
		if (adress.length <= 100 && adress.length >= 3) {
			adressSp.innerHTML = "<img src=\"front/image/agree_ok.gif\"/><font color=\"green\">收货人地址合法</font>";
			return true;
		} else {
			adressSp.innerHTML = "<img src=\"front/image/agree_no.gif\"/><font color=\"red\">收货人地址长度不合法，长度3-100个字符!</font>";
		}
	} else {
		adressSp.innerHTML = "<img src=\"front/image/agree_no.gif\"/><font color=\"red\">收货人地址不能为空!</font>";
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
			postcodeSp.innerHTML = "<img src=\"front/image/agree_ok.gif\"/><font color=\"green\">收货人邮编合法</font>";
			return true;
		} else {
			postcodeSp.innerHTML = "<img src=\"front/image/agree_no.gif\"/><font color=\"red\">收货人邮编必须为六位数字!</font>";
		}
	} else {
		postcodeSp.innerHTML = "<img src=\"front/image/agree_no.gif\"/><font color=\"red\">收货人邮编不能为空!</font>";
	}
	return false;
}

function checkSform() {
	var t =  testSname() && testSemail() && testSnumber() && testSadress() && testSpostcode();
	// alert(t);
	return t;
}