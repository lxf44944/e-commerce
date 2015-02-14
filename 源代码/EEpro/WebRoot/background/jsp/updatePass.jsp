<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>修改密码</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" type="text/css" href="<%=path%>/css/main.css">
<link rel="stylesheet" type="text/css" href="<%=path%>/css/reg.css">
<script language="javascript" src="<%=path%>/js/calendar.js"
	charset="GBK"></script>
<script language="javascript" >
function testSoldpass() {
	// 密码: 必填; 且长度不小于3;
	var pass = sform.spass.value;
	var passSp = document.getElementById("soldpassSp");
	var regex = /^(\w){3,15}$/;
	if (pass != null && pass != "") {
		if (regex.test(pass)) {
			passSp.innerHTML = "<img src=\"front/image/agree_ok.gif\"/><font color=\"green\">密码合法</font>";
			return true;
		} else {
			passSp.innerHTML = "<img src=\"front/image/agree_no.gif\"/><font color=\"red\">密码长度不合法，长度应该在3-15字符!</font>";
		}
	} else {
		passSp.innerHTML = "<img src=\"front/image/agree_no.gif\"/><font color=\"red\">密码不能为空!</font>";
	}
	return false;
}

function testSpass() {
	// 密码: 必填; 且长度不小于3;
	var pass = sform.spass.value;
	var passSp = document.getElementById("spassSp");
	var regex = /^(\w){3,15}$/;
	if (pass != null && pass != "") {
		if (regex.test(pass)) {
			passSp.innerHTML = "<img src=\"front/image/agree_ok.gif\"/><font color=\"green\">密码合法</font>";
			return true;
		} else {
			passSp.innerHTML = "<img src=\"front/image/agree_no.gif\"/><font color=\"red\">密码长度不合法，长度应该在3-15字符!</font>";
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

function checkSform() {
	var t = testSoldpass() && testSrepass() && testSpass();
	// alert(t);
	return t;
}
</script>
</head>

<body>
	<form method="post" action="<%=path %>/UpdateBasicServlet?task=pass&suser=${sessionScope.suser}" name="sform"
		onsubmit="return checkSform();">
		<table width=800 height=100 border=0 cellpadding=5 align="center">
			<caption
				style="font-size: 20px;padding-bottom: 20px;padding-top: 30px">修改密码</caption>
			<tr>
				<td>旧&nbsp;密&nbsp;码： <input type="password"
					name="soldpass" /> <span id="soldpassSp"></span>
				</td>
			</tr>
			<tr>
				<td>密&nbsp;&nbsp;&nbsp;&nbsp;码： <input type="password"
					name="spass" /> <span id="spassSp"></span>
				</td>
			</tr>
			<tr>
				<td>确认密码： <input type="password" name="srepass" /> <span
					id="srepassSp"></span>
				</td>
			</tr>
			
			<tr>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="submit" value="修改" title="修改"
					style="border:none;width:100px; height:38px; cursor:pointer " />
					&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="重置" title="重置"
					style="border:none;width:100px; height:38px; cursor:pointer " /></td>

			</tr>
		</table>
	</form>
</body>
</html>
